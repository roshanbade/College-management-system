package com.cms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cms.domain.Book;
import com.cms.domain.Instructor;
import com.cms.domain.StudentInfo;
import com.cms.exception.BookNotFound;
import com.cms.exception.StudentNotFound;
import com.cms.service.BooksService;
import com.cms.service.StudentService;


@Controller
@Transactional
public class LibraryController {
	
	@Autowired
	BooksService booksService;
	
	@Autowired
	StudentService studentService;
	
	
	@RequestMapping(value="/library/add", method=RequestMethod.GET)
	public String addBooksForm(Model model){
		
		Book book = new Book();
		model.addAttribute("newBook", book);
		
		return "addBooks";
	}
	
	@RequestMapping(value = "library/add", method = RequestMethod.POST)
	public String addBooksProcess(@ModelAttribute("newBook")@Valid Book book, BindingResult result){
		
		if(result.hasErrors()){
			return "addBooks";
		}
		
		booksService.addBooks(book);
		return "redirect:/library";
	}
	
	/*@InitBinder
	public void initializeBinder(WebDataBinder binder){
		binder.setAllowedFields("bookId","name", "author", "faculty", "semester", "publisher");
	}*/
	
	@RequestMapping(value = "library/show", method = RequestMethod.GET)
	public String showBooks(Model model){
		Book book = new Book();
		model.addAttribute("showBookById", book);
		
		
		return "bookId";
	}
	
	@RequestMapping(value = "library/show")
	public String showBooksById(@ModelAttribute("showBookById") Book bookId, Model model){
		Book allBooks = booksService.getBookInfoById(bookId.getBookId());
		
	//	if(allBooks == null){
		//	throw new NoBooksFoundUnderThisId();
		//}
		
		model.addAttribute("bookById", allBooks);
		
		return "bookById";
	}
	
	@RequestMapping("library/showAll")
	public String showAllBooks(Model model){
		
		model.addAttribute("listOfBooks", booksService.showAllBooks());
		
		return "showAllBooks";
	}
	
	@RequestMapping(value = "library/update", method = RequestMethod.GET)
	public String updateBook(@RequestParam("bookId") int bookId, Model model){
		Book book = booksService.getBookInfoById(bookId);
		
		model.addAttribute("book", book);
		
		return "updateBook";
	}
	
	@RequestMapping(value = "library/update", method = RequestMethod.POST)
	public String processUpdateBook(@ModelAttribute("book") Book book){
		
		booksService.updateBook(book);
		
		return "redirect:/library/showAll";
	}
	
	@RequestMapping("library/delete")
	public String deleteBook(@RequestParam("bookId") int id){
		Book book = booksService.getBookInfoById(id);
		
		booksService.deleteBOok(book);
		
		return "redirect:/library/showAll";
	}
	
	/*@RequestMapping(value="library/data", method= RequestMethod.GET)
	public String getData(Model model) {
		Instructor instructor = new Instructor();
		
		model.addAttribute("instructor", instructor);
		
		return "getData";
	}
	
	@RequestMapping(value="library/data", method= RequestMethod.POST)
	public String processGetData(Model model, @ModelAttribute() Instructor instructor) {
		
		System.out.println("Instructor " + instructor.getInstructorId());
		
		return "getData";
	}*/
	
	
	
	
	@RequestMapping(value = "library/test", method = RequestMethod.GET)
	public String issueBooksForm(Model model){
	
		StudentInfo student2 = new StudentInfo();
		
		Book book = new Book();
		
		//model.addAttribute("studentObj", student2);
		model.addAttribute("book", book);
		
		return "issueBooks";
	}
	
	@RequestMapping(value = "library/test", method = RequestMethod.POST)
	public String issueBooksProcess(Model model,@ModelAttribute("book") Book book){
		
		//System.out.println(student1.getStudentId());
		//System.out.println(book.getBookId());
		
		if(book.getBookId() > studentService.getStudentInfo().size() || book.getBookId() == 0	){
			throw new StudentNotFound("Student Id " + book.getBookId() + " not found!", book.getBookId());
		}
		
		StudentInfo student = studentService.getStudentById(book.getBookId());
		
		
		Set<Book> bookData = (Set<Book>)student.getListOfBooks();
		
		System.out.println(bookData.size());
		
		Book book1 = new Book();
		model.addAttribute("bookData", bookData);
		model.addAttribute("student", student);
		model.addAttribute("books", book1);
		
		return "studentBooks";
	}
	
	@RequestMapping("library/issued")
	public String booksIssued(@RequestParam("studentId") int studentId,@ModelAttribute("books") Book book, Model model){
		
		System.out.println(book.getBookId());
		Book book2 = null;
		
		StudentInfo student = studentService.getStudentById(studentId);
		
		book2 = booksService.getBookInfoById(book.getBookId());
		
		student.getListOfBooks().add(book);		
		
		/*List<Book> books = student.getListOfBooks();
		for (Book bookie : books) {
			if(bookie.getBookId() == book.getBookId()){
				Book book3 = booksService.getBookInfoById(book.getBookId());
				book2 = book3;
			}
		}*/
		
		studentService.updateStudent(student);
		//booksService.updateBook(book);
		model.addAttribute("student", student);
		
		model.addAttribute("book2", book2);
		return "issuedBooks";
	}
	
	
	
	/*
	 * @ExceptionHandler(BookNotFound.class)
	public String handleError(HttpServletRequest req, BookNotFound exception, Model model){
		
		model.addAttribute("invalidBookId", exception.getBookId());
		model.addAttribute("exception", exception);
		model.addAttribute("url", req.getRequestURI()+ "?" + req.getQueryString());
		return "bookNotFound";
	}
	 */
	
	@ExceptionHandler(BookNotFound.class)
	public ModelAndView handleError(HttpServletRequest req,	BookNotFound exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidBookId", exception.getBookId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		mav.setViewName("bookNotFound");
		return mav;
	}
	
	@ExceptionHandler(StudentNotFound.class)
	public ModelAndView handleError(HttpServletRequest req,	StudentNotFound exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidStudentId", exception.getStudentError());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		mav.setViewName("studentNotFound");
		return mav;
	}
	
	@RequestMapping("/library/deleteStudentBook")
	public String deleteStudentBook(Model model, @RequestParam("bookId") int bookId, @RequestParam("studentId") int studentId){
		
		StudentInfo student = studentService.getStudentById(studentId);
		Book book = booksService.getBookInfoById(bookId);
		student.getListOfBooks().remove(book);
		studentService.updateStudent(student);
		model.addAttribute("student", student);
		
		return "returnBook";
	}
}

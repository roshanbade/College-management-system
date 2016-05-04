package com.cms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
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

import com.cms.domain.StudentInfo;
import com.cms.exception.HandleConstraintViolationException;
import com.cms.service.FacultyService;
import com.cms.service.StudentService;

@Controller
@RequestMapping("/admission")
public class AdmissionController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value="/newStudent", method=RequestMethod.GET)
	public String newStudent(Model model) {
		List<String> facultyNames = facultyService.getAllFacultyName();
		StudentInfo student = new StudentInfo();
		
		model.addAttribute("student", student);
		
		model.addAttribute("facultyNames", facultyNames);
		
		return "newStudent";
	}
	
	@ExceptionHandler(HandleConstraintViolationException.class)
	public ModelAndView handleError(HttpServletRequest req, HandleConstraintViolationException exception) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("invalidId", exception.getId());
		mav.addObject("exception", exception);
		mav.addObject("origin", "admission");
		mav.setViewName("constraintViolation");
		
		return mav;
	}
	
	@RequestMapping(value="/newStudent", method=RequestMethod.POST)
	public String processNewStudent(@ModelAttribute("student") @Valid StudentInfo student, BindingResult result, HttpServletRequest request ) {
		if (result.hasErrors()) {
			return "newStudent";
		}
		
		studentService.addStudent(student);		
		return "redirect:/admission";
	}
	
	@RequestMapping(value="/updateStudent", method=RequestMethod.GET)
	public String updateStudent(@RequestParam("studentId") int studentId, Model model) {
		StudentInfo student = studentService.getStudentById(studentId);
		model.addAttribute("student", student);
		return "updateStudentAdmission";
	}
	
	@RequestMapping(value="/updateStudent", method=RequestMethod.POST)
	public String processUpdateStudent(@ModelAttribute("student") @Valid StudentInfo student, BindingResult result) {
		if (result.hasErrors()) {
			return "updateStudentAdmission";
		}
		
		
		studentService.updateStudent(student);
		return "redirect:/admission";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}

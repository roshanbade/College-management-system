package com.cms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cms.domain.ExamGrades;
import com.cms.domain.ForGradeInput;
import com.cms.domain.StudentInfo;
import com.cms.exception.HandleConstraintViolationException;
import com.cms.exception.NoDepartmentException;
import com.cms.service.StudentService;

@Controller
@RequestMapping("/examSection")
public class ExamSectionController {
	@Autowired
	StudentService studentService;	
	
	@RequestMapping()
	public String welcome() {
		
		return "examSection";
	}
	
	@RequestMapping("/manageGrades")
	public String manageGrades(Model model) {
		
		return "manageGrades";
	}
	
	@ExceptionHandler(NoDepartmentException.class)
	public ModelAndView handleError(HttpServletRequest req, NoDepartmentException exception) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("invalidName", exception.getDepartmentName());
		mav.addObject("exception", exception);
		
		mav.setViewName("noDepartmentName");
		
		return mav;
	}
	
	@RequestMapping(value="/inputFacultyAndSem", method=RequestMethod.GET) 
	public String gradesByFaculty(Model model) {
		ForGradeInput input = new ForGradeInput();
		model.addAttribute("input", input);
		return "inputFacultyAndSem";
	}
	
	@RequestMapping(value="/inputFacultyAndSem", method=RequestMethod.POST) 
	public String processGradesByFaculty(Model model, @ModelAttribute("input") @Valid ForGradeInput input, BindingResult result) {
		if (result.hasErrors()) {
			return "inputFacultyAndSem";
		}
		
		List<StudentInfo> students = studentService.getStudentByFaculty(input.getDepartment());;
		if (students == null || students.isEmpty()) {
			throw new NoDepartmentException(input.getDepartment());  
		}
		
		
		List<StudentInfo> tempStudents = new ArrayList<StudentInfo>();
		if (input.getSemester() != 0) {
			for (StudentInfo student: students) {
				if (studentService.getCurrentSemester(student) != input.getSemester()) {
					tempStudents.add(student);
				}
			}
		}
		students.removeAll(tempStudents);
		model.addAttribute("type", "g");
		model.addAttribute("students", students);		
		return "studentInfoByFaculty";
	}
	
	@RequestMapping(value="/updateGrades", method=RequestMethod.GET)
	public String addGrade(Model model, @RequestParam() int studentId, @RequestParam() String courseCode) {
		StudentInfo student = studentService.getStudentById(studentId);
		//ExamGrades examGrades = new ExamGrades();
		
		for (ExamGrades grades:student.getListOfExamGrades()) {
			if (grades.getCourseCode().equals(courseCode)) {
				model.addAttribute("examGrades", grades);
				break;
			}
		}
		//model.addAttribute("examGrades", examGrades);
		model.addAttribute("studentId", studentId);
		return "updateGrades";
	}
	
	@RequestMapping(value="/updateGrades", method=RequestMethod.POST)
	public String processAddGrade(Model model, @RequestParam() int studentId, @RequestParam() String courseCode, @ModelAttribute() @Valid ExamGrades examGrades, BindingResult result) {
		if (result.hasErrors()) {
			return "updateGrades";
		}
		
		StudentInfo student = studentService.getStudentById(studentId);
		System.out.println(examGrades.getCourseCode());
		System.out.println(examGrades.getFirstTerm());
		
		System.out.println("\nExam grade of courseCode : ");
		for (ExamGrades grades:student.getListOfExamGrades()) {
			if (grades.getCourseCode().equals(courseCode)) {
				grades.setFirstTerm(examGrades.getFirstTerm());
				grades.setSecondTerm(examGrades.getSecondTerm());
				grades.setBoardExamGrade(examGrades.getBoardExamGrade());
				studentService.updateGrade(grades);
				break;
			}
		}
		return "redirect:/examSection/viewGrades?studentId=" + studentId ;
	}
	
	@RequestMapping(value="/viewGrades")
	public String viewGrades(Model model, @RequestParam() int studentId) {
		StudentInfo student = studentService.getStudentById(studentId);		
		List<ExamGrades> grades = student.getListOfExamGrades();
		model.addAttribute("grades", grades);
		model.addAttribute("studentId", studentId);
		return "viewGrades";
	}
	
	@ExceptionHandler(HandleConstraintViolationException.class)
	public ModelAndView handleError(HttpServletRequest req, HandleConstraintViolationException exception) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("invalidId", exception.getId());
		mav.addObject("exception", exception);
		mav.addObject("origin", "examSection");
		mav.setViewName("constraintViolation");
		
		return mav;
	}
	
	@RequestMapping(value="/individualGrade", method=RequestMethod.GET)
	public String getStudentId(Model model) {
		StudentInfo student = new StudentInfo();
		model.addAttribute("student", student);
		model.addAttribute("origin", "examSection");
		return "getStudentId";
	}
	
	@RequestMapping(value="/individualGrade", method=RequestMethod.POST)
	public String processGetStudentId(Model model, @ModelAttribute() StudentInfo student) {
		StudentInfo studentInfo = studentService.getStudentById(student.getStudentId());
		if (studentInfo == null) {
			 throw new HandleConstraintViolationException("" + student.getStudentId()); 
		}
		
		List<ExamGrades> grades = studentInfo.getListOfExamGrades();
		
		model.addAttribute("grades", grades);
		model.addAttribute("studentId", student.getStudentId());
		return "viewGrades";
	}
}

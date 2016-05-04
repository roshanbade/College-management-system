package com.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cms.domain.AssignFaculty;
import com.cms.domain.CourseOffered;
import com.cms.domain.Faculty;
import com.cms.domain.Instructor;
import com.cms.exception.HandleConstraintViolationException;
import com.cms.exception.HandleCourseConstrainViolation;
import com.cms.exception.NullInstructorException;
import com.cms.service.CourseService;
import com.cms.service.FacultyService;
import com.cms.service.InstructorService;

@Controller
@RequestMapping("/admin")
@Transactional
public class AdminController {
	@Autowired
	FacultyService facultyService;
	
	@Autowired
	InstructorService instructorService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping()
	public String welcomeAdmin() {
		return "welcomeAdmin";
	}
	
	@RequestMapping(value="/addFaculty", method=RequestMethod.GET)
	public String createDepartment(Model model) {
		Faculty faculty = new Faculty();
		model.addAttribute("faculty", faculty);
		return "addFaculty";
	}
	
	@RequestMapping(value="/addFaculty", method=RequestMethod.POST)
	public String processcreateDepartment(Model model, @ModelAttribute() @Valid Faculty faculty, BindingResult result) {
		if (result.hasErrors()) {
			return "addFaculty";
		}
		
		facultyService.addFaculty(faculty);		
		return "redirect:/admin";
	}

	@ExceptionHandler(NullInstructorException.class)
	public ModelAndView handleNullInstructor(HttpServletRequest req, NullInstructorException exception) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("invalidInstructorId", exception.getInstructorId());
		mav.addObject("exception", exception);
		mav.setViewName("nullInstructorException");
		
		return mav;
	}
	
	@RequestMapping(value="/addInstructorToFaculty", method=RequestMethod.GET)
	public String addInstructorToFaculty(Model model) {
		AssignFaculty assignFaculty = new AssignFaculty();
		model.addAttribute("assignFaculty", assignFaculty);
		return "addInstructorToFaculty";
	}
	
	@ExceptionHandler(HandleConstraintViolationException.class)
	public ModelAndView handleError(HttpServletRequest req, HandleConstraintViolationException exception) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("invalidId", exception.getId());
		mav.addObject("exception", exception);
		mav.addObject("origin", "admin");
		mav.setViewName("constraintViolation");
		
		return mav;
	}
	
	
	@ExceptionHandler(HandleCourseConstrainViolation.class)
	public ModelAndView handleNullFee(HttpServletRequest req, HandleCourseConstrainViolation exception) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("courseCode", exception.getCourseCode());
		mav.addObject("origin", "admin");
		
		mav.setViewName("courseConstraintViolation");
	
		return mav;
	}
	
	@RequestMapping(value="/addInstructorToFaculty", method=RequestMethod.POST)
	public String processaddInstructorToFaculty(Model model, @ModelAttribute() AssignFaculty assignFaculty) {
		CourseOffered courseOffered=null;
		
		Instructor instructor = instructorService.getInstructorById(assignFaculty.getInstructorId());		
		if (instructor == null) {
			throw new NullInstructorException(assignFaculty.getInstructorId());
		}
		
		Faculty faculty = facultyService.getFacultyByName(assignFaculty.getFacultyName());
		if (faculty == null) {
			throw new HandleConstraintViolationException(assignFaculty.getFacultyName());
		}
		
		try {
			courseOffered = courseService.getCourseOfferedById(assignFaculty.getCourseId()).get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new HandleCourseConstrainViolation(assignFaculty.getCourseId());
		}
		
		int f, c;
		f = c = 0;
		
		List<Faculty> faculties = instructor.getListOfFaculty();
		if (faculties == null) {
		}
		
		for (Faculty faculty1: faculties) {
			if (faculty1.equals(faculty)) {
				f = 1;
				break;
			}
		}
		
		if (f == 0) {
			instructor.getListOfFaculty().add(faculty);
			faculty.getListOfInstructor().add(instructor);
		}
		
		List<CourseOffered> courses = instructor.getListOfCourseOffered();
		for (CourseOffered cour: courses) {
			if (cour.equals(courseOffered)) {
				c = 1;
				System.out.println("Course already registered.");
				break;
			}
		}
		if (c == 0) {
			instructor.getListOfCourseOffered().add(courseOffered);
			courseOffered.getListOfInstructor().add(instructor);
		}
		System.out.println("here.... 1");
		instructorService.updateInstructor(instructor);
		System.out.println("here.... 2");
		facultyService.updateFaculty(faculty);
		System.out.println("here.... 3");		
		courseService.updateCourseOffered(courseOffered);
		
		return "redirect:/admin";
	}
	
	@RequestMapping("/manageClassrooms") 
	public String classrooms(Model model) {
		return "welcomeClassroom";
	}
}

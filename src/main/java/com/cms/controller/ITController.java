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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cms.domain.CourseInfo;
import com.cms.domain.CourseOffered;
import com.cms.domain.FullCourseInfo;
import com.cms.domain.Instructor;
import com.cms.exception.HandleCourseConstrainViolation;
import com.cms.repository.CourseRepository;
import com.cms.service.CourseService;
import com.cms.service.InstructorService;

@Controller
@RequestMapping("/department")
public class ITController {
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private InstructorService instructorService;
	
	String departmentName = null;
	
	@RequestMapping("/{name}")
	public String welcome(Model model, @PathVariable("name") String pathName) {
		departmentName = pathName;
		
		return "welcomeIT";
	}
	
	@RequestMapping(value="/addCourse", method=RequestMethod.GET)
	public String addCourse(Model model) {
		FullCourseInfo course = new FullCourseInfo();
		model.addAttribute("course", course);
		model.addAttribute("name", departmentName);
		return "addCourse";
	}
	
	@RequestMapping(value="/addCourse", method=RequestMethod.POST)
	public String processCourse(Model model, @ModelAttribute("course") @Valid FullCourseInfo course, BindingResult result) {
		if (result.hasErrors()) {
			return "addCourse";
		}
		
		course.setFaculty(departmentName);
		courseService.fullCourseInfo(course);
		return "redirect:/department/" + departmentName;
	}
	
	@ExceptionHandler(HandleCourseConstrainViolation.class)
	public ModelAndView handleNullFee(HttpServletRequest req, HandleCourseConstrainViolation exception) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("courseCode", exception.getCourseCode());
		mav.addObject("origin", "department");
		
		mav.setViewName("courseConstraintViolation");
		
		
		return mav;
	}
	
	@RequestMapping("/seeCourseInfo")
	public String seeCourseInfo(Model model) {
		List<FullCourseInfo> listOfCourse = courseService.getCourseInfoByDepartment(departmentName);
		List<FullCourseInfo> firstSemCourse = new ArrayList<FullCourseInfo>();
		List<FullCourseInfo> secondSemCourse = new ArrayList<FullCourseInfo>();
		List<FullCourseInfo> thirdSemCourse = new ArrayList<FullCourseInfo>();
		List<FullCourseInfo> fourthSemCourse = new ArrayList<FullCourseInfo>();
		List<FullCourseInfo> fifthSemCourse = new ArrayList<FullCourseInfo>();
		List<FullCourseInfo> sixthSemCourse = new ArrayList<FullCourseInfo>();
		List<FullCourseInfo> seventhSemCourse = new ArrayList<FullCourseInfo>();
		List<FullCourseInfo> eighthSemCourse = new ArrayList<FullCourseInfo>();
		
		//List<List<FullCourseInfo>> courses = new ArrayList<List<FullCourseInfo>>();
		
		/*for (int i = 1; i <= 8; i++) {
			courses.set(0, new ArrayList<FullCourseInfo>());
		}*/
		
		for (FullCourseInfo course: listOfCourse) {
			switch (course.getSemester()) {
			case 1:
				firstSemCourse.add(course);
				break;
			case 2:
				secondSemCourse.add(course);
				break;
			case 3:
				thirdSemCourse.add(course);
				break;
			case 4:
				fourthSemCourse.add(course);
				break;
			case 5:
				fifthSemCourse.add(course);
				break;
			case 6:
				sixthSemCourse.add(course);
				break;
			case 7:
				seventhSemCourse.add(course);
				break;
			case 8:
				eighthSemCourse.add(course);
				break;
			}
		}
		
	 	model.addAttribute("courses", listOfCourse);
	 	model.addAttribute("firstSemCourse", firstSemCourse);
	 	model.addAttribute("secondSemCourse", secondSemCourse);
	 	model.addAttribute("thirdSemCourse", thirdSemCourse);
	 	model.addAttribute("fourthSemCourse", fourthSemCourse);
	 	model.addAttribute("fifthSemCourse", fifthSemCourse);
	 	model.addAttribute("sixthSemCourse", sixthSemCourse);
	 	model.addAttribute("seventhSemCourse", seventhSemCourse);
	 	model.addAttribute("eighthSemCourse", eighthSemCourse);
	 	model.addAttribute("name", departmentName);
	 	
		return "seeCourseInfo";
	}
	
	@RequestMapping(value="/updateCourse", method=RequestMethod.GET)
	public String updateCourse(Model model, @RequestParam("courseId") String courseId) {
		CourseInfo courseInfo = courseService.getCourseInfoById(courseId);
		CourseOffered courseOffered = courseService.getCourseOfferedById(courseId).get(0);
		
		FullCourseInfo fullCourseInfo = new FullCourseInfo();
		model.addAttribute("course", fullCourseInfo);
		model.addAttribute("courseInfo", courseInfo);
		model.addAttribute("courseOffered", courseOffered);
		return "updateCourse";
	}
	
	@RequestMapping(value="/updateCourse", method=RequestMethod.POST)
	public String processupdateCourse(Model model, @RequestParam("courseId") String courseId, @ModelAttribute("course") @Valid FullCourseInfo course, BindingResult result) {
		if (result.hasErrors()) {
			return "updateCourse";
		}
		
		course.setCourseId(courseId);
		courseService.updateCourse(course);
		return "redirect:/department/seeCourseInfo";
	}	
	
	@RequestMapping("/deleteCourse")
	public String deleteCourse(Model model, @RequestParam("courseId") String courseId) {
		courseRepository.deleteCourseOfferedById(courseId);
		return "redirect:/department/seeCourseInfo";
	}
	
	@RequestMapping("/seeInstructorsByDepartment")
	public String seeInstructor(Model model) {
		List<Instructor> instructors = instructorService.getInstructorsByDepartment(departmentName);
		model.addAttribute("instructors", instructors);
		
		model.addAttribute("name", departmentName);
		return "seeInstructorsByDepartment";
	}
}

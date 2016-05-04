package com.cms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cms.domain.Classroom;
import com.cms.service.ClassService;

@Controller
@RequestMapping("/classroom")
public class ClassController {
	@Autowired
	ClassService classService;
	
	@RequestMapping()
	public String welcome(Model model) {
		
		return "welcomeManageClassroom";
	}
	
	@RequestMapping(value="/addClass", method=RequestMethod.GET)
	public String addClass(Model model) {
		Classroom classroom = new Classroom();
		model.addAttribute("classroom", classroom);
		return "addClass";
	}
	
	@RequestMapping(value="/addClass", method=RequestMethod.POST)
	public String processAddClass(Model model, @ModelAttribute() @Valid Classroom classroom, BindingResult result) {
		if (result.hasErrors()) {
			return "addClass";
		}
		
		classService.addClass(classroom);
		return "redirect:/classroom";
	}
	
	@RequestMapping(value="/seeClassroomInfo") 
	public String classroomInfo(Model model) {
		List<Classroom> classrooms = classService.getClassroom();
		model.addAttribute("classrooms", classrooms);
		return "seeClassroomInfo";
	}
	
	@RequestMapping(value="updateClass", method=RequestMethod.GET)
	public String updateClass(Model model, @RequestParam() String className) {
		Classroom classroom = classService.getClassByName(className);
		model.addAttribute("classroom", classroom);
		return "updateClass";
	}
	
	@RequestMapping(value="updateClass", method=RequestMethod.POST)
	public String processUpdateClass(Model model, @RequestParam() String className, @ModelAttribute() @Valid Classroom classroom, BindingResult result) {
		if (result.hasErrors()) {
			return "updateClass";
		}
		
		classService.updateClass(classroom);
		return "redirect:/classroom";
	}
}

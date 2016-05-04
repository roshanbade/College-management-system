package com.cms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.joda.time.DateTime;
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

import com.cms.domain.Attendance;
import com.cms.domain.AttendanceId;
import com.cms.domain.CourseOffered;
import com.cms.domain.Instructor;
import com.cms.domain.StudentInfo;
import com.cms.exception.CombinationFailedException;
import com.cms.exception.HandleConstraintViolationException;
import com.cms.exception.NoDepartmentException;
import com.cms.service.CourseService;
import com.cms.service.FacultyService;
import com.cms.service.InstructorService;
import com.cms.service.StudentService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
	@Autowired
	InstructorService instructorService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	FacultyService facultyService;
	
	@ExceptionHandler(HandleConstraintViolationException.class)
	public ModelAndView handleError(HttpServletRequest req, HandleConstraintViolationException exception) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("invalidId", exception.getId());
		mav.addObject("origin", "instructor");
		mav.setViewName("constraintViolation");
		
		return mav;
	}
	
	@RequestMapping(value="/addInstructor", method=RequestMethod.GET)
	public String addInstructor(Model model) {
		Instructor instructor = new Instructor();
		model.addAttribute("instructor", instructor);
		return "addInstructor";
	}
	
	@RequestMapping(value="/addInstructor", method=RequestMethod.POST) 
	public String processnewInstructor(Model model, @ModelAttribute("instructor") @Valid Instructor instructor, BindingResult result) {
		if (result.hasErrors()) {
			return "addInstructor";
		}
		
		instructorService.addInstructor(instructor);
		return "redirect:/admin";
	}
	
	@RequestMapping("/seeInstructorInfo")
	public String seeInstructorInfo(Model model) {
		List<Instructor> instructors = instructorService.getAllInstructors();
		model.addAttribute("instructors", instructors);
		return "seeInstructorInfo";
	}
	
	/*@RequestMapping(value="/assignInstructorDepartment", method=RequestMethod.GET )
	public String assignSubject(Model model,  @RequestParam("instructorId") String instructorId) {
		CourseInfo course = new CourseInfo();
		model.addAttribute("course", course);
		return "assignInstructorDepartment";
	}
	
	@RequestMapping(value="/assignInstructorDepartment", method=RequestMethod.POST)
	public String processassignSubject(Model model, @ModelAttribute("course") CourseInfo course,  @RequestParam("instructorId") String instructorId) {
		CourseOffered courseOffered = courseService.getCourseOfferedById(course.getCourseCode()).get(0);
		if (courseOffered == null) {
			throw new HandleCourseConstrainViolation(course.getCourseCode());
		}
		
		Instructor instructor = instructorService.getInstructorById(instructorId);
		if (instructor == null) {
			throw new NullInstructorException(instructorId);
		}
		
		
		instructor.getListOfCourseOffered().add(courseOffered);
		courseOffered.getListOfInstructor().add(instructor);
		
		instructorService.updateInstructor(instructor);
		return "redirect:/admin";
	}*/
	
	@ExceptionHandler(NoDepartmentException.class)
	public ModelAndView handleError(HttpServletRequest req, NoDepartmentException exception) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("invalidName", exception.getDepartmentName());
		mav.addObject("exception", exception);
		
		mav.setViewName("noDepartmentName");
		
		return mav;
	}
	
	@ExceptionHandler(CombinationFailedException.class)
	public ModelAndView handleError(HttpServletRequest req, CombinationFailedException exception) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("courseCode", exception.getCourseCode());
		mav.addObject("faculty", exception.getFaculty());
		mav.addObject("semester", exception.getSemester());
		
		mav.addObject("exception", exception);
		
		mav.setViewName("combinationFailed");
		
		return mav;
	}
	
	@RequestMapping(value="/newAttendance", method=RequestMethod.GET)
	public String getAttendaceData(Model model) {
		Attendance attendance = new Attendance();
		List<String> facultyNames = facultyService.getAllFacultyName();
		model.addAttribute("facultyNames", facultyNames);
		model.addAttribute("attendance", attendance);
		return "getClassData";
	}
	
	@RequestMapping(value="/newAttendance", method=RequestMethod.POST)
	public String processGetAttendaceData(Model model, @ModelAttribute() @Valid Attendance attendance, BindingResult result) {
		if (result.hasErrors()) {
			return "getClassData";
		}
		
		Attendance tempAttendance = new Attendance();
		Date date = new Date();
		DateTime d1 = new DateTime(date); 
		int error = -1;
		
		attendance.getAttendanceId().setYear(d1.getYear());
		attendance.getAttendanceId().setMonth(d1.getMonthOfYear());
		attendance.getAttendanceId().setDate(d1.getDayOfMonth());
		
		List<CourseOffered> courseOffered = courseService.getCourseOfferedById(attendance.getAttendanceId().getCourseId());
		
		for (CourseOffered course: courseOffered) {
			if (course.getFaculty().equals(attendance.getAttendanceId().getFaculty()) && (course.getSemester() == (attendance.getAttendanceId().getSemester()))) {
				error = 0;
			}
		}
		
		if (error != 0) {
			throw new CombinationFailedException(attendance.getAttendanceId().getCourseId(), attendance.getAttendanceId().getFaculty(), attendance.getAttendanceId().getSemester());
		}
		
		List<StudentInfo> students = studentService.getStudentByFaculty(attendance.getAttendanceId().getFaculty());
		if (students == null || students.isEmpty()) {
			throw new NoDepartmentException(attendance.getAttendanceId().getFaculty());
		}
		
		List<StudentInfo> requiredStudents = new ArrayList<StudentInfo>();
		
		for (StudentInfo student:students) {
			if (studentService.getCurrentSemester(student) == attendance.getAttendanceId().getSemester()) {
				requiredStudents.add(student);
			}
		}
		
		for (StudentInfo student: requiredStudents) {
		System.out.println("-----------Before students" + student.getStudentId() );
		}
		
		Map<String, Boolean> studentList = new HashMap<String, Boolean>(); 
		System.out.println(requiredStudents.size() - 1);
		
		for (int i = requiredStudents.size() - 1; i >= 0; i--) {
			studentList.put("" + requiredStudents.get(i).getStudentId(), false);
		}
		
		Set<String> set = studentList.keySet();
		System.out.println("-------------After students" + set);
		
		tempAttendance.setListOfStudents(studentList);		
		List<String> facultyNames = facultyService.getAllFacultyName();
		model.addAttribute("facultyNames", facultyNames);
		
		model.addAttribute("tempAttendance", tempAttendance);
		model.addAttribute("attendance", attendance);
		
		return "getAttendance";
	}
	
	@RequestMapping(value="/addAttendance", method=RequestMethod.POST)
	public String addAttendance(Model model,@ModelAttribute() Attendance tempAttendance , @RequestParam() String courseId, @RequestParam() String faculty, @RequestParam() int semester, @RequestParam() int year, @RequestParam() int month, @RequestParam() int date) {
		System.out.println("\n List Of attendance = " + tempAttendance.getListOfStudents().size() + "\n");
		AttendanceId attendanceId = new AttendanceId();
		attendanceId.setCourseId(courseId);
		attendanceId.setFaculty(faculty);
		attendanceId.setSemester(semester);
		attendanceId.setYear(year);
		attendanceId.setMonth(month);
		attendanceId.setDate(date);
		
		tempAttendance.setAttendanceId(attendanceId);
		
		Map<String, Boolean> students = tempAttendance.getListOfStudents();
		
		Set<String> studentId =  students.keySet();
		
		System.out.println("\nStudents before adding");
		for (String student: studentId) {
			System.out.println(studentService.getStudentById(Integer.parseInt(student)));
			System.out.println(students.get(student));
			if (students.get(student) == null) {
				students.put(student, false);
			}
		}
		
		instructorService.addAttendance(tempAttendance);
		
		return "redirect:/instructor/attendanceHome";
	}
	
	@RequestMapping(value="/getAttendance", method=RequestMethod.GET)
	public String getAttendance(Model model) {
		AttendanceId attendanceId = new AttendanceId();
		model.addAttribute("attendanceId", attendanceId);
		List<String> facultyNames = facultyService.getAllFacultyName();
		model.addAttribute("facultyNames", facultyNames);
		
		return "viewAttendance";
	}
	
	@RequestMapping(value="/getAttendance", method=RequestMethod.POST)
	public String processGetAttendance(Model model, @ModelAttribute() AttendanceId attendanceId) {
		List<Attendance> attendance = instructorService.getAttendance(attendanceId);
		
		model.addAttribute("attendanceList", attendance);
		return "studentAttendance";
	}
	
	@RequestMapping("/attendanceHome")
	public String attendanceHome() {
		
		return "attendance";
	}
}

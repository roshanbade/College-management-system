package com.cms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.domain.CourseOffered;
import com.cms.domain.Faculty;
import com.cms.domain.FullCourseInfo;
import com.cms.domain.Instructor;
import com.cms.domain.StudentInfo;
import com.cms.service.CourseService;
import com.cms.service.FacultyService;
import com.cms.service.InstructorService;
import com.cms.service.StudentService;

@Controller
@Transactional
public class HomeController {
	@Autowired
	private StudentService studentService;

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private InstructorService instructorService;
	
	@Autowired
	private FacultyService facultyService; 

	@RequestMapping("/")
	public String welcome(Model model, HttpServletRequest request){		
		model.addAttribute("greeting", "Welcome to College Management System");
		System.out.println("Context path = " + request.getContextPath());
		System.out.println("Get Request Uri " + request.getRequestURI());
		System.out.println("Get Request UrL " + request.getRequestURL());
		return "welcome";
	}
	
	@RequestMapping("/faculty") 
	public String faculty(Model model){
		List<Faculty> faculties = facultyService.getAllFaculty();
		
		List<String> names = new ArrayList<String>();
		
		for (Faculty faculty: faculties) {
			names.add(faculty.getFacultyName());
		}
		
		model.addAttribute("faculties", names);
		return "faculty";
	}

	@RequestMapping("/library") 
	public String library(Model model) {
		
		return "library";
	}

	@RequestMapping("/admission")
	public String admission(Model model) {
		List<StudentInfo> allStudents = studentService.getStudentInfo();
		model.addAttribute("allStudents", allStudents);
		return "admission";
	}

	@RequestMapping("/setSampleData")
	public String sampleData() throws ParseException {

		//*****************************Test Data*******************************
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");

		Date firstSemester1 = simpleDate.parse("2016-01-15");
		Date firstSemester2 = simpleDate.parse("2016-01-15");
		
		Date secondSemester1 = simpleDate.parse("2015-05-10");
		Date secondSemester2 = simpleDate.parse("2015-05-10");
		
		Date thirdSemester1 = simpleDate.parse("2015-01-15");
		Date thirdSemester2 = simpleDate.parse("2015-01-15");
		
		Date fourthSemester1 = simpleDate.parse("2014-05-15");
		Date fourthSemester2 = simpleDate.parse("2014-05-15");
		
		Date fifthSemester1 = simpleDate.parse("2014-01-15");
		Date fifthSemester2 = simpleDate.parse("2014-01-15");
		
		Date sixthSemester1 = simpleDate.parse("2013-05-15");
		Date sixthSemester2 = simpleDate.parse("2013-05-15");
		
		Date seventhSemester1 = simpleDate.parse("2013-01-15");
		Date seventhSemester2 = simpleDate.parse("2013-01-15");
		
		Date eighthSemester1 = simpleDate.parse("2012-05-15");
		Date eighthSemester2 = simpleDate.parse("2012-05-15");
		

		StudentInfo student1 = new StudentInfo();
		student1.setStudentId(1);
		student1.setFirstName("Santosh");
		student1.setLastName("Dhakal");
		student1.setFaculty("Information Technology");
		student1.setJoinDate(firstSemester1);

		StudentInfo student2 = new StudentInfo();
		student2.setStudentId(2);
		student2.setFirstName("Roshan");
		student2.setLastName("Bade");
		student2.setFaculty("Information Technology");
		student2.setJoinDate(firstSemester2);
		
		StudentInfo student3 = new StudentInfo();
		StudentInfo student4 = new StudentInfo();
		StudentInfo student5 = new StudentInfo();
		StudentInfo student6 = new StudentInfo();
		StudentInfo student7 = new StudentInfo();
		StudentInfo student8 = new StudentInfo();
		StudentInfo student9 = new StudentInfo();
		
		StudentInfo student10 = new StudentInfo();
		StudentInfo student11 = new StudentInfo();
		StudentInfo student12 = new StudentInfo();
		StudentInfo student13 = new StudentInfo();
		StudentInfo student14 = new StudentInfo();
		StudentInfo student15 = new StudentInfo();
		StudentInfo student16 = new StudentInfo();
		
		
		student3.setStudentId(3);
		student3.setFirstName("Bibash");
		student3.setLastName("Adhikari");
		student3.setFaculty("Information Technology");
		student3.setJoinDate(secondSemester1);
		
		student4.setStudentId(4);
		student4.setFirstName("Ram");
		student4.setLastName("Lamichhane");
		student4.setFaculty("Information Technology");
		student4.setJoinDate(secondSemester2);
		
		student5.setStudentId(5);
		student5.setFirstName("Habish");
		student5.setLastName("Dhakal");
		student5.setFaculty("Information Technology");
		student5.setJoinDate(thirdSemester1);
		
		student6.setStudentId(6);
		student6.setFirstName("Manoj");
		student6.setLastName("Karki");
		student6.setFaculty("Information Technology");
		student6.setJoinDate(thirdSemester2);
		
		student7.setStudentId(7);
		student7.setFirstName("Saurav");
		student7.setLastName("Regmi");
		student7.setFaculty("Information Technology");
		student7.setJoinDate(fourthSemester1);
		
		student8.setStudentId(8);
		student8.setFirstName("Dol Raj");
		student8.setLastName("Gurung");
		student8.setFaculty("Information Technology");
		student8.setJoinDate(fourthSemester2);
		
		student9.setStudentId(9);
		student9.setFirstName("Anup");
		student9.setLastName("Adhikari");
		student9.setFaculty("Information Technology");
		student9.setJoinDate(fifthSemester1);
		
		student10.setStudentId(10);
		student10.setFirstName("Ravi");
		student10.setLastName("Gurung");
		student10.setFaculty("Information Technology");
		student10.setJoinDate(fifthSemester2);
		
		student11.setStudentId(11);
		student11.setFirstName("Arjun");
		student11.setLastName("Paudel");
		student11.setFaculty("Information Technology");
		student11.setJoinDate(sixthSemester1);
		
		student12.setStudentId(12);
		student12.setFirstName("Dinesh");
		student12.setLastName("Hamal");
		student12.setFaculty("Information Technology");
		student12.setJoinDate(sixthSemester2);
		
		student13.setStudentId(13);
		student13.setFirstName("Bishow");
		student13.setLastName("Adhikari");
		student13.setFaculty("Information Technology");
		student13.setJoinDate(seventhSemester1);
		
		student14.setStudentId(14);
		student14.setFirstName("Sabin");
		student14.setLastName("Mainali");
		student14.setFaculty("Information Technology");
		student14.setJoinDate(seventhSemester2);
		
		student15.setStudentId(15);
		student15.setFirstName("Ajit");
		student15.setLastName("Bhattrai");
		student15.setFaculty("Information Technology");
		student15.setJoinDate(eighthSemester1);	
		
		student16.setStudentId(16);
		student16.setFirstName("Woopendra");
		student16.setLastName("Thapa");
		student16.setFaculty("Information Technology");
		student16.setJoinDate(eighthSemester2);
		
		//*********************************************************************
		
		
		FullCourseInfo course1 = new FullCourseInfo();
		FullCourseInfo course2 = new FullCourseInfo();
		
		FullCourseInfo course3 = new FullCourseInfo();		
		FullCourseInfo course4 = new FullCourseInfo();
		
		FullCourseInfo course5 = new FullCourseInfo();
		FullCourseInfo course6 = new FullCourseInfo();
		
		FullCourseInfo course7 = new FullCourseInfo();
		FullCourseInfo course8 = new FullCourseInfo();
		
		FullCourseInfo course9 = new FullCourseInfo();
		FullCourseInfo course10 = new FullCourseInfo();
		
		FullCourseInfo course11 = new FullCourseInfo();
		FullCourseInfo course12 = new FullCourseInfo();
		
		FullCourseInfo course13 = new FullCourseInfo();
		FullCourseInfo course14 = new FullCourseInfo();
		
		FullCourseInfo course15 = new FullCourseInfo();
		FullCourseInfo course16 = new FullCourseInfo();		
		
		course1.setCourseId("MTH 111.3");
		course1.setCourseName("Engineering Mathematics I");
		course1.setCredit(3);
		course1.setFaculty("Information Technology");
		course1.setSemester(1);
		
		course2.setCourseId("CMP 103.3");
		course2.setCourseName("Programming in C");
		course2.setCredit(3);
		course2.setFaculty("Information Technology");
		course2.setSemester(1);
		
		course3.setCourseId("PHY 102.4");
		course3.setCourseName("Physics");
		course3.setCredit(4);
		course3.setFaculty("Information Technology");
		course3.setSemester(2);
		
		course4.setCourseId("MTH 121.3");
		course4.setCourseName("Engineering Mathematics II");
		course4.setCredit(3);
		course4.setFaculty("Information Technology");
		course4.setSemester(2);
		
		course5.setCourseId("CMP 104.3");
		course5.setCourseName("Object Oriented Programming in C++");
		course5.setCredit(3);
		course5.setFaculty("Information Technology");
		course5.setSemester(3);

		course6.setCourseId("MTH 122.3");
		course6.setCourseName("Mathematical Foundation of Computer Science");
		course6.setCredit(3);
		course6.setFaculty("Information Technology");
		course6.setSemester(3);
		
		course7.setCourseId("MTH 223.3");
		course7.setCourseName("Engineering Mathematics 4");
		course7.setCredit(3);
		course7.setFaculty("Information Technology");
		course7.setSemester(4);
		
		course8.setCourseId("CMP 203.3");
		course8.setCourseName("Programming in Java");
		course8.setCredit(3);
		course8.setFaculty("Information Technology");
		course8.setSemester(4);
		
		course9.setCourseId("CMP 333.3");
		course9.setCourseName("Applied Operating System");
		course9.setCredit(3);
		course9.setFaculty("Information Technology");
		course9.setSemester(5);
		
		course10.setCourseId("CMM 482.3");
		course10.setCourseName("Singnal System and Processing");
		course10.setCredit(3);
		course10.setFaculty("Information Technology");
		course10.setSemester(5);
		
		course11.setCourseId("CMP 364.3");
		course11.setCourseName("Computer Graphics");
		course11.setCredit(3);
		course11.setFaculty("Information Technology");
		course11.setSemester(6);
		
		course12.setCourseId("CMP 474.3");
		course12.setCourseName("Computer Network");
		course12.setCredit(3);
		course12.setFaculty("Information Technology");
		course12.setSemester(6);
		
		course13.setCourseId("CMP 366.3");
		course13.setCourseName("Multimedia Systems");
		course13.setCredit(3);
		course13.setFaculty("Information Technology");
		course13.setSemester(7);
		
		course14.setCourseId("CMM 481.3");
		course14.setCourseName("Telecommunications");
		course14.setCredit(3);
		course14.setFaculty("Information Technology");
		course14.setSemester(7);
		
		course15.setCourseId("CMP 386.3");
		course15.setCourseName("Software Engineering Fundamentals");
		course15.setCredit(3);
		course15.setFaculty("Information Technology");
		course15.setSemester(8);
		
		course16.setCourseId("MNG 411.2");
		course16.setCourseName("Organization and Management");
		course16.setCredit(2);
		course16.setFaculty("Information Technology");
		course16.setSemester(8);
		
		courseService.fullCourseInfo(course1);
		courseService.fullCourseInfo(course2);
		courseService.fullCourseInfo(course3);
		
		courseService.fullCourseInfo(course4);
		courseService.fullCourseInfo(course5);
		courseService.fullCourseInfo(course6);
		
		courseService.fullCourseInfo(course7);
		courseService.fullCourseInfo(course8);
		courseService.fullCourseInfo(course9);
		
		courseService.fullCourseInfo(course10);
		courseService.fullCourseInfo(course11);
		courseService.fullCourseInfo(course12);
		
		courseService.fullCourseInfo(course13);
		courseService.fullCourseInfo(course14);
		courseService.fullCourseInfo(course15);
		courseService.fullCourseInfo(course16);
		
		//-------------------------------------------------------------------------------------
		
		Instructor instructor1 = new Instructor();
		Instructor instructor2 = new Instructor();
		Instructor instructor3 = new Instructor();
		Instructor instructor4 = new Instructor();
		Instructor instructor5 = new Instructor();
		Instructor instructor6 = new Instructor();
		Instructor instructor7 = new Instructor();
		Instructor instructor8 = new Instructor();
		
		instructor1.setInstructorId("i1");
		instructor1.setFirstName("Bibek");
		instructor1.setLastName("Ropakheti");
		
		instructor2.setInstructorId("i2");
		instructor2.setFirstName("Saroj");
		instructor2.setLastName("Neupane");
		
		instructor3.setInstructorId("i3");
		instructor3.setFirstName("Manoj");
		instructor3.setLastName("Rokka");
		
		instructor4.setInstructorId("i4");
		instructor4.setFirstName("Sarod");
		instructor4.setLastName("Tamang");
		
		instructor5.setInstructorId("i5");
		instructor5.setFirstName("Dibyeshori");
		instructor5.setLastName("Manandhar");
		
		instructor6.setInstructorId("i6");
		instructor6.setFirstName("Dipendra");
		instructor6.setLastName("Khadka");
		
		instructor7.setInstructorId("i7");
		instructor7.setFirstName("Ajay");
		instructor7.setLastName("Adhikari");
		
		instructor8.setInstructorId("i8");
		instructor8.setFirstName("Dipendra");
		instructor8.setLastName("Pathak");
		
		Faculty faculty = new Faculty();
		faculty.setFacultyName("Information Technology");
		faculty.setFacultyCoordinatorId("i1");
		
		Faculty faculty1 = new Faculty();
		faculty1.setFacultyName("Electornics");
		faculty1.setFacultyCoordinatorId("i5");
		
		
		instructor1.getListOfFaculty().add(faculty);
		faculty.getListOfInstructor().add(instructor1);
		
		instructor2.getListOfFaculty().add(faculty);
		faculty.getListOfInstructor().add(instructor2);		
		
		instructor3.getListOfFaculty().add(faculty1);
		faculty1.getListOfInstructor().add(instructor3);
		
		instructor4.getListOfFaculty().add(faculty1);
		faculty1.getListOfInstructor().add(instructor4);
		
		CourseOffered courseOffered = courseService.getCourseOfferedById("CMP 103.3").get(0);
		instructor1.getListOfCourseOffered().add(courseOffered);
		
		courseOffered.getListOfInstructor().add(instructor1);
		//courseOffered.getListOfInstructor().add(instructor1);
		
		facultyService.addFaculty(faculty);
		instructorService.addInstructor(instructor1);
		courseService.updateCourseOffered(courseOffered);
		
		instructorService.addInstructor(instructor2);
		instructorService.addInstructor(instructor3);
		instructorService.addInstructor(instructor4);
		instructorService.addInstructor(instructor4);
		instructorService.addInstructor(instructor5);
		instructorService.addInstructor(instructor6);
		instructorService.addInstructor(instructor7);
		instructorService.addInstructor(instructor8);
		
		
		//---------------------------------------------------------------------------------------
		
		studentService.addStudent(student1);
		studentService.addStudent(student2);
		studentService.addStudent(student3);
		studentService.addStudent(student4);
		studentService.addStudent(student5);
		studentService.addStudent(student6);
		studentService.addStudent(student7);
		studentService.addStudent(student8);
		studentService.addStudent(student9);
		studentService.addStudent(student10);
		studentService.addStudent(student11);
		studentService.addStudent(student12);
		studentService.addStudent(student13);
		studentService.addStudent(student14);
		studentService.addStudent(student15);
		studentService.addStudent(student16);
		
		return "redirect:/";
	}
}

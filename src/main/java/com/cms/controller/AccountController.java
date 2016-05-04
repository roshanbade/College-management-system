package com.cms.controller;

import java.math.BigDecimal;
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

import com.cms.domain.Account_Admin;
import com.cms.domain.Fee;
import com.cms.domain.FeePayment;
import com.cms.domain.StudentInfo;
import com.cms.exception.HandleNullFeeException;
import com.cms.service.StudentService;

@Controller
@RequestMapping(value="/account")
public class AccountController {
	@Autowired
	private StudentService studentService;

	@RequestMapping()
	public String account(Model model, HttpServletRequest request) {
		System.out.println("Get Request UrL " + request.getRequestURL());
		System.out.println("Get Request UrL " + request.getRequestURI());
		System.out.println("Get Local Addr " + request.getLocalAddr());
		System.out.println("Get Local name " + request.getLocalName() + ":" + request.getLocalPort());
		
		List<Account_Admin> studentId = studentService.getAccountAdmin();
		List<StudentInfo> students = new ArrayList<StudentInfo>();

		if (studentId == null || studentId.isEmpty()) {
			model.addAttribute("count", 0);
			return "account";
		}

		if (studentId != null) {
			for (Account_Admin a: studentId) {
				students.add(studentService.getStudentById(a.getStudentId()));
			}
		}

		if (studentId != null) {
			model.addAttribute("count", studentId.size());
		}
		if (students != null) {
			model.addAttribute("newStudents", students);
		}
		return "account";
	}	

	@RequestMapping(value="/addAccountData", method=RequestMethod.GET)
	public String addAccountData(Model model, @RequestParam("studentId") int studentId) {
		Fee fee = new Fee();
		model.addAttribute("fee", fee);
		return "addAccountData";
	}

	@RequestMapping(value="/addAccountData", method=RequestMethod.POST)
	public String addAccountData(@ModelAttribute("fee") @Valid Fee fee, BindingResult result,  HttpServletRequest request, @RequestParam() int studentId) {
		if (result.hasErrors()) {
			return "addAccountData";
		}
		
		StudentInfo student = studentService.getStudentById(studentId);
		fee.setStudentInfo(student);
		student.setFee(fee);
		studentService.addStudentFee(fee);
		studentService.updateStudent(student);
		studentService.deleteAccountAdmin(student.getStudentId());

		return "redirect:/account/";
	}
	
/*	@ExceptionHandler(HandleNullFeeException.class)
	public String handleNullFee(Model model, HandleNullFeeException exception) {
		model.addAttribute("studentId", exception.getStudentId());
		return "handleNullFee";
	}*/
	
	@ExceptionHandler(HandleNullFeeException.class)
	public ModelAndView handleNullFee(HttpServletRequest req, HandleNullFeeException exception) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("studentId", exception.getStudentId());
		mav.setViewName("handleNullFee");
		
		return mav;
	}

	@RequestMapping(value="/getStudentId", method=RequestMethod.GET) 
	public String getStudentId(Model model) {
		StudentInfo studentInfo = new StudentInfo();
		model.addAttribute("student", studentInfo);
		model.addAttribute("origin", "account");
		return "getStudentId";
	}

	@RequestMapping(value="/getStudentId", method=RequestMethod.POST)
	public String processStudentId(Model model, @ModelAttribute() StudentInfo student) {
		
		int studentId = student.getStudentId();
		StudentInfo studentFee = studentService.getStudentById(studentId);
		FeePayment feePayment = new FeePayment();
		Fee fee = studentService.getFeeById(studentId);
		if (studentFee == null) {
			throw new HandleNullFeeException("There is no student with id = <em>" + student.getStudentId() + "</em>.");
		}
		
		if (fee == null) {
			throw new HandleNullFeeException("You have not assigned fee structure to the student with <em>id = " + student.getStudentId() + "</em>");
		}

		int semester = studentService.getCurrentSemester(studentFee);
		
		BigDecimal totalPaid = new BigDecimal(0.0);
		BigDecimal remainingCost = new BigDecimal(0.0);
		if (fee.getTotalPaid() != null) {
			totalPaid = fee.getTotalPaid();
		}

		switch (semester) {
		case 1:
			remainingCost = fee.getFirst();	
			break;
		case 2:
			remainingCost = fee.getFirst().add(fee.getSecond());
			break;
		case 3:
			remainingCost = fee.getFirst().add(fee.getSecond()).add(fee.getThird());
			break;
		case 4:
			remainingCost = fee.getFirst().add(fee.getSecond()).add(fee.getThird()).add(fee.getFourth());
			break;
		case 5:
			remainingCost = fee.getFirst().add(fee.getSecond()).add(fee.getThird()).add(fee.getFourth()).add(fee.getFifth());
			break;
		case 6:
			remainingCost = fee.getFirst().add(fee.getSecond()).add(fee.getThird()).add(fee.getFourth()).add(fee.getFifth()).add(fee.getSixth());	
			break;	
		case 7:
			remainingCost = fee.getFirst().add(fee.getSecond()).add(fee.getThird()).add(fee.getFourth()).add(fee.getFifth()).add(fee.getSixth()).add(fee.getSeventh());	
			break;
		case 8:
			remainingCost = fee.getFirst().add(fee.getSecond()).add(fee.getThird()).add(fee.getFourth()).add(fee.getFifth()).add(fee.getSixth()).add(fee.getSeventh()).add(fee.getEighth()); 
			break;
		}
		
		remainingCost = remainingCost.subtract(totalPaid);
		
		model.addAttribute("currentSemester", semester);
		model.addAttribute("dueFee", remainingCost);
		model.addAttribute("studentFee", studentFee);
		model.addAttribute("fee", fee);
		model.addAttribute("feePayment", feePayment);
		return "feePayment";
	}
	

	@RequestMapping(value="/processFeePayment", method=RequestMethod.POST)
	public String processFeePayment(Model model, @ModelAttribute("feePayment") FeePayment feePayment, @RequestParam("studentId") int studentId) {
		
		StudentInfo student = studentService.getStudentById(studentId);
		Fee fee = studentService.getFeeById(student.getStudentId());
		
		feePayment.setStudent(student);		
		studentService.addFeePayment(feePayment);
		System.out.println("amoutnt = " + feePayment.getAmountPaid());
		if (fee.getTotalPaid() == null) {
			fee.setTotalPaid(feePayment.getAmountPaid());
		} else {
			fee.setTotalPaid(fee.getTotalPaid().add(feePayment.getAmountPaid()));
		}
		student.getListOfFeePayment().add(feePayment);
		studentService.updateFee(fee);

		return "redirect:/account";
	}

}
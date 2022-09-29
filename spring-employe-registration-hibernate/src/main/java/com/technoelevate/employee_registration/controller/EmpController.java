package com.technoelevate.employee_registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.technoelevate.employee_registration.employee.Employee;
import com.technoelevate.employee_registration.repository.EmployeeRepo;

@Controller
public class EmpController {
	@Autowired
	EmployeeRepo employeeRepo;

	@GetMapping("/empregform")
	public String indexEmpReg() {
		return "empregform";
	}

	@PostMapping("/successful")
	public String regsuccessful(@ModelAttribute Employee employee) {
		employeeRepo.resisterUser(employee);
		return "successful";
	}

	@GetMapping("/deletemployee")
	public String deleteEmpPage() {

		return "deletemployee";
	}

	@PostMapping("/deletesuccessful")
	public String deleteEmployee(@ModelAttribute Employee employee) {
		employeeRepo.deleteEmployee(employee);
		return "deletesuccessful";
	}

	@GetMapping("/updatemployee")
	public String updateEmployeePage() {

		return "updatemployee";

	}

	@PostMapping("/displayemployee")
	public String enterUpdateDetails(@RequestParam String empid, Model model) {
		Employee employee = employeeRepo.display(Integer.parseInt(empid));
		Model attribute = model.addAttribute("empid", employee);

		return "displayemployee";

	}
	 @PostMapping("/update")
     public String updatedata(@ModelAttribute Employee employee) {
    	 employeeRepo.updateEmployee(employee);
    	 return "result";
}
}

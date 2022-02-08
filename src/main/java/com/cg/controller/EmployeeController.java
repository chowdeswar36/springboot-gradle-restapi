package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Employee;
import com.cg.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addemployee")
	public String addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@PostMapping("/addemployees")
	public String addEmployee(@RequestBody List<Employee> employee) {
		return employeeService.addEmployee(employee);
	}

	@GetMapping("/getemployees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/getemployee/{eid}")
	public Employee getEmployeeById(@PathVariable("eid") int eid) {
		return employeeService.getEmployeeById(eid);
	}

	@DeleteMapping("/deleteemployee/{eid}")
	public String deleteEmployee(@PathVariable("eid") int eid) {
		return employeeService.deleteEmployee(eid);
	}

	@PutMapping("/updateemployee/{eid}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable("eid") int eid) {
		return employeeService.updateEmployee(employee, eid);
	}

}

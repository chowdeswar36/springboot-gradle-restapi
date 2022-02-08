package com.cg.service;

import java.util.List;

import com.cg.entity.Employee;

public interface EmployeeService {

	public String addEmployee(Employee employee);

	public String addEmployee(List<Employee> employee);

	public List<Employee> getEmployees();

	public Employee getEmployeeById(int eid);

	public String deleteEmployee(int eid);

	public String updateEmployee(Employee employee, int eid);

}

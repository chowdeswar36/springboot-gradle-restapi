package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.EmployeeDao;
import com.cg.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public String addEmployee(Employee employee) {
		if (employeeDao.existsById(employee.getEid())) {
			return "Employee is already added !!!!!!";
		} else {
			employeeDao.save(employee);
			return "Employee Added Successfully !!!!!!";
		}
	}

	@Override
	public String addEmployee(List<Employee> employee) {
		int size = employee.size();
		for (int i = 0; i < size; i++) {
			int eid = employee.get(i).getEid();
			if (employeeDao.existsById(eid)) {
				continue;
			} else {
				employeeDao.save(employee.get(i));
			}
		}
		return "All Employees Added Successfully !!!!!!";
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployeeById(int eid) {
		if (employeeDao.existsById(eid)) {
			return employeeDao.findById(eid).get();
		} else {
			return null;
		}
	}

	@Override
	public String deleteEmployee(int eid) {
		if (employeeDao.existsById(eid)) {
			employeeDao.deleteById(eid);
			return "Employee deleted Successfully !!!!!!";
		} else {
			return "Employee record not existed to delete !!!!!";
		}
	}

	@Override
	public String updateEmployee(Employee employee, int eid) {
		if (employeeDao.existsById(eid)) {
			employeeDao.save(employee);
			return "Employee updated Successfully !!!!!!";
		} else {
			return "Employee record not existed to update !!!!!";
		}

	}
}

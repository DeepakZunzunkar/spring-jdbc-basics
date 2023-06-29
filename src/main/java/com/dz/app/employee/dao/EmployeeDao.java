package com.dz.app.employee.dao;

import java.util.List;

import com.dz.app.model.Employee;

public interface EmployeeDao {

	public int save(Employee employee);
	public Employee getById(int id);
	public List<Employee> getAll();
	public int update(Employee employee);
	public int delete(int  id);
}

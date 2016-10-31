package com.cg.dao;

import java.util.List;

import com.cg.model.Emp;

public interface EmployeeDao {

	public List<Emp> saveEmployee(int id, String name, float salary, String designation);

	public void deleteEmployee(int id);

	public void editEmployee(int id, String name, float salary, String designation);

	public List<Emp> fetchEmployee(int id);

	public List<Emp> showEmployee();

}

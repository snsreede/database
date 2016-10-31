package com.cg.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.dao.EmployeeDao;
import com.cg.model.Emp;

@Repository("employeeDaoImpl")

public class EmployeeDaoImpl implements EmployeeDao {
	private  List<Emp> employeeList;
	private  List<Emp> employeeFetchList;
	private  List<Emp> showEmployeeList;

	@Autowired
	 Emp employeeDTO;

	int x;
	public List<Emp> saveEmployee(int id, String name, float salary, String designation) {
		employeeDTO.setId(id);
		employeeDTO.setName(name);
		employeeDTO.setSalary(salary);
		employeeDTO.setDesignation(designation);
		employeeList = new ArrayList<Emp>();
		employeeList.add(employeeDTO);
		x++;
		System.out.println(x);
		return employeeList;
	}

	@Override
	public void deleteEmployee(int id) {
		if (employeeDTO.getId() == id) {
			employeeDTO.setId(0);

		}

	}

	@Override
	public void editEmployee(int id, String name, float salary, String designation) {
		if (employeeDTO.getId() == id) {
			employeeDTO.setId(id);
			employeeDTO.setName(name);
			employeeDTO.setSalary(salary);
			employeeDTO.setDesignation(designation);

		}

	}

	@Override
	public List<Emp> fetchEmployee(int id) {
		employeeFetchList = new ArrayList<Emp>();
		if (employeeDTO.getId() == id) {
			employeeFetchList.add(employeeDTO);
			return employeeFetchList;
		}
		return employeeFetchList;
	}

	@Override
	public List<Emp> showEmployee() {
		showEmployeeList = new ArrayList<Emp>();
		if (employeeDTO.getId() == 0) {
			return showEmployeeList;
		} else {
			showEmployeeList.add(employeeDTO);
			System.out.println(showEmployeeList.get(0).getId());
			return showEmployeeList;
		}
	}

}

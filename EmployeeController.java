package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import com.cg.dao.EmployeeDao;
import com.cg.model.Emp;

@Controller

public class EmployeeController {

	@Autowired
	EmployeeDao employeeDaoImpl;

	@RequestMapping(value = "/empform", method = RequestMethod.GET)
	public String addEmployee() {

		return "empform";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("salary") float salary, @RequestParam("designation") String designation, ModelMap map) {
		if (id == 0) {
			return "viewemp";
		} else {
			map.addAttribute("empList", employeeDaoImpl.saveEmployee(id, name, salary, designation));
			return "viewemp";
		}
	}

	@RequestMapping(value = "/editemp/{id}", method = RequestMethod.GET)
	public String editEmployee(@PathVariable int id, ModelMap map) {

		map.addAttribute("editDetails", employeeDaoImpl.fetchEmployee(id));
		return "empeditform";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editSaveEmployee(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("salary") float salary, @RequestParam("designation") String designation) {

		employeeDaoImpl.editEmployee(id, name, salary, designation);
		return "redirect:/viewemp";
	}

	@RequestMapping(value = "/viewemp", method = RequestMethod.GET)
	public String displayEmployee(ModelMap map) {
		map.addAttribute("empList", employeeDaoImpl.showEmployee());
		return "viewemp";
	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeDaoImpl.deleteEmployee(id);
		return "redirect:/viewemp";
	}
}

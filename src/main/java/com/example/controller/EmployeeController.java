package com.example.controller;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Employee;
import com.example.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService emplservice;

	@RequestMapping("/")
	public String register(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "register";
	}

	@PostMapping("/registerEmployee")
	public String registerEmployee(@ModelAttribute("employee") Employee employee) {

		System.out.println(employee.getName());
		System.out.println(employee.getUsername());
		System.out.println(employee.getEmail());
		System.out.println(employee.getPassword());
		System.out.println(employee.getConformPassword());
		System.out.println(employee.getCity());
		System.out.println(employee.getPhone());
		System.out.println(employee.getGender());
		System.out.println(employee.getAddphoto());
		return "home";
	}

	@GetMapping("/home")
	public String viewHomePage(Model model) {
		List<Employee> listemployee = emplservice.listAll();
		model.addAttribute("listemployee", listemployee);
		System.out.print("Get / ");
		return "index";
	}

	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("employee", new Employee());
		return "new";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("Employee") Employee employee, ModelMap model) {
		emplservice.saveEmployee(employee);
		model.addAttribute("employee", employee);
		return "redirect:/";
	}

	@RequestMapping("/edit/{name}")
	public ModelAndView showEditEmployeePage(@ModelAttribute("employee") Employee employee,@PathVariable(name = "name") String name) {
		ModelAndView mav = new ModelAndView("new");
		Employee std = emplservice.get(name);
		mav.addObject("employee", std);
		return mav;
	}

	@RequestMapping("/delete/{name}")
	public String deleteemployee(@PathVariable(name = "name") String name) {
		emplservice.get(name);
		return "redirect:/";
	}
}

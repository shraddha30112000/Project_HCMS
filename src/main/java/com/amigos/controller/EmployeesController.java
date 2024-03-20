package com.amigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.amigos.entities.Employees;
import com.amigos.services.EmployeesService;

@CrossOrigin("*")
@RestController
public class EmployeesController {
	
	@Autowired
	private EmployeesService employeesService;
	
	@GetMapping("/employees")
	private ResponseEntity<List<Employees>> getAll()
	{
		return new ResponseEntity<List<Employees>>(employeesService.getAllEmployees(), HttpStatus.OK);
	}
	
	//@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@PostMapping(value = "/employees")
	private ResponseEntity<Void> save(@RequestBody Employees employee,UriComponentsBuilder ucBuilder)
	{
		if(employee==null)
		{
			throw new RuntimeException("Employee Object can't be NULL");
		}
		employeesService.addEmployee(employee);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/emplyees/{id}")
	private ResponseEntity<Employees> get(@PathVariable int id)
	{
		Employees emp = employeesService.getEmployeeById(id);
		if(emp==null) {
			return new ResponseEntity<Employees>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Employees>(emp, HttpStatus.OK);
		}
	}
	
	@PutMapping("/employees/{id}")
	private ResponseEntity<Void> update(@RequestBody Employees toBeupdateEmp,@PathVariable int id )
	{
		if(toBeupdateEmp==null)
		{
			throw new RuntimeException("Employee Object can't be NULL");
		}
		Employees existingEmp = employeesService.getEmployeeById(id);
		if(toBeupdateEmp==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			employeesService.updateEmployee(toBeupdateEmp);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/employees/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		Employees deleteEmployee = employeesService.getEmployeeById(id);
		if(deleteEmployee==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			employeesService.deleteEmployee(deleteEmployee);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

package com.amigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.amigos.entities.EmployeeManagers;
import com.amigos.entities.Employees;
import com.amigos.services.EmployeeManagersService;

@RestController
public class EmployeeManagersController {
	
	@Autowired
	private EmployeeManagersService employeeManagersService;
	
	@GetMapping("/employeeManagers")
	private ResponseEntity<List<EmployeeManagers>> getAll()
	{
		return new ResponseEntity<List<EmployeeManagers>>(employeeManagersService.getAllEmployeeManagers(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/employeeManagers")
	private ResponseEntity<Void> save(@RequestBody EmployeeManagers employeeManagers,UriComponentsBuilder ucBuilder)
	{
		if(employeeManagers==null)
		{
			throw new RuntimeException("EmployeeManagers Object can't be NULL");
		}
		employeeManagersService.addEmployeeManagers(employeeManagers);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/employeeManagers/{id}")
	private ResponseEntity<EmployeeManagers> get(@PathVariable int id)
	{
		EmployeeManagers empM = employeeManagersService.getEmployeeManagersById(id);
		if(empM==null) {
			return new ResponseEntity<EmployeeManagers>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<EmployeeManagers>(empM, HttpStatus.OK);
		}
	}

	@PutMapping("/employeeManagers/{id}")
	private ResponseEntity<Void> update(@RequestBody EmployeeManagers toBeupdateEmpM,@PathVariable int id )
	{
		if(toBeupdateEmpM==null)
		{
			throw new RuntimeException("EmployeeManagers Object can't be NULL");
		}
		EmployeeManagers existingEmpM = employeeManagersService.getEmployeeManagersById(id);
		if(toBeupdateEmpM==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			employeeManagersService.updateEmployeeManagers(toBeupdateEmpM);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/employeeManagers/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		EmployeeManagers deleteEmployeeManagers = employeeManagersService.getEmployeeManagersById(id);
		if(deleteEmployeeManagers==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			employeeManagersService.deleteEmployeeManagers(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

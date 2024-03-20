package com.amigos.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.amigos.entities.ApplicationStatus;
import com.amigos.entities.Departments;
import com.amigos.entities.Employees;
import com.amigos.services.DepartmentsService;

@RestController
public class DepartmentsController {
	
	@Autowired
	private DepartmentsService departmentsService;
	
	@GetMapping("/departments")
	private ResponseEntity<List<Departments>> getAll()
	{
		return new ResponseEntity<List<Departments>>(departmentsService.getAllDepartments(), HttpStatus.OK);
	}
	
	@PostMapping("/departments")
	private ResponseEntity<Void> save(@RequestBody Departments departments,UriComponentsBuilder ucBuilder)
	{
		if(departments == null) {
			throw new RuntimeException("Application Status can't be NULL");
		}

		departmentsService.addDepartment(departments);
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		
	} 
	
	@GetMapping("/departments/{id}")
	private ResponseEntity<Departments> get(@PathVariable int id)
	{
		Departments Dep = departmentsService.getDepartmentById(id);
		if(Dep==null) {
			return new ResponseEntity<Departments>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Departments>(Dep, HttpStatus.OK);
		}
	}
	
	@PutMapping("/departments/{id}")
	private ResponseEntity<Void> update(@RequestBody Departments toBeupdateDep,@PathVariable int id )
	{
		if(toBeupdateDep==null)
		{
			throw new RuntimeException("Employee Object can't be NULL");
		}
		Departments existingDep = departmentsService.getDepartmentById(id);
		if(toBeupdateDep==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			departmentsService.updateDepartment(toBeupdateDep);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/departments/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		Departments deleteDepartments = departmentsService.getDepartmentById(id);
		if(deleteDepartments==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			departmentsService.deleteDepartment(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}
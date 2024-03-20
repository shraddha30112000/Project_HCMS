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

import com.amigos.entities.Employees;
import com.amigos.entities.Projects;
import com.amigos.services.ProjectsService;

@RestController
public class ProjectsController {

	@Autowired
	private ProjectsService projectsService;
	
	@GetMapping("/projects")
	private ResponseEntity<List<Projects>> getAll()
	{
		return new ResponseEntity<List<Projects>>(projectsService.getAllProjects(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/projects")
	private ResponseEntity<Void> save(@RequestBody Projects projects,UriComponentsBuilder ucBuilder)
	{
		if(projects==null)
		{
			throw new RuntimeException("projects Object can't be NULL");
		}
		projectsService.addProjects(projects);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/projects/{id}")
	private ResponseEntity<Projects> get(@PathVariable int id)
	{
		Projects P = projectsService.getProjectsById(id);
		if(P==null) {
			return new ResponseEntity<Projects>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Projects>(P, HttpStatus.OK);
		}
	}
	
	@PutMapping("/projects/{id}")
	private ResponseEntity<Void> update(@RequestBody Projects toBeupdateP,@PathVariable int id )
	{
		if(toBeupdateP==null)
		{
			throw new RuntimeException("Projects Object can't be NULL");
		}
		Projects existingP = projectsService.getProjectsById(id);
		if(toBeupdateP==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			projectsService.updateProjects(toBeupdateP);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/projects/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		Projects deleteProjects = projectsService.getProjectsById(id);
		if(deleteProjects==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			projectsService.deleteProjects(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

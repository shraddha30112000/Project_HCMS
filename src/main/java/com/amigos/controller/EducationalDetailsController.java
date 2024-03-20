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

import com.amigos.entities.EducationalDetails;
import com.amigos.entities.Employees;
import com.amigos.services.EducationalDetailsService;

@RestController
public class EducationalDetailsController {
	
	@Autowired
	private EducationalDetailsService educationalDetailsService;
	
	@GetMapping("/educationalDetails")
	private ResponseEntity<List<EducationalDetails>> getAll()
	{
		return new ResponseEntity<List<EducationalDetails>>(educationalDetailsService.getAllEducationalDetails(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/educationalDetails")
	private ResponseEntity<Void> save(@RequestBody EducationalDetails educationalDetails,UriComponentsBuilder ucBuilder)
	{
		if(educationalDetails==null)
		{
			throw new RuntimeException("EducationalDetails Object can't be NULL");
		}
		educationalDetailsService.addEducationalDetails(educationalDetails);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/educationalDetails/{id}")
	private ResponseEntity<EducationalDetails> get(@PathVariable int id)
	{
		EducationalDetails edu = educationalDetailsService.getEducationalDetailsById(id);
		if(edu==null) {
			return new ResponseEntity<EducationalDetails>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<EducationalDetails>(edu, HttpStatus.OK);
		}
	}
	
	@PutMapping("/educationalDetails/{id}")
	private ResponseEntity<Void> update(@RequestBody EducationalDetails toBeupdateEdu,@PathVariable int id )
	{
		if(toBeupdateEdu==null)
		{
			throw new RuntimeException("EducationalDetails Object can't be NULL");
		}
		EducationalDetails existingEdu = educationalDetailsService.getEducationalDetailsById(id);
		if(toBeupdateEdu==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			educationalDetailsService.updateEducationalDetails(toBeupdateEdu);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/educationalDetails/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		EducationalDetails deleteEducationalDetails = educationalDetailsService.getEducationalDetailsById(id);
		if(deleteEducationalDetails==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			educationalDetailsService.deleteEducationalDetails(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}

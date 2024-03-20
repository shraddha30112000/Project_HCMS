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
import com.amigos.entities.ExternalTrainers;
import com.amigos.services.ExternalTrainersService;

@RestController
public class ExternalTrainersController {

	@Autowired
	private ExternalTrainersService externalTrainersService;
	
	@GetMapping("/externalTrainers")
	private ResponseEntity<List<ExternalTrainers>> getAll()
	{
		return new ResponseEntity<List<ExternalTrainers>>(externalTrainersService.getAllExternalTrainers(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/externalTrainers")
	private ResponseEntity<Void> save(@RequestBody ExternalTrainers externalTrainers,UriComponentsBuilder ucBuilder)
	{
		if(externalTrainers==null)
		{
			throw new RuntimeException("externalTrainers Object can't be NULL");
		}
		externalTrainersService.addExternalTrainers(externalTrainers);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/externalTrainers/{id}")
	private ResponseEntity<ExternalTrainers> get(@PathVariable int id)
	{
		ExternalTrainers ex = externalTrainersService.getExternalTrainersById(id);
		if(ex==null) {
			return new ResponseEntity<ExternalTrainers>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<ExternalTrainers>(ex , HttpStatus.OK);
		}
	}
	
	@PutMapping("/externalTrainers/{id}")
	private ResponseEntity<Void> update(@RequestBody ExternalTrainers toBeupdateEx,@PathVariable int id )
	{
		if(toBeupdateEx==null)
		{
			throw new RuntimeException("Employee Object can't be NULL");
		}
		ExternalTrainers existingEx = externalTrainersService.getExternalTrainersById(id);
		if(toBeupdateEx==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			externalTrainersService.updateExternalTrainers(toBeupdateEx);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/externalTrainers/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		ExternalTrainers deleteExternalTrainers = externalTrainersService.getExternalTrainersById(id);
		if(deleteExternalTrainers==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			externalTrainersService.deleteExternalTrainers(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

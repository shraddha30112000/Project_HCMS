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

import com.amigos.entities.TrainingModules;
import com.amigos.services.TrainingModulesService;

@RestController
public class TrainingModulesController {
	@Autowired
	private TrainingModulesService trainingModulesService;
	
	@GetMapping("/trainingModules")
	private ResponseEntity<List<TrainingModules>> getAll()
	{
		return new ResponseEntity<List<TrainingModules>>(trainingModulesService.getAllTrainingModules(), HttpStatus.OK);
	}
	
	//@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@PostMapping(value = "/trainingModules")
	private ResponseEntity<Void> save(@RequestBody TrainingModules trainingModules,UriComponentsBuilder ucBuilder)
	{
		if(trainingModules==null)
		{
			throw new RuntimeException("Employee Object can't be NULL");
		}
		trainingModulesService.addTrainingModules(trainingModules);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/trainingModules/{id}")
	private ResponseEntity<TrainingModules> get(@PathVariable int id)
	{
		TrainingModules TM = trainingModulesService.getTrainingModulesById(id);
		if(TM==null) {
			return new ResponseEntity<TrainingModules>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<TrainingModules>(TM, HttpStatus.OK);
		}
	}
	
	@PutMapping("/trainingModules/{id}")
	private ResponseEntity<Void> update(@RequestBody TrainingModules toBeupdateTM,@PathVariable int id )
	{
		if(toBeupdateTM==null)
		{
			throw new RuntimeException("TrainingModules Object can't be NULL");
		}
		TrainingModules existingTM = trainingModulesService.getTrainingModulesById(id);
		if(toBeupdateTM==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			trainingModulesService.updateTrainingModules(toBeupdateTM);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/trainingModules/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		TrainingModules deleteTrainingModules = trainingModulesService.getTrainingModulesById(id);
		if(deleteTrainingModules==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			trainingModulesService.deleteTrainingModules(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

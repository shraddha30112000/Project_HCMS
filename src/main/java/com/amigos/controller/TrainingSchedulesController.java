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

import com.amigos.entities.TrainingSchedules;
import com.amigos.services.TrainingSchedulesService;
@RestController
public class TrainingSchedulesController {

	@Autowired
	private TrainingSchedulesService trainingSchedulesService;
	
	@GetMapping("/trainingSchedules")
	private ResponseEntity<List<TrainingSchedules>> getAll()
	{
		return new ResponseEntity<List<TrainingSchedules>>(trainingSchedulesService.getAllTrainingSchedules(), HttpStatus.OK);
	}
	
	//@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@PostMapping(value = "/trainingSchedules")
	private ResponseEntity<Void> save(@RequestBody TrainingSchedules trainingSchedules,UriComponentsBuilder ucBuilder)
	{
		if(trainingSchedules==null)
		{
			throw new RuntimeException("Employee Object can't be NULL");
		}
		trainingSchedulesService.addTrainingSchedules(trainingSchedules);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/trainingSchedules/{id}")
	private ResponseEntity<TrainingSchedules> get(@PathVariable int id)
	{
		TrainingSchedules TS = trainingSchedulesService.getTrainingSchedulesById(id);
		if(TS==null) {
			return new ResponseEntity<TrainingSchedules>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<TrainingSchedules>(TS, HttpStatus.OK);
		}
	}
	
	@PutMapping("/trainingSchedules/{id}")
	private ResponseEntity<Void> update(@RequestBody TrainingSchedules toBeupdateTS,@PathVariable int id )
	{
		if(toBeupdateTS==null)
		{
			throw new RuntimeException("TrainingSchedules Object can't be NULL");
		}
		TrainingSchedules existingT = trainingSchedulesService.getTrainingSchedulesById(id);
		if(toBeupdateTS==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			trainingSchedulesService.updateTrainingSchedules(toBeupdateTS);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/trainingSchedules/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		TrainingSchedules deleteTrainingSchedules = trainingSchedulesService.getTrainingSchedulesById(id);
		if(deleteTrainingSchedules==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			trainingSchedulesService.deleteTrainingSchedules(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

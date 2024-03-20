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

import com.amigos.entities.ApplicationStatus;
import com.amigos.services.ApplicationStatusService;

@RestController
public class ApplicationStatusController {
	
	@Autowired
	private ApplicationStatusService applicationStatusService;
	
	@GetMapping("/applicaionStatus")
	private ResponseEntity<List<ApplicationStatus>> getAll() {
		return new ResponseEntity<List<ApplicationStatus>>(applicationStatusService.getAllApplicationStatus(), HttpStatus.OK);
	}


	@PostMapping("/applicationStatus")
	private ResponseEntity<Void> save(@RequestBody ApplicationStatus applicationStatus,UriComponentsBuilder ucBuilder){
		if(applicationStatus == null) {
			throw new RuntimeException("Application Status can't be NULL");
		}

		applicationStatusService.addApplicationStatus(applicationStatus);
		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/applicationStatus/{id}")
	private ResponseEntity<ApplicationStatus> get(@PathVariable int id){
		ApplicationStatus application=applicationStatusService.getApplicationStatusById(id);
		if(application == null) {
			return new ResponseEntity<ApplicationStatus>(HttpStatus.NOT_FOUND);

		}else {
			return new ResponseEntity<ApplicationStatus>(application, HttpStatus.OK);
		}
	}

	@PutMapping("/applicationStatus/{id}")
	private ResponseEntity<Void> update(@RequestBody ApplicationStatus toBeUpdateApplication,@PathVariable int id){
		if(toBeUpdateApplication == null) {
			throw new RuntimeException("Application Object can 't  be NULL");
		}
		ApplicationStatus application=applicationStatusService.getApplicationStatusById(id);
		if(toBeUpdateApplication == null) {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		}else {
			applicationStatusService.updateApplicationStatus(toBeUpdateApplication);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/applicationStatus/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id){
		ApplicationStatus deleteApplication =applicationStatusService.getApplicationStatusById(id);
		if(deleteApplication == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			applicationStatusService.deleteApplicationStatus(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

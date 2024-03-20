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

import com.amigos.entities.CandidateProfiles;
import com.amigos.entities.Employees;
import com.amigos.services.CandidateProfilesService;

@RestController
public class CandidateProfilesController {

	@Autowired
	private CandidateProfilesService candidateProfilesService;
	
	@GetMapping("/candidateProfiles")
	private ResponseEntity<List<CandidateProfiles>> getAll()
	{
		return new ResponseEntity<List<CandidateProfiles>>(candidateProfilesService.getAllCandidateProfiles(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/candidateProfiles")
	private ResponseEntity<Void> save(@RequestBody CandidateProfiles candidateProfiles,UriComponentsBuilder ucBuilder)
	{
		if(candidateProfiles==null)
		{
			throw new RuntimeException("CandidateProfiles Object can't be NULL");
		}
		candidateProfilesService.addCandidateProfiles(candidateProfiles);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/candidateProfiles/{id}")
	private ResponseEntity<CandidateProfiles> get(@PathVariable int id)
	{
		CandidateProfiles CP = candidateProfilesService.getCandidateProfilesById(id);
		if(CP==null) {
			return new ResponseEntity<CandidateProfiles>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<CandidateProfiles>(CP, HttpStatus.OK);
		}
	}
	
	@PutMapping("/candidateProfiles/{id}")
	private ResponseEntity<Void> update(@RequestBody CandidateProfiles toBeupdateCP,@PathVariable int id )
	{
		if(toBeupdateCP==null)
		{
			throw new RuntimeException("candidateProfiles Object can't be NULL");
		}
		CandidateProfiles existingCP = candidateProfilesService.getCandidateProfilesById(id);
		if(toBeupdateCP==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			candidateProfilesService.updateCandidateProfiles(toBeupdateCP);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/candidateProfiles/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		CandidateProfiles deleteCandidateProfiles = candidateProfilesService.getCandidateProfilesById(id);
		if(deleteCandidateProfiles==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			candidateProfilesService.deleteCandidateProfiles(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}

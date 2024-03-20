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

import com.amigos.entities.Certifications;
import com.amigos.services.CertificationsService;

@RestController
public class CertificationsController {
	
	@Autowired
	private CertificationsService certificationsService;
	
	@GetMapping("/certifications")
	private ResponseEntity<List<Certifications>> getAll()
	{
		return new ResponseEntity<List<Certifications>>(certificationsService.getAllCertifications(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/certifications")
	private ResponseEntity<Void> save(@RequestBody Certifications certifications,UriComponentsBuilder ucBuilder)
	{
		if(certifications==null)
		{
			throw new RuntimeException("certifications Object can't be NULL");
		}
		certificationsService.addCertifications(certifications);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/certifications/{id}")
	private ResponseEntity<Certifications> get(@PathVariable int id)
	{
		Certifications c = certificationsService.getCertificationsById(id);
		if(c==null) {
			return new ResponseEntity<Certifications>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Certifications>(c, HttpStatus.OK);
		}
	}
	
	@PutMapping("/certifications/{id}")
	private ResponseEntity<Void> update(@RequestBody Certifications toBeupdateC,@PathVariable int id )
	{
		if(toBeupdateC==null)
		{
			throw new RuntimeException("certifications Object can't be NULL");
		}
		Certifications existingC = certificationsService.getCertificationsById(id);
		if(toBeupdateC==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			certificationsService.updateCertifications(toBeupdateC);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/certifications/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		Certifications deleteCertifications = certificationsService.getCertificationsById(id);
		if(deleteCertifications==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			certificationsService.deleteCertifications(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

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
import com.amigos.entities.LeaveTypes;
import com.amigos.services.LeaveTypesService;

@RestController
public class LeaveTypesController {

	@Autowired
	private LeaveTypesService leaveTypesService;
	
	@GetMapping("/leaveTypes")
	private ResponseEntity<List<LeaveTypes>> getAll()
	{
		return new ResponseEntity<List<LeaveTypes>>(leaveTypesService.getAllLeaveTypes(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/leaveTypes")
	private ResponseEntity<Void> save(@RequestBody LeaveTypes leaveTypes,UriComponentsBuilder ucBuilder)
	{
		if(leaveTypes==null)
		{
			throw new RuntimeException("LeaveTypes Object can't be NULL");
		}
		leaveTypesService.addLeaveTypes(leaveTypes);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/leaveTypes/{id}")
	private ResponseEntity<LeaveTypes> get(@PathVariable int id)
	{
		LeaveTypes LT = leaveTypesService.getLeaveTypesById(id);
		if(LT==null) {
			return new ResponseEntity<LeaveTypes>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<LeaveTypes>(LT, HttpStatus.OK);
		}
	}
	
	@PutMapping("/leaveTypes/{id}")
	private ResponseEntity<Void> update(@RequestBody LeaveTypes toBeupdateLT,@PathVariable int id )
	{
		if(toBeupdateLT==null)
		{
			throw new RuntimeException("LeaveTypes Object can't be NULL");
		}
		LeaveTypes existingLT = leaveTypesService.getLeaveTypesById(id);
		if(toBeupdateLT==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			leaveTypesService.updateLeaveTypes(toBeupdateLT);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/leaveTypes/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		LeaveTypes deleteLeaveTypes = leaveTypesService.getLeaveTypesById(id);
		if(deleteLeaveTypes==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			leaveTypesService.deleteLeaveTypes(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

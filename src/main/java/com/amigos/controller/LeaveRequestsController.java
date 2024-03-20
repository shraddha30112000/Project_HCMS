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
import com.amigos.entities.LeaveRequests;
import com.amigos.services.LeaveRequestsService;

@RestController
public class LeaveRequestsController {

	@Autowired
	private LeaveRequestsService leaveRequestsService;
	
	@GetMapping("/leaveRequests")
	private ResponseEntity<List<LeaveRequests>> getAll()
	{
		return new ResponseEntity<List<LeaveRequests>>(leaveRequestsService.getAllLeaveRequests(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/leaveRequests")
	private ResponseEntity<Void> save(@RequestBody LeaveRequests leaveRequests,UriComponentsBuilder ucBuilder)
	{
		if(leaveRequests==null)
		{
			throw new RuntimeException("Employee Object can't be NULL");
		}
		leaveRequestsService.addLeaveRequests(leaveRequests);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/leaveRequests/{id}")
	private ResponseEntity<LeaveRequests> get(@PathVariable int id)
	{
		LeaveRequests LR = leaveRequestsService.getLeaveRequestsById(id);
		if(LR==null) {
			return new ResponseEntity<LeaveRequests>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<LeaveRequests>(LR, HttpStatus.OK);
		}
	}
	
	@PutMapping("/leaveRequests/{id}")
	private ResponseEntity<Void> update(@RequestBody LeaveRequests toBeupdateLR,@PathVariable int id )
	{
		if(toBeupdateLR==null)
		{
			throw new RuntimeException("Employee Object can't be NULL");
		}
		LeaveRequests existingLR = leaveRequestsService.getLeaveRequestsById(id);
		if(toBeupdateLR==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			leaveRequestsService.updateLeaveRequests(toBeupdateLR);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/leaveRequests/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		LeaveRequests deleteLeaveRequests = leaveRequestsService.getLeaveRequestsById(id);
		if(deleteLeaveRequests==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			leaveRequestsService.deleteLeaveRequests(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
}

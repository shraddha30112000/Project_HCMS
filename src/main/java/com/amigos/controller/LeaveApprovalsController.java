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
import com.amigos.entities.LeaveApprovals;
import com.amigos.services.LeaveApprovalsService;

@RestController
public class LeaveApprovalsController {

	@Autowired
	private LeaveApprovalsService leaveApprovalsService;
	
	@GetMapping("/leaveApprovals")
	private ResponseEntity<List<LeaveApprovals>> getAll()
	{
		return new ResponseEntity<List<LeaveApprovals>>(leaveApprovalsService.getAllLeaveApprovals(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/leaveApprovals")
	private ResponseEntity<Void> save(@RequestBody LeaveApprovals leaveApprovals,UriComponentsBuilder ucBuilder)
	{
		if(leaveApprovals==null)
		{
			throw new RuntimeException("Employee Object can't be NULL");
		}
		leaveApprovalsService.addLeaveApprovals(leaveApprovals);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/leaveApprovals/{id}")
	private ResponseEntity<LeaveApprovals> get(@PathVariable int id)
	{
		LeaveApprovals LV = leaveApprovalsService.getLeaveApprovalsById(id);
		if(LV==null) {
			return new ResponseEntity<LeaveApprovals>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<LeaveApprovals>(LV, HttpStatus.OK);
		}
	}
	
	@PutMapping("/leaveApprovals/{id}")
	private ResponseEntity<Void> update(@RequestBody LeaveApprovals toBeupdateLV,@PathVariable int id )
	{
		if(toBeupdateLV==null)
		{
			throw new RuntimeException("LeaveApprovals Object can't be NULL");
		}
		LeaveApprovals existingLV = leaveApprovalsService.getLeaveApprovalsById(id);
		if(toBeupdateLV==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			leaveApprovalsService.updateLeaveApprovals(toBeupdateLV);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/leaveApprovals/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		LeaveApprovals deleteLeaveApprovals = leaveApprovalsService.getLeaveApprovalsById(id);
		if(deleteLeaveApprovals==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			leaveApprovalsService.deleteLeaveApprovals(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

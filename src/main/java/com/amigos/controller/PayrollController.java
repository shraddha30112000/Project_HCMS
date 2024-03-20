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
import com.amigos.entities.Payroll;
import com.amigos.services.PayrollService;

@RestController
public class PayrollController {
	
	@Autowired
	private PayrollService payrollService;
	
	@GetMapping("/payroll")
	private ResponseEntity<List<Payroll>> getAll()
	{
		return new ResponseEntity<List<Payroll>>(payrollService.getAllPayrolls(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/payroll")
	private ResponseEntity<Void> save(@RequestBody Payroll payroll,UriComponentsBuilder ucBuilder)
	{
		if(payroll==null)
		{
			throw new RuntimeException("payroll Object can't be NULL");
		}
		payrollService.addPayroll(payroll);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/payroll/{id}")
	private ResponseEntity<Payroll> get(@PathVariable int id)
	{
		Payroll P = payrollService.getPayrollById(id);
		if(P==null) {
			return new ResponseEntity<Payroll>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Payroll>(P, HttpStatus.OK);
		}
	}
	
	@PutMapping("/payroll/{id}")
	private ResponseEntity<Void> update(@RequestBody Payroll toBeupdateP,@PathVariable int id )
	{
		if(toBeupdateP==null)
		{
			throw new RuntimeException("Payroll Object can't be NULL");
		}
		Payroll existingP = payrollService.getPayrollById(id);
		if(toBeupdateP==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			payrollService.updatePayroll(toBeupdateP);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/payroll/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		Payroll deletePayroll = payrollService.getPayrollById(id);
		if(deletePayroll==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			payrollService.deletePayroll(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}

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
import com.amigos.entities.SkillUpgradation;
import com.amigos.services.EmployeesService;
import com.amigos.services.SkillUpgradationService;

@RestController
public class SkillUpgradationController {

	@Autowired
	private SkillUpgradationService skillUpgradationService;
	
	@GetMapping("/skillUpgradation")
	private ResponseEntity<List<SkillUpgradation>> getAll()
	{
		return new ResponseEntity<List<SkillUpgradation>>(skillUpgradationService.getAllSkillUpgradation(), HttpStatus.OK);
	}
	
	//@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@PostMapping(value = "/skillUpgradation")
	private ResponseEntity<Void> save(@RequestBody SkillUpgradation skillUpgradation,UriComponentsBuilder ucBuilder)
	{
		if(skillUpgradation==null)
		{
			throw new RuntimeException("skillUpgradation Object can't be NULL");
		}
		skillUpgradationService.addSkillUpgradation(skillUpgradation);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/skillUpgradation/{id}")
	private ResponseEntity<SkillUpgradation> get(@PathVariable int id)
	{
		SkillUpgradation SU = skillUpgradationService.getSkillUpgradationById(id);
		if(SU==null) {
			return new ResponseEntity<SkillUpgradation>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<SkillUpgradation>(SU, HttpStatus.OK);
		}
	}
	
	@PutMapping("/skillUpgradation/{id}")
	private ResponseEntity<Void> update(@RequestBody SkillUpgradation toBeupdateSU,@PathVariable int id )
	{
		if(toBeupdateSU==null)
		{
			throw new RuntimeException("SkillUpgradation Object can't be NULL");
		}
		SkillUpgradation existingSU = skillUpgradationService.getSkillUpgradationById(id);
		if(toBeupdateSU==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			skillUpgradationService.updateSkillUpgradation(toBeupdateSU);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/skillUpgradation/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		SkillUpgradation deleteSkillUpgradation = skillUpgradationService.getSkillUpgradationById(id);
		if(deleteSkillUpgradation==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			skillUpgradationService.deleteSkillUpgradation(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

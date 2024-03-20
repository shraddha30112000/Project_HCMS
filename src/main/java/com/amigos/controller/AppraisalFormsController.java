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

import com.amigos.entities.AppraisalForms;
import com.amigos.services.AppraisalFormsService;

@RestController
public class AppraisalFormsController {

	@Autowired
	private AppraisalFormsService appraisalFormsService;

	@GetMapping("/appraisalForms")
	private ResponseEntity<List<AppraisalForms>> getAll() {
		return new ResponseEntity<List<AppraisalForms>>(appraisalFormsService.getAllAppraisalForms(), HttpStatus.OK);
	}

	// @RequestMapping(value = "/employee", method = RequestMethod.POST)
	@PostMapping(value = "/appraisalForms")
	private ResponseEntity<Void> save(@RequestBody AppraisalForms appraisalForms, UriComponentsBuilder ucBuilder) {
		if (appraisalForms == null) {
			throw new RuntimeException("AppraisalForms Object can't be NULL");
		}
		appraisalFormsService.addAppraisalForms(appraisalForms);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/appraisalForms/{id}")
	private ResponseEntity<AppraisalForms> get(@PathVariable int id) {
		AppraisalForms AF = appraisalFormsService.getAppraisalFormsById(id);
		if (AF == null) {
			return new ResponseEntity<AppraisalForms>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<AppraisalForms>(AF, HttpStatus.OK);
		}
	}

	@PutMapping("/appraisalForms/{id}")
		private ResponseEntity<Void> update(@RequestBody AppraisalForms toBeupdateAF,@PathVariable int id )
		{
			if(toBeupdateAF==null)
			{
				throw new RuntimeException("AppraisalForms Object can't be NULL");
			}
			AppraisalForms existingAF = appraisalFormsService.getAppraisalFormsById(id);
			if(toBeupdateAF==null) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}else {
				appraisalFormsService.updateAppraisalForms(toBeupdateAF);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		}
	@DeleteMapping("/appraisalForms/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		AppraisalForms deleteAppraisalForms = appraisalFormsService.getAppraisalFormsById(id);
		if(deleteAppraisalForms==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			appraisalFormsService.deleteAppraisalForms(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

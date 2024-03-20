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
import com.amigos.entities.Users;
import com.amigos.services.EmployeesService;
import com.amigos.services.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping("/users")
	private ResponseEntity<List<Users>> getAll()
	{
		return new ResponseEntity<List<Users>>(usersService.getAllUsers(), HttpStatus.OK);
	}
	
	//@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@PostMapping(value = "/users")
	private ResponseEntity<Void> save(@RequestBody Users users,UriComponentsBuilder ucBuilder)
	{
		if(users==null)
		{
			throw new RuntimeException("Employee Object can't be NULL");
		}
		usersService.addUsers(users);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{id}")
	private ResponseEntity<Users> get(@PathVariable int id)
	{
		Users U = usersService.getUsersById(id);
		if(U==null) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Users>(U, HttpStatus.OK);
		}
	}
	
	@PutMapping("/users/{id}")
	private ResponseEntity<Void> update(@RequestBody Users toBeupdateU,@PathVariable int id )
	{
		if(toBeupdateU==null)
		{
			throw new RuntimeException("Users Object can't be NULL");
		}
		Users existingU = usersService.getUsersById(id);
		if(toBeupdateU==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			usersService.updateUsers(toBeupdateU);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/users/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id )
	{
		Users deleteUsers = usersService.getUsersById(id);
		if(deleteUsers==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			usersService.deleteUsers(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}

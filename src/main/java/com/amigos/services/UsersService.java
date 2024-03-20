package com.amigos.services;

import java.util.List;

import com.amigos.entities.Users;

public interface UsersService {

List<Users> getAllUsers();
	
	void addUsers(Users users);
	
	void updateUsers(Users users);
	
	void deleteUsers(int userId);
	
	Users getUsersById(int userId);

}

package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.UsersDAO;
import com.amigos.entities.Users;

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDAO usersDAO;

	@Override
	public List<Users> getAllUsers() {
		return usersDAO.getAllUsers();
	}

	@Override
	public void addUsers(Users users) {
		usersDAO.addUsers(users);
	}

	@Override
	public void updateUsers(Users users) {
		usersDAO.updateUsers(users);
	}

	@Override
	public void deleteUsers(int userId) {
		usersDAO.deleteUsers(userId);
	}

	@Override
	public Users getUsersById(int userId) {
		return usersDAO.getUsersById(userId);
	}

}

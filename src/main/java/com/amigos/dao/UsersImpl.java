package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Users;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsersImpl implements UsersDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Users> getAllUsers() {
		return entityManager.unwrap(Session.class).createQuery("from Users", Users.class).getResultList();
	}

	@Override
	public void addUsers(Users users) {
		entityManager.unwrap(Session.class).saveOrUpdate(users);
	}

	@Override
	public void updateUsers(Users users) {
		entityManager.unwrap(Session.class).merge(users);
	}

	@Override
	public void deleteUsers(int userId) {
		entityManager.unwrap(Session.class).remove(userId);
	}

	@Override
	public Users getUsersById(int userId) {
		return entityManager.unwrap(Session.class).get(Users.class, userId);
	}

}

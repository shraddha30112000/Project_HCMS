package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.EmployeeManagers;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeManagersImpl implements EmployeeManagersDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<EmployeeManagers> getAllEmployeeManagers() {
		return entityManager.unwrap(Session.class).createQuery("from EmployeeManagers", EmployeeManagers.class).getResultList();
	}

	@Override
	public void addEmployeeManagers(EmployeeManagers employeeManager) {
		entityManager.unwrap(Session.class).saveOrUpdate(employeeManager);
	}

	@Override
	public void updateEmployeeManagers(EmployeeManagers employeeManagers) {
		entityManager.unwrap(Session.class).merge(employeeManagers);
	}

	@Override
	public void deleteEmployeeManagers(int relationshipId) {
		entityManager.unwrap(Session.class).remove(relationshipId);
	}

	@Override
	public EmployeeManagers getEmployeeManagersById(int relationshipId) {
		return entityManager.unwrap(Session.class).get(EmployeeManagers.class, relationshipId);
	}

}

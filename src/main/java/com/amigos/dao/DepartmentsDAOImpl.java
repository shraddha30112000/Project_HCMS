package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Departments;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DepartmentsDAOImpl implements DepartmentsDAO{

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Departments> getAllDepartments() {
		return entityManager.unwrap(Session.class).createQuery("from Departments",Departments.class).getResultList();
	}

	@Override
	public void addDepartments(Departments department) {
		entityManager.unwrap(Session.class).saveOrUpdate(department);
	}

	@Override
	public void updateDepartments(Departments departments) {
		entityManager.unwrap(Session.class).merge(departments);
	}

	@Override
	public void deleteDepartments(int departmentId) {
		entityManager.unwrap(Session.class).remove(departmentId);
	}

	@Override
	public Departments getDepartmentsById(int departmentId) {
		return entityManager.unwrap(Session.class).get(Departments.class, departmentId);
	}

}

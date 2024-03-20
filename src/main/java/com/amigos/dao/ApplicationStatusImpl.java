package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.ApplicationStatus;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ApplicationStatusImpl implements ApplicationStatusDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<ApplicationStatus> getAllApplicationStatus() {
		return entityManager.unwrap(Session.class).createQuery("from ApplicationStatus",ApplicationStatus.class).getResultList();
	}

	@Override
	public void addApplicationStatus(ApplicationStatus applicationStatus) {
		entityManager.unwrap(Session.class).saveOrUpdate(applicationStatus);
	}

	@Override
	public void updateApplicationStatus(ApplicationStatus application) {
		entityManager.unwrap(Session.class).merge(application);
	}

	@Override
	public void deleteApplicationStatus(ApplicationStatus obj) {
		entityManager.unwrap(Session.class).remove(obj);
	}

	@Override
	public ApplicationStatus getApplicationStatusById(int applicationStatusId) {
		return entityManager.unwrap(Session.class).get(ApplicationStatus.class, applicationStatusId);
	}
	
	
}
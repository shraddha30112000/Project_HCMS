package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.EducationalDetails;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EducationalDetailsImpl implements EducationalDetailsDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<EducationalDetails> getAllEductionalDetails() {
		return entityManager.unwrap(Session.class).createQuery("from EducationalDetails", EducationalDetails.class).getResultList();
	}

	@Override
	public void addEducationalDetails(EducationalDetails educationalDetail) {
		entityManager.unwrap(Session.class).saveOrUpdate(educationalDetail);
	}

	@Override
	public void updateEducationalDetails(EducationalDetails educationalDetails) {
		entityManager.unwrap(Session.class).merge(educationalDetails);
	}

	@Override
	public void deleteEducationalDetails(int educationId) {
		entityManager.unwrap(Session.class).remove(educationId);
	}

	@Override
	public EducationalDetails getEducationalDetailsById(int educationId) {
		return entityManager.unwrap(Session.class).get(EducationalDetails.class,educationId);
	}

}

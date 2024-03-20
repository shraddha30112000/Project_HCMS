package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.ExternalTrainers;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ExternalTrainersImpl implements ExternalTrainersDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<ExternalTrainers> getAllExternalTrainers() {
		return entityManager.unwrap(Session.class).createQuery("from ExternalTrainers", ExternalTrainers.class).getResultList();
	}

	@Override
	public void addExternalTrainers(ExternalTrainers externalTrainer) {
		entityManager.unwrap(Session.class).saveOrUpdate(externalTrainer);
	}

	@Override
	public void updateExternalTrainers(ExternalTrainers externalTrainers) {
		entityManager.unwrap(Session.class).merge(externalTrainers);
	}

	@Override
	public void deleteExternalTrainers(int trainerId) {
		entityManager.unwrap(Session.class).remove(trainerId);
	}

	@Override
	public ExternalTrainers getExternalTrainersById(int trainerId) {
		return entityManager.unwrap(Session.class).get(ExternalTrainers.class, trainerId);
	}

	
}

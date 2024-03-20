package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.TrainingModules;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class TrainingModulesImpl implements TrainingModulesDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<TrainingModules> getAllTrainingModules() {
		return entityManager.unwrap(Session.class).createQuery("from TrainingModules" , TrainingModules.class).getResultList();
	}

	@Override
	public void addTrainingModules(TrainingModules trainingModules) {
		entityManager.unwrap(Session.class).saveOrUpdate(trainingModules);
	}

	@Override
	public void updateTrainingModules(TrainingModules trainingModules) {
		entityManager.unwrap(Session.class).merge(trainingModules);
	}

	@Override
	public void deleteTrainingModules(int moduleId) {
		entityManager.unwrap(Session.class).remove(moduleId);
	}

	@Override
	public TrainingModules getTrainingModulesById(int moduleId) {
		return entityManager.unwrap(Session.class).get(TrainingModules.class, moduleId);
	}
	
	

}

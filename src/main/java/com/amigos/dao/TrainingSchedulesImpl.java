package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.TrainingSchedules;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class TrainingSchedulesImpl implements TrainingSchedulesDAO{

	@Autowired
	private EntityManager entityManager;
	@Override
	
	public List<TrainingSchedules> getAllTrainingSchedules() {
		return entityManager.unwrap(Session.class).createQuery("from TrainingSchedules", TrainingSchedules.class).getResultList();
	}

	@Override
	public void addTrainingSchedules(TrainingSchedules TrainingSchedules) {
		entityManager.unwrap(Session.class).saveOrUpdate(TrainingSchedules);
	}

	@Override
	public void updateTrainingSchedules(TrainingSchedules TrainingSchedules) {
		entityManager.unwrap(Session.class).merge(TrainingSchedules);
	}

	@Override
	public void deleteTrainingSchedules(int scheduleId) {
		entityManager.unwrap(Session.class).remove(scheduleId);
	}

	@Override
	public TrainingSchedules getTrainingSchedulesById(int scheduleId) {
		return entityManager.unwrap(Session.class).get(TrainingSchedules.class, scheduleId);
	}
	

}

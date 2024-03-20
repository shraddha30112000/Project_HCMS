package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.TrainingFeedback;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class TrainingFeedbackImpl implements TrainingFeedbackDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<TrainingFeedback> getAllTrainingFeedback() {
		return entityManager.unwrap(Session.class).createQuery("from TrainingFeedback", TrainingFeedback.class).getResultList();
	}

	@Override
	public void addTrainingFeedback(TrainingFeedback trainingFeedback) {
		entityManager.unwrap(Session.class).saveOrUpdate(trainingFeedback);
	}

	@Override
	public void updateTrainingFeedback(TrainingFeedback TrainingFeedback) {
		entityManager.unwrap(Session.class).merge(TrainingFeedback);
	}

	@Override
	public void deleteTrainingFeedback(int feedbackId) {
		entityManager.unwrap(Session.class).remove(feedbackId);
	}

	@Override
	public TrainingFeedback getTrainingFeedbackById(int feedbackId) {
		return entityManager.unwrap(Session.class).get(TrainingFeedback.class, feedbackId);
	}

}

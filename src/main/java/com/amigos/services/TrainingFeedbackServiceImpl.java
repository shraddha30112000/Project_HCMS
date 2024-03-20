package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.TrainingFeedbackDAO;
import com.amigos.entities.TrainingFeedback;

@Service
public class TrainingFeedbackServiceImpl implements TrainingFeedbackService{
	
	@Autowired
	private TrainingFeedbackDAO trainingFeedbackDAO;

	@Override
	public List<TrainingFeedback> getAllTrainingFeedback() {
		return trainingFeedbackDAO.getAllTrainingFeedback();
	}

	@Override
	public void addTrainingFeedback(TrainingFeedback TrainingFeedback) {
		trainingFeedbackDAO.addTrainingFeedback(TrainingFeedback);
	}

	@Override
	public void updateTrainingFeedback(TrainingFeedback TrainingFeedback) {
		trainingFeedbackDAO.updateTrainingFeedback(TrainingFeedback);
	}

	@Override
	public void deleteTrainingFeedback(int feedbackId) {
		trainingFeedbackDAO.deleteTrainingFeedback(feedbackId);
	}

	@Override
	public TrainingFeedback getTrainingFeedbackById(int feedbackId) {
		return trainingFeedbackDAO.getTrainingFeedbackById(feedbackId);
	}
	
	

}

package com.amigos.dao;

import java.util.List;

import com.amigos.entities.TrainingFeedback;

public interface TrainingFeedbackDAO {
	List<TrainingFeedback> getAllTrainingFeedback();
	
	void addTrainingFeedback(TrainingFeedback trainingFeedback);

	void updateTrainingFeedback(TrainingFeedback TrainingFeedback);
	
	void deleteTrainingFeedback(int feedbackId );
	
	TrainingFeedback getTrainingFeedbackById(int feedbackId);
}

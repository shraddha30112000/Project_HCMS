package com.amigos.services;

import java.util.List;

import com.amigos.entities.TrainingFeedback;

public interface TrainingFeedbackService {
	
List<TrainingFeedback> getAllTrainingFeedback();
	
	void addTrainingFeedback(TrainingFeedback TrainingFeedback);
	
	void updateTrainingFeedback(TrainingFeedback TrainingFeedback);
	
	void deleteTrainingFeedback(int feedbackId);
	
	TrainingFeedback getTrainingFeedbackById(int feedbackId);

}

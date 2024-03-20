package com.amigos.services;

import java.util.List;

import com.amigos.entities.TrainingSchedules;


public interface TrainingSchedulesService {
List<TrainingSchedules> getAllTrainingSchedules();
	
	void addTrainingSchedules(TrainingSchedules TrainingSchedules);
	
	void updateTrainingSchedules(TrainingSchedules TrainingSchedules);
	
	void deleteTrainingSchedules(int scheduleId);
	
	TrainingSchedules getTrainingSchedulesById(int scheduleId);

}

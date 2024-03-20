package com.amigos.dao;

import java.util.List;

import com.amigos.entities.TrainingSchedules;

public interface TrainingSchedulesDAO {
	
	List<TrainingSchedules> getAllTrainingSchedules();
	
	void addTrainingSchedules(TrainingSchedules TrainingSchedules);
	
	void updateTrainingSchedules(TrainingSchedules TrainingSchedules);
	
	void deleteTrainingSchedules(int scheduleId);
	
	TrainingSchedules getTrainingSchedulesById(int scheduleId);
	
}

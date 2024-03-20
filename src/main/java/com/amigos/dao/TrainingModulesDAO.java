package com.amigos.dao;

import java.util.List;

import com.amigos.entities.TrainingModules;

public interface TrainingModulesDAO {
	
	List<TrainingModules> getAllTrainingModules();
	
	void addTrainingModules(TrainingModules trainingModules);
	
	void updateTrainingModules(TrainingModules trainingModules);
	
	void deleteTrainingModules(int moduleId);
	
	TrainingModules getTrainingModulesById(int moduleId);
}

package com.amigos.services;

import java.util.List;

import com.amigos.entities.TrainingModules;

public interface TrainingModulesService {

List<TrainingModules> getAllTrainingModules();
	
	void addTrainingModules(TrainingModules trainingModules);
	
	void updateTrainingModules(TrainingModules trainingModules);
	
	void deleteTrainingModules(int moduleId);
	
	TrainingModules getTrainingModulesById(int moduleId);
}

package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.TrainingModulesDAO;
import com.amigos.entities.TrainingModules;

@Service
public class TrainingModulesServiceImpl implements TrainingModulesService{
	
	@Autowired
	private TrainingModulesDAO trainingModulesDAO;

	@Override
	public List<TrainingModules> getAllTrainingModules() {
		return trainingModulesDAO.getAllTrainingModules();
	}

	@Override
	public void addTrainingModules(TrainingModules trainingModules) {
		trainingModulesDAO.addTrainingModules(trainingModules);
	}

	@Override
	public void updateTrainingModules(TrainingModules trainingModules) {
		trainingModulesDAO.updateTrainingModules(trainingModules);
	}

	@Override
	public void deleteTrainingModules(int moduleId) {
		trainingModulesDAO.deleteTrainingModules(moduleId);
	}

	@Override
	public TrainingModules getTrainingModulesById(int moduleId) {
		return trainingModulesDAO.getTrainingModulesById(moduleId);
	}
	
	

}

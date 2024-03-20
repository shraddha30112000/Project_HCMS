package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.TrainingSchedulesDAO;
import com.amigos.entities.TrainingSchedules;

@Service
public class TrainingSchedulesServiceImpl implements TrainingSchedulesService{
	
	@Autowired
	private TrainingSchedulesDAO trainingSchedulesDAO;

	@Override
	public List<TrainingSchedules> getAllTrainingSchedules() {
		return trainingSchedulesDAO.getAllTrainingSchedules();
	}

	@Override
	public void addTrainingSchedules(TrainingSchedules TrainingSchedules) {
		trainingSchedulesDAO.addTrainingSchedules(TrainingSchedules);
	}

	@Override
	public void updateTrainingSchedules(TrainingSchedules TrainingSchedules) {
		trainingSchedulesDAO.updateTrainingSchedules(TrainingSchedules);
	}

	@Override
	public void deleteTrainingSchedules(int scheduleId) {
		trainingSchedulesDAO.deleteTrainingSchedules(scheduleId);
	}

	@Override
	public TrainingSchedules getTrainingSchedulesById(int scheduleId) {
		return trainingSchedulesDAO.getTrainingSchedulesById(scheduleId);
	}
	
	

}

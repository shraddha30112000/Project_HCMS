package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.TrainersDAO;
import com.amigos.entities.Trainers;

@Service
public class TrainersServiceImpl implements TrainersService{
	
	@Autowired
	private TrainersDAO trainersDAO;

	@Override
	public List<Trainers> getAllTrainers() {
		return trainersDAO.getAllTrainers();
	}

	@Override
	public void addTrainers(Trainers Trainers) {
		trainersDAO.addTrainers(Trainers);
	}

	@Override
	public void updateTrainers(Trainers Trainers) {
		trainersDAO.updateTrainers(Trainers);
	}

	@Override
	public void deleteTrainers(int trainerId) {
		trainersDAO.deleteTrainers(trainerId);
	}

	@Override
	public Trainers getTrainersById(int trainerId) {
		return trainersDAO.getTrainersById(trainerId);
	}

}

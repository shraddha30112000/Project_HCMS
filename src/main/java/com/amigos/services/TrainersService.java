package com.amigos.services;

import java.util.List;

import com.amigos.entities.Trainers;

public interface TrainersService {
List<Trainers> getAllTrainers();
	
	void addTrainers(Trainers Trainers);
	
	void updateTrainers(Trainers Trainers);
	
	void deleteTrainers(int trainerId);
	
	Trainers getTrainersById(int trainerId);

}

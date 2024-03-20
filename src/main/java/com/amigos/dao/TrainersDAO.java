package com.amigos.dao;

import java.util.List;

import com.amigos.entities.Trainers;

public interface TrainersDAO {
	
	List<Trainers> getAllTrainers();
	
	void addTrainers(Trainers trainers);
	
	void updateTrainers(Trainers trainers);
	
	void deleteTrainers(int trainerId);
	
	Trainers getTrainersById(int trainerId);
}

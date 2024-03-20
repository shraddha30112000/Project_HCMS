package com.amigos.dao;

import java.util.List;

import com.amigos.entities.ExternalTrainers;

public interface ExternalTrainersDAO {
	
	List<ExternalTrainers> getAllExternalTrainers();
	
	void addExternalTrainers(ExternalTrainers externalTrainer);
	
	void updateExternalTrainers(ExternalTrainers externalTrainers);
	
	void deleteExternalTrainers(int trainerId);
	
	ExternalTrainers getExternalTrainersById(int trainerId);

}

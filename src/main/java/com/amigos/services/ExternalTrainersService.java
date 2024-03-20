package com.amigos.services;

import java.util.List;

import com.amigos.entities.ExternalTrainers;

public interface ExternalTrainersService {
	
	List<ExternalTrainers> getAllExternalTrainers();
	
	void addExternalTrainers(ExternalTrainers externalTrainers);
	
	void updateExternalTrainers(ExternalTrainers externalTrainers);
	
	void deleteExternalTrainers(int trainerId);
	
	ExternalTrainers getExternalTrainersById(int trainerId);

}

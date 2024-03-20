package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.ExternalTrainersDAO;
import com.amigos.entities.ExternalTrainers;

@Service
public class ExternalTrainersServicveImpl implements ExternalTrainersService{
	
	@Autowired
	private ExternalTrainersDAO externalTrainersDAO;

	@Override
	public List<ExternalTrainers> getAllExternalTrainers() {
		return externalTrainersDAO.getAllExternalTrainers();
	}

	@Override
	public void addExternalTrainers(ExternalTrainers externalTrainers) {
		externalTrainersDAO.addExternalTrainers(externalTrainers);
	}

	@Override
	public void updateExternalTrainers(ExternalTrainers externalTrainers) {
		externalTrainersDAO.updateExternalTrainers(externalTrainers);
	}

	@Override
	public void deleteExternalTrainers(int trainerId) {
		externalTrainersDAO.deleteExternalTrainers(trainerId);
	}

	@Override
	public ExternalTrainers getExternalTrainersById(int trainerId) {
		return externalTrainersDAO.getExternalTrainersById(trainerId);
	}
	
	

}

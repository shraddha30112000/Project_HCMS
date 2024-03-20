package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EducationalDetailsDAO;
import com.amigos.entities.EducationalDetails;

@Service
public class EducationalDetailsServiceImpl implements EducationalDetailsService{

	@Autowired
	private EducationalDetailsDAO educationalDetailsDAO;
	
	@Override
	public List<EducationalDetails> getAllEducationalDetails() {
		return educationalDetailsDAO.getAllEductionalDetails();
	}

	@Override
	public void addEducationalDetails(EducationalDetails EducationalDetails) {
		educationalDetailsDAO.addEducationalDetails(EducationalDetails);
	}

	@Override
	public void updateEducationalDetails(EducationalDetails EducationalDetails) {
		educationalDetailsDAO.updateEducationalDetails(EducationalDetails);
	}

	@Override
	public void deleteEducationalDetails(int educationId) {
		educationalDetailsDAO.deleteEducationalDetails(educationId);
	}

	@Override
	public EducationalDetails getEducationalDetailsById(int educationId) {
		return educationalDetailsDAO.getEducationalDetailsById(educationId);
	}
	

}

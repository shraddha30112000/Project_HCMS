package com.amigos.dao;

import java.util.List;

import com.amigos.entities.EducationalDetails;

public interface EducationalDetailsDAO {
	List<EducationalDetails> getAllEductionalDetails();
	
	void addEducationalDetails(EducationalDetails educationalDetail);
	
	void updateEducationalDetails(EducationalDetails educationalDetails);
	
	void deleteEducationalDetails(int educationId);
	
	EducationalDetails getEducationalDetailsById(int educationId);
}

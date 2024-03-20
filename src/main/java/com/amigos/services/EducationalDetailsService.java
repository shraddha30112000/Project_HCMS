package com.amigos.services;

import java.util.List;

import com.amigos.entities.EducationalDetails;

public interface EducationalDetailsService {
	
	List<EducationalDetails> getAllEducationalDetails();
	
	void addEducationalDetails(EducationalDetails EducationalDetails);
	
	void updateEducationalDetails(EducationalDetails EducationalDetails);
	
	void deleteEducationalDetails(int educationId);
	
	EducationalDetails getEducationalDetailsById(int educationId);

}

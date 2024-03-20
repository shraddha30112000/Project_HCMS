package com.amigos.services;

import java.util.List;

import com.amigos.entities.ApplicationStatus;

public interface ApplicationStatusService {
	List<ApplicationStatus> getAllApplicationStatus();
	
	void addApplicationStatus(ApplicationStatus applicationStatus);
	
	void updateApplicationStatus(ApplicationStatus applicationStatus);
	
	void deleteApplicationStatus(int applicationId);
	
	ApplicationStatus getApplicationStatusById(int applicationId);
}

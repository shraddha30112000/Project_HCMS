package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.ApplicationStatusDAO;
import com.amigos.entities.ApplicationStatus;

@Service
public class ApplicationStatusServiceImpl implements ApplicationStatusService{
	
	@Autowired
	private ApplicationStatusDAO applicationStatusDAO;

	@Override
	public List<ApplicationStatus> getAllApplicationStatus() {
		return applicationStatusDAO.getAllApplicationStatus();
	}

	@Override
	public void addApplicationStatus(ApplicationStatus applicationStatus) {
		applicationStatusDAO.addApplicationStatus(applicationStatus);
	}

	@Override
	public void updateApplicationStatus(ApplicationStatus applicationStatus) {
		applicationStatusDAO.updateApplicationStatus(applicationStatus);
	}

	@Override
	public void deleteApplicationStatus(int applicationId) {
		applicationStatusDAO.deleteApplicationStatus(null);
	}

	@Override
	public ApplicationStatus getApplicationStatusById(int applicationId) {
		return applicationStatusDAO.getApplicationStatusById(applicationId);
	}
	
	
}

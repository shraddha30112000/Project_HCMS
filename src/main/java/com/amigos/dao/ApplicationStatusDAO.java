package com.amigos.dao;

import java.util.List;

import com.amigos.entities.ApplicationStatus;
import com.amigos.entities.Employees;

public interface ApplicationStatusDAO {
	List<ApplicationStatus> getAllApplicationStatus();

	void addApplicationStatus(ApplicationStatus applicationStatus);

	void updateApplicationStatus(ApplicationStatus application);

	void deleteApplicationStatus(ApplicationStatus obj);

	ApplicationStatus getApplicationStatusById(int applicationId);

}

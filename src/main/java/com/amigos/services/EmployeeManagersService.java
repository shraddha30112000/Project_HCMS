package com.amigos.services;

import java.util.List;

import com.amigos.entities.EmployeeManagers;

public interface EmployeeManagersService {
	
	List<EmployeeManagers> getAllEmployeeManagers();
	
	void addEmployeeManagers(EmployeeManagers EmployeeManagers);
	
	void updateEmployeeManagers(EmployeeManagers EmployeeManagers);
	
	void deleteEmployeeManagers(int relationshipId);
	
	EmployeeManagers getEmployeeManagersById(int relationshipId);

}

package com.amigos.dao;

import java.util.List;

import com.amigos.entities.EmployeeManagers;

public interface EmployeeManagersDAO {
	
	List<EmployeeManagers> getAllEmployeeManagers();
	
	void addEmployeeManagers(EmployeeManagers employeeManager);
	
	void updateEmployeeManagers(EmployeeManagers employeeManagers);

	void deleteEmployeeManagers(int relationshipId);

	EmployeeManagers getEmployeeManagersById(int relationshipId);
}

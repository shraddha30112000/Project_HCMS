package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeeManagersDAO;
import com.amigos.entities.EmployeeManagers;

@Service
public class EmployeeManagersServiceImpl implements EmployeeManagersService{
	
	@Autowired
	private EmployeeManagersDAO employeeManagersDAO;

	@Override
	public List<EmployeeManagers> getAllEmployeeManagers() {
		return employeeManagersDAO.getAllEmployeeManagers();
	}

	@Override
	public void addEmployeeManagers(EmployeeManagers EmployeeManagers) {
		employeeManagersDAO.addEmployeeManagers(EmployeeManagers);
	}

	@Override
	public void updateEmployeeManagers(EmployeeManagers EmployeeManagers) {
		employeeManagersDAO.updateEmployeeManagers(EmployeeManagers);
	}

	@Override
	public void deleteEmployeeManagers(int relationshipId) {
		employeeManagersDAO.deleteEmployeeManagers(relationshipId);
	}

	@Override
	public EmployeeManagers getEmployeeManagersById(int relationshipId) {
		return employeeManagersDAO.getEmployeeManagersById(relationshipId);
	}
	

}

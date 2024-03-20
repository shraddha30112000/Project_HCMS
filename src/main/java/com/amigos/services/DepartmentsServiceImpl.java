package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.DepartmentsDAO;
import com.amigos.entities.Departments;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{
	
	@Autowired
	private DepartmentsDAO departmentsDAO;

	@Override
	public List<Departments> getAllDepartments() {
		return departmentsDAO.getAllDepartments();
	}

	@Override
	public void addDepartment(Departments department) {
		departmentsDAO.addDepartments(department);
	}

	@Override
	public void updateDepartment(Departments department) {
		departmentsDAO.updateDepartments(department);
	}

	@Override
	public void deleteDepartment(int departmentId) {
		departmentsDAO.deleteDepartments(departmentId);
	}

	@Override
	public Departments getDepartmentById(int departmentId) {
		return departmentsDAO.getDepartmentsById(departmentId);
	}

}

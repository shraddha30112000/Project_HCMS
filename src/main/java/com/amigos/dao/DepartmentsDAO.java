package com.amigos.dao;

import java.util.List;

import com.amigos.entities.Departments;

public interface DepartmentsDAO {
	List<Departments> getAllDepartments();
	
	void addDepartments(Departments department);
	
	void updateDepartments(Departments departments);

	void deleteDepartments(int  departmentId);

	Departments getDepartmentsById(int departmentId);
}

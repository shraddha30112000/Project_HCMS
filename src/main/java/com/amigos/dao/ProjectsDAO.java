package com.amigos.dao;

import java.util.List;

import com.amigos.entities.Projects;

public interface ProjectsDAO {

	List<Projects> getAllProjects();
	
	void addProjects(Projects project);
	
	void updateProjects(Projects projects);
	
	void deleteProjects(int projectId);
	
	Projects getProjectsById(int projectId);
}

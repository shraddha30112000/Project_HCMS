package com.amigos.services;

import java.util.List;

import com.amigos.entities.Projects;

public interface ProjectsService {
	
	List<Projects> getAllProjects();
	
	void addProjects(Projects projects);
	
	void updateProjects(Projects Projects);
	
	void deleteProjects(int projectId);
	
	Projects getProjectsById(int projectId);

}

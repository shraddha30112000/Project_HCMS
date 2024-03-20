package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.ProjectsDAO;
import com.amigos.entities.Projects;

@Service
public class ProjectsServiceImpl implements ProjectsService{
	
	@Autowired
	private ProjectsDAO projectsDAO;

	@Override
	public List<Projects> getAllProjects() {
		return projectsDAO.getAllProjects();
	}

	@Override
	public void addProjects(Projects projects) {
		projectsDAO.addProjects(projects);
	}

	@Override
	public void updateProjects(Projects Projects) {
		projectsDAO.updateProjects(Projects);
	}

	@Override
	public void deleteProjects(int projectId) {
		projectsDAO.deleteProjects(projectId);
	}

	@Override
	public Projects getProjectsById(int projectId) {
		return projectsDAO.getProjectsById(projectId);
	}
	
	

}

package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Projects;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class ProjectsImpl implements ProjectsDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Projects> getAllProjects() {
		return entityManager.unwrap(Session.class).createQuery("from Projects", Projects.class).getResultList();
	}

	@Override
	public void addProjects(Projects project) {
		entityManager.unwrap(Session.class).saveOrUpdate(project);
	}

	@Override
	public void updateProjects(Projects projects) {
		entityManager.unwrap(Session.class).merge(projects);
	}

	@Override
	public void deleteProjects(int projectId) {
		entityManager.unwrap(Session.class).remove(projectId);
	}

	@Override
	public Projects getProjectsById(int projectId) {
		return entityManager.unwrap(Session.class).get(Projects.class, projectId);
	}
	

}

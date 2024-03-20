package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.SkillMatrix;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SkillMatrixImpl implements SkillMatrixDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<SkillMatrix> getAllSkillMatrix() {
		return entityManager.unwrap(Session.class).createQuery("from SkillMatrix", SkillMatrix.class).getResultList();
	}

	@Override
	public void addSkillMatrix(SkillMatrix skillMatrixs) {
		entityManager.unwrap(Session.class).saveOrUpdate(skillMatrixs);
	}

	@Override
	public void updateSkillMatrix(SkillMatrix skillMatrix) {
		entityManager.unwrap(Session.class).merge(skillMatrix);
	}

	@Override
	public void deleteSkillMatrix(int matrixId) {
		entityManager.unwrap(Session.class).remove(matrixId);
	}

	@Override
	public SkillMatrix getSkillMatrixById(int matrixId) {
		return entityManager.unwrap(Session.class).get(SkillMatrix.class, matrixId);
	}

}

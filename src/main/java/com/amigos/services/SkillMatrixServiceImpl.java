package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.SkillMatrixDAO;
import com.amigos.entities.SkillMatrix;

@Service
public class SkillMatrixServiceImpl implements SkillMatrixService{
	
	@Autowired
	private SkillMatrixDAO skillMatrixDAO;

	@Override
	public List<SkillMatrix> getAllSkillMatrix() {
		return skillMatrixDAO.getAllSkillMatrix();
	}

	@Override
	public void addSkillMatrix(SkillMatrix SkillMatrix) {
		skillMatrixDAO.addSkillMatrix(SkillMatrix);
	}

	@Override
	public void updateSkillMatrix(SkillMatrix SkillMatrix) {
		skillMatrixDAO.updateSkillMatrix(SkillMatrix);
	}

	@Override
	public void deleteSkillMatrix(int matrixId) {
		skillMatrixDAO.deleteSkillMatrix(matrixId);
	}

	@Override
	public SkillMatrix getSkillMatrixById(int matrixId) {
		return skillMatrixDAO.getSkillMatrixById(matrixId);
	}

}

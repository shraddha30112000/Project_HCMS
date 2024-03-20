package com.amigos.dao;

import java.util.List;

import com.amigos.entities.SkillMatrix;

public interface SkillMatrixDAO {

	List<SkillMatrix> getAllSkillMatrix();
	
	void addSkillMatrix(SkillMatrix skillMatrixs);
	
	void updateSkillMatrix(SkillMatrix skillMatrix);
	
	void deleteSkillMatrix(int matrixId);
	
	SkillMatrix getSkillMatrixById(int matrixId);
}

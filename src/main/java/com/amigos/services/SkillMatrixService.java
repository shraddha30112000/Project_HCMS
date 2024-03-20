package com.amigos.services;

import java.util.List;

import com.amigos.entities.SkillMatrix;



public interface SkillMatrixService {

List<SkillMatrix> getAllSkillMatrix();
	
	void addSkillMatrix(SkillMatrix SkillMatrix);
	
	void updateSkillMatrix(SkillMatrix SkillMatrix);
	
	void deleteSkillMatrix(int matrixId);
	
	SkillMatrix getSkillMatrixById(int matrixId);
}

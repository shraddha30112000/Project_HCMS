package com.amigos.dao;

import java.util.List;

import com.amigos.entities.SkillUpgradation;

public interface SkillUpgradationDAO {
	
	List<SkillUpgradation> getAllSkillUpgradation();
	
	void addSkillUpgradation(SkillUpgradation skillUpgradations);
	
	void updateSkillUpgradation(SkillUpgradation skillUpgradation);
	
	void deleteSkillUpgradation(int upgradationId);
	
	SkillUpgradation getSkillUpgradationById(int upgradationId);

}

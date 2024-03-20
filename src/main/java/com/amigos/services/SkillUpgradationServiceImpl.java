package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.SkillUpgradationDAO;
import com.amigos.entities.SkillUpgradation;

@Service
public class SkillUpgradationServiceImpl implements SkillUpgradationService{
	
	@Autowired
	private SkillUpgradationDAO skillUpgradationDAO;

	@Override
	public List<SkillUpgradation> getAllSkillUpgradation() {
		return skillUpgradationDAO.getAllSkillUpgradation();
	}

	@Override
	public void addSkillUpgradation(SkillUpgradation skillUpgradation) {
		skillUpgradationDAO.addSkillUpgradation(skillUpgradation);
	}

	@Override
	public void updateSkillUpgradation(SkillUpgradation skillUpgradation) {
		skillUpgradationDAO.updateSkillUpgradation(skillUpgradation);
	}

	@Override
	public void deleteSkillUpgradation(int upgradationId) {
		skillUpgradationDAO.deleteSkillUpgradation(upgradationId);
	}

	@Override
	public SkillUpgradation getSkillUpgradationById(int upgradationId) {
		return skillUpgradationDAO.getSkillUpgradationById(upgradationId);
	}

}

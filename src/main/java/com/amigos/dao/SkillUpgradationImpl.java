package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.SkillUpgradation;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SkillUpgradationImpl implements SkillUpgradationDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<SkillUpgradation> getAllSkillUpgradation() {
		return entityManager.unwrap(Session.class).createQuery("from SkillUpgradation", SkillUpgradation.class).getResultList();
	}

	@Override
	public void addSkillUpgradation(SkillUpgradation skillUpgradations) {
		entityManager.unwrap(Session.class).saveOrUpdate(skillUpgradations);
	}

	@Override
	public void updateSkillUpgradation(SkillUpgradation skillUpgradation) {
		entityManager.unwrap(Session.class).merge(skillUpgradation);
	}

	@Override
	public void deleteSkillUpgradation(int upgradationId) {
		entityManager.unwrap(Session.class).remove(upgradationId);
	}

	@Override
	public SkillUpgradation getSkillUpgradationById(int upgradationId) {
		return entityManager.unwrap(Session.class).get(SkillUpgradation.class, upgradationId);
	}

}

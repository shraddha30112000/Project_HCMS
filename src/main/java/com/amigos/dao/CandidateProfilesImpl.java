package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.CandidateProfiles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class CandidateProfilesImpl implements CandidateProfilesDAO{

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<CandidateProfiles> getAllCandidateProfiles() {
		return entityManager.unwrap(Session.class).createQuery("from CandidateProfiles", CandidateProfiles.class).getResultList();
	}

	@Override
	public void addCandidateProfiles(CandidateProfiles candidateProfiles) {
		entityManager.unwrap(Session.class).saveOrUpdate(candidateProfiles);
	}

	@Override
	public void updateCandidateProfiles(CandidateProfiles candidateProfile) {
		entityManager.unwrap(Session.class).merge(candidateProfile);
	}

	@Override
	public void deleteCandidateProfiles(CandidateProfiles obj) {
		entityManager.unwrap(Session.class).remove(obj);
	}

	@Override
	public CandidateProfiles getCandidateProfilesById(int candidateId) {
		return entityManager.unwrap(Session.class).get(CandidateProfiles.class, candidateId);
	}
}

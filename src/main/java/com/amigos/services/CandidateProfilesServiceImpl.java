package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.CandidateProfilesDAO;
import com.amigos.entities.CandidateProfiles;

@Service
public class CandidateProfilesServiceImpl implements CandidateProfilesService{
	
	@Autowired
	private CandidateProfilesDAO candidateProfilesDAO;

	@Override
	public List<CandidateProfiles> getAllCandidateProfiles() {
		return candidateProfilesDAO.getAllCandidateProfiles();
	}

	@Override
	public void addCandidateProfiles(CandidateProfiles candidateProfiles) {
		candidateProfilesDAO.addCandidateProfiles(candidateProfiles);
	}

	@Override
	public void updateCandidateProfiles(CandidateProfiles candidateProfiles) {
		candidateProfilesDAO.updateCandidateProfiles(candidateProfiles);
	}

	@Override
	public void deleteCandidateProfiles(int candidateId) {
		candidateProfilesDAO.deleteCandidateProfiles(null);
	}

	@Override
	public CandidateProfiles getCandidateProfilesById(int candidateId) {
		return candidateProfilesDAO.getCandidateProfilesById(candidateId);
	}
	
	

}

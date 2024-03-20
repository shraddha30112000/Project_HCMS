package com.amigos.services;

import java.util.List;

import com.amigos.entities.CandidateProfiles;

public interface CandidateProfilesService {
	List<CandidateProfiles> getAllCandidateProfiles();
	
	void addCandidateProfiles(CandidateProfiles candidateProfiles);
	
	void updateCandidateProfiles(CandidateProfiles candidateProfiles);
	
	void deleteCandidateProfiles(int candidateId);
	
	CandidateProfiles getCandidateProfilesById(int candidateId);
}

package com.amigos.dao;

import java.util.List;

import com.amigos.entities.CandidateProfiles;

public interface CandidateProfilesDAO {

	List<CandidateProfiles> getAllCandidateProfiles();

	void addCandidateProfiles(CandidateProfiles candidateProfiles);

	void updateCandidateProfiles(CandidateProfiles candidateProfile);

	void deleteCandidateProfiles(CandidateProfiles obj);

	CandidateProfiles getCandidateProfilesById(int candidateId);
}

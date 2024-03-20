package com.amigos.dao;

import java.util.List;

import com.amigos.entities.Certifications;

public interface CertificationsDAO {

	List<Certifications> getAllCertifications();
	
	void addCertifications(Certifications certifications);
	
	void updateCertifications(Certifications certifications);
	
	void deleteCertifications(int certificationId);
	
	Certifications getCertificationsById(int certificationId);
	
}

package com.amigos.services;

import java.util.List;

import com.amigos.entities.Certifications;

public interface CertificationsService {
	List<Certifications> getAllCertifications();
	
	void addCertifications(Certifications Certifications);
	
	void updateCertifications(Certifications Certifications);
	
	void deleteCertifications(int certificationId);
	
	Certifications getCertificationsById(int certificationId);
}

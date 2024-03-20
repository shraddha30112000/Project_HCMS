package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.CertificationsDAO;
import com.amigos.entities.Certifications;

@Service
public class CertificationsServiceImpl implements CertificationsService{
	
	@Autowired
	private CertificationsDAO certificationsDAO;

	@Override
	public List<Certifications> getAllCertifications() {
		return certificationsDAO.getAllCertifications();
	}

	@Override
	public void addCertifications(Certifications Certifications) {
		certificationsDAO.addCertifications(Certifications);
	}

	@Override
	public void updateCertifications(Certifications Certifications) {
		certificationsDAO.updateCertifications(Certifications);
	}

	@Override
	public void deleteCertifications(int certificationId) {
		certificationsDAO.deleteCertifications(certificationId);
	}

	@Override
	public Certifications getCertificationsById(int certificationId) {
		return certificationsDAO.getCertificationsById(certificationId);
	}

}

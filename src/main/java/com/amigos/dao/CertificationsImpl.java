package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Certifications;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CertificationsImpl implements CertificationsDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Certifications> getAllCertifications() {
		return entityManager.unwrap(Session.class).createQuery("from Certifications",Certifications.class).getResultList();
	}

	@Override
	public void addCertifications(Certifications certifications) {
		entityManager.unwrap(Session.class).saveOrUpdate(certifications);
	}

	@Override
	public void updateCertifications(Certifications certifications) {
		entityManager.unwrap(Session.class).merge(certifications);
	}

	@Override
	public void deleteCertifications(int certificationId) {
		entityManager.unwrap(Session.class).remove(certificationId);
	}

	@Override
	public Certifications getCertificationsById(int certificationId) {
		return entityManager.unwrap(Session.class).get(Certifications.class, certificationId);
	}
	
	

}

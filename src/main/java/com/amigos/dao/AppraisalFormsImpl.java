package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.AppraisalForms;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AppraisalFormsImpl implements AppraisalFormsDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<AppraisalForms> getAllAppraisalForms() {
		return entityManager.unwrap(Session.class).createQuery("from AppraisalForms",AppraisalForms.class).getResultList();
	}

	@Override
	public void addAppraisalForms(AppraisalForms appraisalForms) {
		entityManager.unwrap(Session.class).saveOrUpdate(appraisalForms);
	}

	@Override
	public void updateAppraisalForms(AppraisalForms appraisalForm) {
		entityManager.unwrap(Session.class).merge(appraisalForm);
	}

	@Override
	public void deleteAppraisalForms(AppraisalForms obj) {
		entityManager.unwrap(Session.class).remove(obj);
	}

	@Override
	public AppraisalForms getAppraisalFormsById(int formId) {
		return entityManager.unwrap(Session.class).get(AppraisalForms.class, formId);
	}

}

package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.AppraisalFormsDAO;
import com.amigos.entities.AppraisalForms;

@Service
public class AppraisalFormsServiceImpl implements AppraisalFormsService{
	
	@Autowired
	private AppraisalFormsDAO appraisalFormsDAO;

	@Override
	public List<AppraisalForms> getAllAppraisalForms() {
		return appraisalFormsDAO.getAllAppraisalForms();
	}

	@Override
	public void addAppraisalForms(AppraisalForms appraisalForms) {
		appraisalFormsDAO.addAppraisalForms(appraisalForms);
	}

	@Override
	public void updateAppraisalForms(AppraisalForms appraisalForms) {
		appraisalFormsDAO.updateAppraisalForms(appraisalForms);
	}

	@Override
	public void deleteAppraisalForms(int formId) {
		appraisalFormsDAO.deleteAppraisalForms(null);
	}

	@Override
	public AppraisalForms getAppraisalFormsById(int formId) {
		return appraisalFormsDAO.getAppraisalFormsById(formId);
	}
	
	

}

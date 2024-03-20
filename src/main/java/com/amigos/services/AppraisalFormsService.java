package com.amigos.services;

import java.util.List;

import com.amigos.entities.AppraisalForms;

public interface AppraisalFormsService {
	
	List<AppraisalForms> getAllAppraisalForms();
	
	void addAppraisalForms(AppraisalForms appraisalForms);
	
	void updateAppraisalForms(AppraisalForms appraisalForms);
	
	void deleteAppraisalForms(int formId);
	
	AppraisalForms getAppraisalFormsById(int formId);

}

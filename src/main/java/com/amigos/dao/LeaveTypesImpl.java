package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.LeaveTypes;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LeaveTypesImpl implements LeaveTypesDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<LeaveTypes> getAllLeaveTypes() {
		return entityManager.unwrap(Session.class).createQuery("from LeaveTypes", LeaveTypes.class).getResultList();
	}

	@Override
	public void addLeaveTypes(LeaveTypes leaveType) {
		entityManager.unwrap(Session.class).saveOrUpdate(leaveType);
	}

	@Override
	public void updateLeaveTypes(LeaveTypes leaveTypes) {
		entityManager.unwrap(Session.class).merge(leaveTypes);
	}

	@Override
	public void deleteLeaveTypes(int leaveTypeId) {
		entityManager.unwrap(Session.class).remove(leaveTypeId);
	}

	@Override
	public LeaveTypes getLeaveTypesById(int leaveTypeId) {
		return entityManager.unwrap(Session.class).get(LeaveTypes.class, leaveTypeId);
	}

}

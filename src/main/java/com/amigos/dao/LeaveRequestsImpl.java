package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.LeaveRequests;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LeaveRequestsImpl implements LeaveRequestsDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<LeaveRequests> getallLeaveRequests() {
		return entityManager.unwrap(Session.class).createQuery("from LeaveRequests", LeaveRequests.class).getResultList();
	}

	@Override
	public void addLeaveRequests(LeaveRequests leaveRequest) {
		entityManager.unwrap(Session.class).saveOrUpdate(leaveRequest);
	}

	@Override
	public void updateLeaveRequests(LeaveRequests leaveRequests) {
		entityManager.unwrap(Session.class).merge(leaveRequests);
	}

	@Override
	public void deleteLeaveRequests(int leaveRequestId) {
		entityManager.unwrap(Session.class).remove(leaveRequestId);
	}

	@Override
	public LeaveRequests getLeaveRequestsById(int leaveRequestId) {
		return entityManager.unwrap(Session.class).get(LeaveRequests.class, leaveRequestId);
	}

}

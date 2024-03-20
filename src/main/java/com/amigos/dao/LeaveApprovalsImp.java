package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.LeaveApprovals;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LeaveApprovalsImp implements LeaveApprovalsDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<LeaveApprovals> getAllLeaveApprovals() {
		return entityManager.unwrap(Session.class).createQuery("from LeaveApprovals", LeaveApprovals.class).getResultList();
	}

	@Override
	public void addLeaveApprovals(LeaveApprovals leaveApproval) {
		entityManager.unwrap(Session.class).saveOrUpdate(leaveApproval);
	}

	@Override
	public void updateLeaveApprovals(LeaveApprovals leaveApprovals) {
		entityManager.unwrap(Session.class).merge(leaveApprovals);
	}

	@Override
	public void deleteLeaveApprovals(int approvalId) {
		entityManager.unwrap(Session.class).remove(approvalId);
	}

	@Override
	public LeaveApprovals getLeaveApprovalsById(int approvalId) {
		return entityManager.unwrap(Session.class).get(LeaveApprovals.class, approvalId);
	}

}

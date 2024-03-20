package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.LeaveApprovalsDAO;
import com.amigos.entities.LeaveApprovals;

@Service
public class LeaveApprovalsServiceImpl implements LeaveApprovalsService{
	
	@Autowired
	private LeaveApprovalsDAO leaveApprovalsDAO;

	@Override
	public List<LeaveApprovals> getAllLeaveApprovals() {
		return leaveApprovalsDAO.getAllLeaveApprovals();
	}

	@Override
	public void addLeaveApprovals(LeaveApprovals leaveApprovals) {
		leaveApprovalsDAO.addLeaveApprovals(leaveApprovals);
	}

	@Override
	public void updateLeaveApprovals(LeaveApprovals leaveApprovals) {
		leaveApprovalsDAO.updateLeaveApprovals(leaveApprovals);
	}

	@Override
	public void deleteLeaveApprovals(int approvalId) {
		leaveApprovalsDAO.deleteLeaveApprovals(approvalId);
	}

	@Override
	public LeaveApprovals getLeaveApprovalsById(int approvalId) {
		return leaveApprovalsDAO.getLeaveApprovalsById(approvalId);
	}
	
	

}

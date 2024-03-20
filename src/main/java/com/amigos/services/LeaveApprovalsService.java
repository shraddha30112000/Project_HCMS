package com.amigos.services;

import java.util.List;

import com.amigos.entities.LeaveApprovals;

public interface LeaveApprovalsService {

	List<LeaveApprovals> getAllLeaveApprovals();
	
	void addLeaveApprovals(LeaveApprovals leaveApprovals);
	
	void updateLeaveApprovals(LeaveApprovals leaveApprovals);
	
	void deleteLeaveApprovals(int approvalId);
	
	LeaveApprovals getLeaveApprovalsById(int approvalId);
}

package com.amigos.dao;

import java.util.List;

import com.amigos.entities.LeaveRequests;

public interface LeaveRequestsDAO {

	List<LeaveRequests> getallLeaveRequests();
	
	void addLeaveRequests(LeaveRequests leaveRequest);
	
	void updateLeaveRequests(LeaveRequests leaveRequests);
	
	void deleteLeaveRequests(int leaveRequestId);
	
	LeaveRequests getLeaveRequestsById(int leaveRequestId);
}

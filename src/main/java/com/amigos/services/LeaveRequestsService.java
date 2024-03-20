package com.amigos.services;

import java.util.List;

import com.amigos.entities.LeaveRequests;

public interface LeaveRequestsService {
	
	List<LeaveRequests> getAllLeaveRequests();
	
	void addLeaveRequests(LeaveRequests leaveRequests);
	
	void updateLeaveRequests(LeaveRequests leaveRequests);
	
	void deleteLeaveRequests(int leaveRequestId);
	
	LeaveRequests getLeaveRequestsById(int leaveRequestId);
}

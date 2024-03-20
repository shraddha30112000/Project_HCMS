package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.LeaveRequestsDAO;
import com.amigos.entities.LeaveRequests;

@Service
public class LeaveRequestsServiceImpl implements LeaveRequestsService{
	
	@Autowired
	private LeaveRequestsDAO leaveRequestsDAO;
	
	@Override
	public List<LeaveRequests> getAllLeaveRequests() {
		return leaveRequestsDAO.getallLeaveRequests();
	}

	@Override
	public void addLeaveRequests(LeaveRequests leaveRequests) {
		leaveRequestsDAO.addLeaveRequests(leaveRequests);
	}

	@Override
	public void updateLeaveRequests(LeaveRequests leaveRequests) {
		leaveRequestsDAO.updateLeaveRequests(leaveRequests);
	}

	@Override
	public void deleteLeaveRequests(int leaveRequestId) {
		leaveRequestsDAO.deleteLeaveRequests(leaveRequestId);
	}

	@Override
	public LeaveRequests getLeaveRequestsById(int leaveRequestId) {
		return leaveRequestsDAO.getLeaveRequestsById(leaveRequestId);
	}
	
	

}

package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.LeaveTypesDAO;
import com.amigos.entities.LeaveTypes;

@Service
public class LeaveTypesServiceImpl implements LeaveTypesService{
	
	@Autowired
	private LeaveTypesDAO leaveTypesDAO;

	@Override
	public List<LeaveTypes> getAllLeaveTypes() {
		return leaveTypesDAO.getAllLeaveTypes();
	}

	@Override
	public void addLeaveTypes(LeaveTypes leaveTypes) {
		leaveTypesDAO.addLeaveTypes(leaveTypes);
	}

	@Override
	public void updateLeaveTypes(LeaveTypes leaveTypes) {
		leaveTypesDAO.updateLeaveTypes(leaveTypes);
	}

	@Override
	public void deleteLeaveTypes(int leaveTypeId) {
		leaveTypesDAO.deleteLeaveTypes(leaveTypeId);
	}

	@Override
	public LeaveTypes getLeaveTypesById(int leaveTypeId) {
		return leaveTypesDAO.getLeaveTypesById(leaveTypeId);
	}
	

}

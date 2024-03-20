package com.amigos.services;

import java.util.List;

import com.amigos.entities.LeaveTypes;

public interface LeaveTypesService {
	
	List<LeaveTypes> getAllLeaveTypes();
	
	void addLeaveTypes(LeaveTypes leaveTypes);
	
	void updateLeaveTypes(LeaveTypes leaveTypes);
	
	void deleteLeaveTypes(int leaveTypeId);
	
	LeaveTypes getLeaveTypesById(int leaveTypeId);
}

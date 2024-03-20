package com.amigos.dao;

import java.util.List;

import com.amigos.entities.LeaveTypes;

public interface LeaveTypesDAO {
	
	List<LeaveTypes> getAllLeaveTypes();
	
	void addLeaveTypes(LeaveTypes leaveType);

	void updateLeaveTypes(LeaveTypes leaveTypes);
	
	void deleteLeaveTypes(int leaveTypeId);
	
	LeaveTypes getLeaveTypesById(int leaveTypeId);
}

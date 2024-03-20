package com.amigos.services;

import java.util.List;

import com.amigos.entities.Payroll;

public interface PayrollService {
	
	List<Payroll> getAllPayrolls();
	
	void addPayroll(Payroll payroll);
	
	void updatePayroll(Payroll payroll);
	
	void deletePayroll(int payrollId);
	
	Payroll getPayrollById(int payrollId);
}

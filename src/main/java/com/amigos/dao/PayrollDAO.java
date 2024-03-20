package com.amigos.dao;

import java.util.List;

import com.amigos.entities.Payroll;

public interface PayrollDAO {

	List<Payroll> getAllPayrolls();
	 
	void addPayroll(Payroll payroll);
	
	void updatePayroll(Payroll Payrolls);
	
	void deletePayroll(int payrollId);
	
	Payroll getPayrollById(int payrollId);
	
}

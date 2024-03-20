package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.PayrollDAO;
import com.amigos.entities.Payroll;

@Service
public class PayrollServiceImpl implements PayrollService{
	
	@Autowired
	private PayrollDAO payrollDAO;

	@Override
	public List<Payroll> getAllPayrolls() {
		return payrollDAO.getAllPayrolls();
	}

	@Override
	public void addPayroll(Payroll payroll) {
		payrollDAO.addPayroll(payroll);
	}

	@Override
	public void updatePayroll(Payroll payroll) {
		payrollDAO.updatePayroll(payroll);
	}

	@Override
	public void deletePayroll(int payrollId) {
		payrollDAO.deletePayroll(payrollId);
	}

	@Override
	public Payroll getPayrollById(int payrollId) {
		return payrollDAO.getPayrollById(payrollId);
	}
}

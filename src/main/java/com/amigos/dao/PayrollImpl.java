package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Payroll;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PayrollImpl implements PayrollDAO{

	@Autowired
	private EntityManager entityManager;
	@Override
	
	public List<Payroll> getAllPayrolls() {
		return entityManager.unwrap(Session.class).createQuery("from Payroll", Payroll.class).getResultList();
	}

	@Override
	public void addPayroll(Payroll payroll) {
		entityManager.unwrap(Session.class).saveOrUpdate(payroll);
	}

	@Override
	public void updatePayroll(Payroll Payrolls) {
		entityManager.unwrap(Session.class).merge(Payrolls);
	}

	@Override
	public void deletePayroll(int payrollId) {
		entityManager.unwrap(Session.class).remove(payrollId);
	}

	@Override
	public Payroll getPayrollById(int payrollId) {
		return entityManager.unwrap(Session.class).get(Payroll.class, payrollId);
	}

}

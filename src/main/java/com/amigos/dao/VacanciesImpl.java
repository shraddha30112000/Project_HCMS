package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Vacancies;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class VacanciesImpl implements VacanciesDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Vacancies> getAllVacancies() {
		return entityManager.unwrap(Session.class).createQuery("from Vacancies", Vacancies.class).getResultList();
	}

	@Override
	public void addVacancies(Vacancies vacancies) {
		entityManager.unwrap(Session.class).saveOrUpdate(vacancies);
	}

	@Override
	public void updateVacancies(Vacancies vacancies) {
		entityManager.unwrap(Session.class).merge(vacancies);
	}

	@Override
	public void deleteVacancies(int vacancyId) {
		entityManager.unwrap(Session.class).remove(vacancyId);
	}

	@Override
	public Vacancies getVacanciesById(int vacancyId) {
		return entityManager.unwrap(Session.class).get(Vacancies.class, vacancyId);
	}
	
	

}

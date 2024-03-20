package com.amigos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.VacanciesDAO;
import com.amigos.entities.Vacancies;

@Service
public class VacanciesServiceImpl implements VacanciesService{
	
	@Autowired
	private VacanciesDAO vacanciesDAO;

	@Override
	public List<Vacancies> getAllVacancies() {
		return vacanciesDAO.getAllVacancies();
	}

	@Override
	public void addVacancies(Vacancies Vacancies) {
		vacanciesDAO.addVacancies(Vacancies);
	}

	@Override
	public void updateVacancies(Vacancies Vacancies) {
		vacanciesDAO.updateVacancies(Vacancies);
	}

	@Override
	public void deleteVacancies(int vacancyId) {
		vacanciesDAO.deleteVacancies(vacancyId);;
	}

	@Override
	public Vacancies getVacanciesById(int vacancyId) {
		return vacanciesDAO.getVacanciesById(vacancyId);
	}
	

}

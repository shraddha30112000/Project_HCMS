package com.amigos.services;

import java.util.List;

import com.amigos.entities.Vacancies;

public interface VacanciesService {
List<Vacancies> getAllVacancies();
	
	void addVacancies(Vacancies Vacancies);
	
	void updateVacancies(Vacancies Vacancies);
	
	void deleteVacancies(int vacancyId);
	
	Vacancies getVacanciesById(int vacancyId);

}

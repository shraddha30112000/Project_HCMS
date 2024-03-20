package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Trainers;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class TrainersImpl implements TrainersDAO{

	@Autowired
	private EntityManager entityManager;
	@Override
	public List<Trainers> getAllTrainers() {
		return entityManager.unwrap(Session.class).createQuery("from Trainers", Trainers.class).getResultList();
	}

	@Override
	public void addTrainers(Trainers trainers) {
		entityManager.unwrap(Session.class).saveOrUpdate(trainers);
	}

	@Override
	public void updateTrainers(Trainers trainers) {
		entityManager.unwrap(Session.class).merge(trainers);
	}

	@Override
	public void deleteTrainers(int trainerId) {
		entityManager.unwrap(Session.class).remove(trainerId);
	}

	@Override
	public Trainers getTrainersById(int trainerId) {
		return entityManager.unwrap(Session.class).get(Trainers.class, trainerId);
	}

}
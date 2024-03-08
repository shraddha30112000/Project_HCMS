package com.amigos.entities;

import jakarta.persistence.Entity;

@Entity 
public class Department {
	private int departmentId;
	private String departmentName;
	private String description;
}

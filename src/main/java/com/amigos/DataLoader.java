package com.amigos;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.amigos.entities.Departments;
import com.amigos.entities.Employees;
import com.amigos.entities.Roles;
import com.amigos.services.DepartmentsService;
import com.amigos.services.EmployeesService;
import com.amigos.services.RolesService;

@Component
public class DataLoader implements CommandLineRunner{

	@Autowired
	private RolesService roleService;
	
	@Autowired
	private EmployeesService employeeseService;
	
	@Autowired
	private DepartmentsService departmentService;
	
	@Override
	public void run(String... args) throws Exception {
		Roles role1=new Roles();
		role1.setRoleName("Manager");
		role1.setDescription("Manager Role Desc");
		roleService.addRole(role1);
		
		Roles role2=new Roles();
		role2.setRoleName("Developer");
		role2.setDescription("Developer Role Desc");
		roleService.addRole(role2);
		
		Departments d1=new Departments();
		d1.setDepartmentName("IT");
		d1.setDescription("IT desc");
		departmentService.addDepartment(d1);
		
		Departments d2=new Departments();
		d1.setDepartmentName("HR");
		d1.setDescription("HR Desc");
		departmentService.addDepartment(d2);
		
		Employees manager = new Employees();
		manager.setFirstName("Shreya");
		manager.setLastName("Yerunkar");
		manager.setGender("Female");
		manager.setDateOfBirth(LocalDate.of(1998, 10, 13));
		manager.setEmail("shreyayerunkar@gmail.com");
		manager.setPhone("8850617394");
		manager.setAddress("Mumbai");
		manager.setNationalId("1234056789");
		manager.setMaritalStatus("Married");
		manager.setEmergencyContactName("Mahesh");
		manager.setEmergencyContactPhone("7701417668");
		manager.setPosition("Software Manager");
		manager.setSkillSet("AWS,Microservices");
		manager.setEmploymentStartDate(LocalDate.of(2019, 02, 01));
		manager.setEmploymentEndDate(null);
		manager.setSalary(new BigDecimal("90000.0"));
		manager.setEmploymentStatus("ACTIVE");
		manager.setBankAccountNumber("78451200369");
		manager.setManager(null);
		manager.setDepartment(d2);
		manager.setRole(role2);
		
		Employees emp1 = new Employees();
		emp1.setFirstName("Shraddha");
		emp1.setLastName("Yerunkar");
		emp1.setGender("Female");
		emp1.setDateOfBirth(LocalDate.of(2000, 11, 30));
		emp1.setEmail("shraddhayerunkar@gmail.com");
		emp1.setPhone("9850617394");
		emp1.setAddress("Pune");
		emp1.setNationalId("123456789");
		emp1.setMaritalStatus("Single");
		emp1.setEmergencyContactName("Shreya");
		emp1.setEmergencyContactPhone("7709317668");
		emp1.setPosition("Software Developer");
		emp1.setSkillSet("Java,SpringBoot");
		emp1.setEmploymentStartDate(LocalDate.of(2020, 01, 01));
		emp1.setEmploymentEndDate(null);
		emp1.setSalary(new BigDecimal("80000.0"));
		emp1.setEmploymentStatus("ACTIVE");
		emp1.setBankAccountNumber("784512369");
		emp1.setManager(manager);
		emp1.setDepartment(d1);
		emp1.setRole(role1);
		
		employeeseService.addEmployee(manager);
		employeeseService.addEmployee(emp1);
	}
	
}

package com.technoelevate.employee_registration.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.technoelevate.employee_registration.employee.Employee;

@Repository
public class EmployeeRepo {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void resisterUser(Employee employee) {

		manager.persist(employee);
		transaction.begin();
		transaction.commit();

	}

	public void deleteEmployee(Employee employee) {

		Employee find = manager.find(Employee.class, employee.getEmpid());
		manager.remove(find);
		transaction.begin();
		transaction.commit();

	}

	public void updateEmployee(Employee employee) {

		Employee find = manager.find(Employee.class, employee.getEmpid());
		find.setEmpid(employee.getEmpid());
		find.setName(employee.getName());
		find.setEmail(employee.getEmail());

		manager.persist(find);
		transaction.begin();
		transaction.commit();

	}

	public Employee display(int empid) {
		Employee employee = manager.find(Employee.class, empid);
		return employee;

	}

}

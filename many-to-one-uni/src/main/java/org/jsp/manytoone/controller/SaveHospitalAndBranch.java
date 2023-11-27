package org.jsp.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytoone.dto.Branch;
import org.jsp.manytoone.dto.Hospital;

public class SaveHospitalAndBranch {
public static void main(String[] args) {
	Hospital h=new Hospital();
	h.setFounder("ABC");
	h.setName("Apollo");
	h.setYear_of_estb(1975);
	
	Branch b1=new Branch();
	b1.setName("Apollo bangalore");
	b1.setEmail("ab@gmail.com");
	b1.setPhone(1234L);
	b1.setCity("Bangalore");
	b1.setHospital(h);
	
	Branch b2=new Branch();
	b2.setName("Apollo Mangalore");
	b2.setEmail("am@gmail.com");
	b2.setPhone(5678L);
	b2.setCity("Mangalore");
	b2.setHospital(h);
	
	Branch b3=new Branch();
	b3.setName("Apollo Mysore");
	b3.setEmail("amy@gmail.com");
	b3.setPhone(12345L);
	b3.setCity("Mysore");
	b3.setHospital(h);
	
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	manager.persist(b1);
	manager.persist(b2);
	manager.persist(b3);
	
	transaction.begin();
	transaction.commit();
	
	
}
}

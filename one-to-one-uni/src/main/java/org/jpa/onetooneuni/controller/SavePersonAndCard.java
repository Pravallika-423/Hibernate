package org.jpa.onetooneuni.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jpa.onetooneuni.dto.AadharCard;
import org.jpa.onetooneuni.dto.Person;

public class SavePersonAndCard {
	public static void main(String[] args) {
		Person p= new Person();
		p.setName("ABC");
		p.setPhone(112233);
		p.setEmail("abc@gmail.com");
		
		AadharCard card=new AadharCard();
		card.setNumber(123412341234L);
		card.setDob(LocalDate.parse("1947-08-15"));
		card.setPincode(560078);
		
		p.setAadhar(card);
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(p);
		transaction.begin();
		transaction.commit();
		}
}

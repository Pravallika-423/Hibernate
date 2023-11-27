package org.jsp.onetoonebi.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetoonebi.dto.PanCard;
import org.jsp.onetoonebi.dto.Person;

public class SavePersonAndCard {
	public static void main(String[] args) {
		Person p=new Person();
		p.setName("Sai");
		p.setPhone(123123);
		p.setEmail("sai@gmail.com");
		
		PanCard card=new PanCard();
		card.setNumber("ASDF9123E");
		card.setDob(LocalDate.parse("2001-04-11"));
		card.setPincode(500988);
		
		p.setCard(card);
		card.setPerson(p);
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(p);
		transaction.begin();
		transaction.commit();
	}
}

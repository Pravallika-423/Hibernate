package org.jsp.embeddable.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspembeddable.dto.User;
import org.jspembeddable.dto.UserId;

public class FindUserByPhone {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	System.out.println("enter phone number of the user");
	long phone = s.nextLong();
	String qry = "select u from User u where u.id.phone=?1";
	UserId id = new UserId();
	id.setPhone(phone);
	EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q = manager.createQuery(qry);
	q.setParameter(1, id.getPhone());
	List<User> us=q.getResultList();
	if(us!=null) {
		for(User u:us) {
			System.out.println("name:"+u.getName());
			System.out.println("age:"+u.getAge());
			System.out.println("phone:"+u.getId().getPhone());
			System.out.println("email:"+u.getId().getEmail());
		}
	}
	else {
		System.err.println("invalid phonenumber");
	}
}
}

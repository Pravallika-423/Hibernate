package org.jsp.embeddable.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspembeddable.dto.User;

public class FindUserByName {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter name of the user");
	String name=s.next();
	String qry="select u from User u where u.name=?1";
	
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q=manager.createQuery(qry);
	q.setParameter(1, name);
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
		System.err.println("invalid name");
	}
}
}

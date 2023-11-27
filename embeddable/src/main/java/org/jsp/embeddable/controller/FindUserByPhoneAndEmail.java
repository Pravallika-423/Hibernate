package org.jsp.embeddable.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jspembeddable.dto.User;
import org.jspembeddable.dto.UserId;

import com.mysql.cj.protocol.ExportControlled.X509TrustManagerWrapper;

public class FindUserByPhoneAndEmail {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		System.out.println("enter email and phone number:");
		
		UserId id=new UserId();
		id.setEmail(s.next());
		id.setPhone(s.nextLong());
		
		User u=manager.find(User.class, id);
		if(u!=null) {
			System.out.println("name:"+u.getName());
			System.out.println("age:"+u.getAge());
			System.out.println("Email:"+u.getId().getEmail());
			System.out.println("phone:"+u.getId().getPhone());
		}
		else {
			System.err.println("invalid email id or phone number..!!");
		}
	}
}

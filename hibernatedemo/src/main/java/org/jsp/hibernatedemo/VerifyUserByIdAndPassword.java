package org.jsp.hibernatedemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class VerifyUserByIdAndPassword {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter ur id and passsword");
		int id=sc.nextInt();
		String password=sc.next();
		String qry="select u from User u where u.id=?1 and u.password=?2";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, id);
		q.setParameter(2, password);
		List<User> users=q.getResultList();
		if(users.size()>0)
		{
			for(User u:users)
			{
				System.out.println("User id: "+u.getId());
				System.out.println("Name : "+u.getName());
				System.out.println("phone number :"+u.getPhone());
				System.out.println("email : "+u.getPhone());
				System.out.println("=============================");
			}
		}
		else
		{
			System.out.println("No user found with entered name");
		}
	}
}

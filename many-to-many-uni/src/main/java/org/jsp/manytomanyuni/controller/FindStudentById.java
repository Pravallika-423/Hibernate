package org.jsp.manytomanyuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Batch;
import org.jsp.manytomanyuni.dto.Student;

public class FindStudentById {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("enter student id");
		int id = s.nextInt();
		String qry = "select s1 from Student s1 where s1.id=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);

		try {
			Student s1 = (Student) q.getSingleResult();
			System.out.println("Student id:" + s1.getId());
			System.out.println("name:" +s1.getName());
			System.out.println("percantage:" + s1.getPercentage());
			System.out.println("phone number:" +s1.getPhone());

		} catch (NoResultException e) {
			System.err.println("Invalid subject...!!");
		}
	}
}
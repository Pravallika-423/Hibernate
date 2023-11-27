package org.jsp.manytomanybi.controller;

import java.util.List;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Student;

public class FindStudentPercAbove60 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String qry = "select s1 from Student s1 where s1.percentage>60";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);

		List<Student> st = q.getResultList();
		if (st.size() > 0) {
			for (Student s1 : st) {
				System.out.println("Student id:" + s1.getId());
				System.out.println("name:" + s1.getName());
				System.out.println("percantage:" + s1.getPercentage());
				System.out.println("phone number:" + s1.getPhone());
			}
		} else {
			System.err.println("no student have above 60%...!!");
		}
	}
}

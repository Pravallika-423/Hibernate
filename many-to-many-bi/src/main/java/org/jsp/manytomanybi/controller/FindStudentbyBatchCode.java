package org.jsp.manytomanybi.controller;

import java.util.List;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Student;

public class FindStudentbyBatchCode {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter batch id");
		String batchcode=s.next();
		
		String qry = "select b.students from Batch b where b.batch_code=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, batchcode);

		List<Student> st = q.getResultList();
		if (st.size() > 0) {
			for (Student s1 : st) {
				System.out.println("Student id:" + s1.getId());
				System.out.println("name:" + s1.getName());
				System.out.println("percantage:" + s1.getPercentage());
				System.out.println("phone number:" + s1.getPhone());
			}
		} else {
			System.err.println("no student found in given batch code...!!");
		}
	}
}

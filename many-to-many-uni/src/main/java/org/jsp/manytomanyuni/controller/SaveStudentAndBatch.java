package org.jsp.manytomanyuni.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytomanyuni.dto.Batch;
import org.jsp.manytomanyuni.dto.Student;

public class SaveStudentAndBatch {
	public static void main(String[] args) {
		Batch b1 = new Batch();
		b1.setSubject("Hibernate");
		b1.setBatch_code("hib-m1");
		b1.setTrainer("Sathish");

		Batch b2 = new Batch();
		b2.setSubject("Java");
		b2.setBatch_code("java-m1");
		b2.setTrainer("Keshav");

		Batch b3 = new Batch();
		b3.setSubject("Programming");
		b3.setBatch_code("prg-m1");
		b3.setTrainer("Moshin");

		Student s1 = new Student();
		s1.setName("virat");
		s1.setPercentage(79);
		s1.setPhone(123456L);

		Student s2 = new Student();
		s2.setName("MS.dhoni");
		s2.setPercentage(99);
		s2.setPhone(1234567L);

		Student s3 = new Student();
		s3.setName("Bumrah");
		s3.setPercentage(89);
		s3.setPhone(12345678L);

		b1.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));
		b2.setStudents(new ArrayList<Student>(Arrays.asList(s1, s3)));
		b3.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		transaction.begin();
		transaction.commit();
}
}

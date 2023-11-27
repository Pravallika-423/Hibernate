package org.jsp.manytoone.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytoone.dto.Hospital;

public class FindHospitalByFounder {
	public static void main(String[] args) {
		
	
	Scanner s = new Scanner(System.in);
	System.out.println("Enter Founder of the hospital:");
	String founder=s.next();
	String qry = "select h from Hospital h where h.founder=?1";
	EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q = manager.createQuery(qry);
	q.setParameter(1, founder);

	try {
		Hospital h = (Hospital) q.getSingleResult();
		System.out.println("Hospital id:" + h.getId());
		System.out.println("name:" + h.getName());
		System.out.println("Founder:" + h.getFounder());
		System.out.println("Year of establishment :" + h.getYear_of_estb());
	} catch (NoResultException e) {
		System.err.println("Invalid Hospital establishment year");
	}
}}

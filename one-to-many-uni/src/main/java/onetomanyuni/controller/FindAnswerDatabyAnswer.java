package onetomanyuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetomanyuni.dto.AnswerData;

public class FindAnswerDatabyAnswer {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	System.out.println("enter Answer");
	String ans = s.nextLine();
	String qry = "select ad from AnswerData ad where ad.answer=?1";

	EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q = manager.createQuery(qry);
	q.setParameter(1,ans);

	try {
		AnswerData ad = (AnswerData) q.getSingleResult();
		System.out.println("answer id:" + ad.getId());
		System.out.println("answer : " + ad.getAnswer());
		System.out.println("answered by :" + ad.getAnsweredBy());

	} catch (NoResultException e) {
		
		System.out.println("invalid answer..!!");
	}
}
}

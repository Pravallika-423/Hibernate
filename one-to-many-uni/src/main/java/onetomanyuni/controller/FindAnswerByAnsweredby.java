package onetomanyuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetomanyuni.dto.AnswerData;

public class FindAnswerByAnsweredby {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter AnsweredBy");
		String ansby = s.next();
		String qry = "select ad from AnswerData ad where ad.answeredBy=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, ansby);

		try {
			AnswerData qd = (AnswerData) q.getSingleResult();
			System.out.println("answer id:" + qd.getId());
			System.out.println("answer : " + qd.getAnswer());
			System.out.println("answered by :" + qd.getAnsweredBy());

		} catch (NoResultException e) {
			System.out.println("invalid answerby name..!!");
		}
	}
}

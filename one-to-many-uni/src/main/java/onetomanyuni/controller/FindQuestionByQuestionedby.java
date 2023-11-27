package onetomanyuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetomanyuni.dto.QuestionData;

public class FindQuestionByQuestionedby {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter questionby ");
		String qby=s.next();
		String qry = "select qd from QuestionData qd where qd.questionedBy=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1,qby);

		try {
			QuestionData qd = (QuestionData) q.getSingleResult();
			System.out.println("question id:" + qd.getId());
			System.out.println("question : " + qd.getQuestion());
			System.out.println("questioned by :" + qd.getQuestionedBy());

		} catch (NoResultException e) {
			System.out.println("invalid name..!!");
		}
	}
}

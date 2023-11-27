package onetomanyuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetomanyuni.dto.AnswerData;

public class FindAnswerdataByQnid {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter question id");
		int id = s.nextInt();
		String qry = "select ad from AnswerData ad where ad.QuestionData.id=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);

		try {
			AnswerData qd = (AnswerData) q.getSingleResult();
			System.out.println("answer id:" + qd.getId());
			System.out.println("answer : " + qd.getAnswer());
			System.out.println("answered by :" + qd.getAnsweredBy());

		} catch (NoResultException e) {
			System.out.println("invalid question id..!!");
		}
	}
}

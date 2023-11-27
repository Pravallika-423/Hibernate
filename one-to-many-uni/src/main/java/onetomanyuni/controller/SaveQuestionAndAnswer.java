package onetomanyuni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanyuni.dto.AnswerData;
import onetomanyuni.dto.QuestionData;

public class SaveQuestionAndAnswer {
public static void main(String[] args) {
	QuestionData q=new QuestionData();
	q.setQuestion("what is hibernate ?");
	q.setQuestionedBy("sathish");
	
	AnswerData a1=new AnswerData();
	a1.setAnswer("Hibernate is a predefined code");
	a1.setAnsweredBy("Aman");
	
	AnswerData a2=new AnswerData();
	a2.setAnswer("Hibernate is aopen source framework");
	a2.setAnsweredBy("Lakshmi");

	AnswerData a3=new AnswerData();
	a3.setAnswer("Hibernate is an ORM tool");
	a3.setAnsweredBy("chaitanya");
	
	List<AnswerData> answers=new ArrayList<AnswerData>();
	answers.add(a1);
	answers.add(a2);
	answers.add(a3);
	
	q.setAnswers(answers);
	
	EntityManager manager =Persistence.createEntityManagerFactory("jpa").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	manager.persist(q);
	transaction.begin();
	transaction.commit();
}
}

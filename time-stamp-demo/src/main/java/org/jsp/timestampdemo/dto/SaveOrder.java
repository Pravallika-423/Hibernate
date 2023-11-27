package org.jsp.timestampdemo.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveOrder {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		FoodOrder order = new FoodOrder();
		order.setAddress("BTM Layout");
		order.setFood_item("Biryani");
		order.setCost(150);

		manager.persist(order);
		transaction.begin();
		transaction.commit();
	}
}

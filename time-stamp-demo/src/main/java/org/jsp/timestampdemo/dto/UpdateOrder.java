package org.jsp.timestampdemo.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateOrder {
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	FoodOrder order=manager.find(FoodOrder.class, 1);
	order.setAddress("BTM Jspiders");
	order.setFood_item("Chilli chicken");
	order.setCost(200);
	
	manager.merge(order);
	transaction.begin();
	transaction.commit();
}
}

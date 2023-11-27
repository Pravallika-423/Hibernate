package orgjsp.onetomanybi.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


import org.jsp.onetomanybi.dto.Department;

public class FetchDept {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Department d=manager.find(Department.class, 1);
		System.out.println(d.getEmps());
	}
}

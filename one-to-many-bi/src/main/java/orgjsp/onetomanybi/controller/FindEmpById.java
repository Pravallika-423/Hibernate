package orgjsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;
import org.jsp.onetomanybi.dto.Employee;

public class FindEmpById {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter id of the emp");
		int id = s.nextInt();
		String qry = "select e from Employee e where e.id=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);

		Employee e = (Employee) q.getSingleResult();
		try {
			System.out.println("Employee id:" + e.getId());
			System.out.println("designation:" + e.getDesg());
			System.out.println("name:" + e.getName());
			System.out.println("salary:" + e.getSalary());
		} catch (NoResultException es) {
			System.out.println("invalid id");
		}
	}
}

package orgjsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Employee;

public class FindEmpbyName {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter name of the emp");
		String name = s.next();
		String qry = "select e from Employee e where e.name=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		List<Employee> emp = q.getResultList();
		if (emp.size() > 0) {
			for (Employee e : emp) {

				System.out.println("Employee id:" + e.getId());
				System.out.println("designation:" + e.getDesg());
				System.out.println("name:" + e.getName());
				System.out.println("salary:" + e.getSalary());
			}

		} else {
			System.out.println("invalid salary");
		}
	}
}

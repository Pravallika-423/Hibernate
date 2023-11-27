package orgjsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;
import org.jsp.onetomanybi.dto.Employee;

public class FindEmpbySalary {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter salary of the emp");
		double sal = s.nextDouble();
		String qry = "select e from Employee e where e.salary=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, sal);
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

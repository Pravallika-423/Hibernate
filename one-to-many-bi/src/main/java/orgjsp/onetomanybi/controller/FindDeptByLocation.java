package orgjsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;

public class FindDeptByLocation {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter location of the department");
		String loc = s.next();
		String qry = "select d from Department d where d.location=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, loc);
		List<Department> dt = q.getResultList();
		if (dt.size() > 0) {
			for (Department d : dt) {
				System.out.println("Department id:" + d.getId());
				System.out.println("name:" + d.getName());
				System.out.println("location:" + d.getLocation());
			}
		} else {
			System.out.println("invalid location...!!");
		}
	}
}

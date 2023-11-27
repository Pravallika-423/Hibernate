package orgjsp.onetomanybi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;

public class FindDeptByid {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter id of the department");
		int id=s.nextInt();
		String qry="select d from Department d where d.id=?1";
		
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q=manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			Department d=(Department)q.getSingleResult();
			System.out.println("Department id:"+d.getId());
			System.out.println("name:"+d.getName());
			System.out.println("location:"+d.getLocation());
		}
		catch(NoResultException e) {
			System.out.println("invalid id...!!");
		}
	}
}

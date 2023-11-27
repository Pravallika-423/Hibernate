package orgjsp.onetomanybi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomanybi.dto.Department;
import org.jsp.onetomanybi.dto.Employee;

public class SaveDeptAndEmps {
	public static void main(String[] args) {
		Department d = new Department();
		d.setLocation("Bangalore");
		d.setName("Development");

		Employee e1 = new Employee();
		e1.setName("Bahubali");
		e1.setDesg("King");
		e1.setSalary(12345);
		e1.setDept(d);

		Employee e2 = new Employee();
		e2.setName("Pushpa");
		e2.setDesg("smuggler");
		e2.setSalary(123456);
		e2.setDept(d);

		Employee e3 = new Employee();
		e3.setName("Rocky");
		e3.setDesg("CEO");
		e3.setSalary(1234567);
		e3.setDept(d);

		// d.setEmps(new ArrayList()<Employee>(Arrays.asList(e1,e2,e3)));

		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		d.setEmps(emps);

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(d);
		transaction.begin();
		transaction.commit();
	}
}

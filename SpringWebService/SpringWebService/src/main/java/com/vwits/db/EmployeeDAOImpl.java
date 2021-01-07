package com.vwits.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.vwits.javabean.Employee;

public class EmployeeDAOImpl {
	Configuration cfg;
	SessionFactory sessionFactory;
	Session session;
	Transaction tx;
	
	public List<Employee> getAll(){
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		List<Employee> list = session.createQuery("From Employee").list();
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return list;
	}

	public int saveEmp(Employee e) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		int rows = (int) session.save(e);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return rows;
		
	}
	
	public void updateEmp(Employee e) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.update(e);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}

	public void removeEmp(Employee e) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.delete(e);
		tx.commit();
		session.close();
		sessionFactory.close();
	}

	public List getEmp(String name) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Employee.class);
		c.add(Restrictions.eq("name", name));					
		List<Employee> list = c.list();
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return list;
	}

	
}

package com.vwits.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao {
Configuration cfg;
SessionFactory sessionFactory;
Session session;
Transaction t;
public void insert(Employee e) {
	cfg=new Configuration();
	sessionFactory= cfg.configure().buildSessionFactory();
	session= sessionFactory.openSession();
	t=session.beginTransaction();
	session.save(e);
	t.commit();
	session.close();
	sessionFactory.close();
	}
public void delete(Employee e) {
	cfg=new Configuration();
	sessionFactory= cfg.configure().buildSessionFactory();
	session= sessionFactory.openSession();
	t=session.beginTransaction();
	session.delete(e);
	t.commit();
	session.close();
	sessionFactory.close();
	}
public void update(Employee e) {
	cfg=new Configuration();
	sessionFactory= cfg.configure().buildSessionFactory();
	session= sessionFactory.openSession();
	t=session.beginTransaction();
	session.update(e);
	t.commit();
	session.close();
	sessionFactory.close();
	}
public List getAll() {
	cfg=new Configuration();
	sessionFactory= cfg.configure().buildSessionFactory();
	session= sessionFactory.openSession();
	t=session.beginTransaction();
	List l=session.createQuery("FROM Employee").list();
    System.out.println(l);
	t.commit();
	session.close();
	sessionFactory.close();
	return l;
	}
/*public void insertAddress(Address a) {
	cfg=new Configuration();
	sessionFactory= cfg.configure().buildSessionFactory();
	session= sessionFactory.openSession();
	t=session.beginTransaction();
	session.save(a);
	t.commit();
	session.close();
	sessionFactory.close();
	}
public void deleteAddress(Address a) {
	cfg=new Configuration();
	sessionFactory= cfg.configure().buildSessionFactory();
	session= sessionFactory.openSession();
	t=session.beginTransaction();
	session.delete(a);
	t.commit();
	session.close();
	sessionFactory.close();
	}
public void updateAddress(Address a) {
	cfg=new Configuration();
	sessionFactory= cfg.configure().buildSessionFactory();
	session= sessionFactory.openSession();
	t=session.beginTransaction();
	session.update(a);
	t.commit();
	session.close();
	sessionFactory.close();
	}
public List getAllAddress() {
	cfg=new Configuration();
	sessionFactory= cfg.configure().buildSessionFactory();
	session= sessionFactory.openSession();
	t=session.beginTransaction();
	List l=session.createQuery("FROM Address").list();
    System.out.println(l);
	t.commit();
	session.close();
	sessionFactory.close();
	return l;
	}*/
}

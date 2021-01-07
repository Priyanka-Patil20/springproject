package com.vwits.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class DaoImplementation {
	Configuration cfg;
	SessionFactory sessionFactory;
	Session session;
	Transaction t;
	public void insert(Student e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.save(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void delete(Student e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.delete(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void update(Student e) {
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
		List l=session.createQuery("FROM Student").list();
	    System.out.println(l);
		t.commit();
		session.close();
		sessionFactory.close();
		return l;
		}

	public List getLogin(String name,String pass) {
		List<Student>list;
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		String hql = "FROM Student E WHERE E.name = '"+name+"' and E.password = '"+pass+"'"; 
		list=(List<Student>)session.createQuery(hql).list();
		
		t.commit();
		session.close();
		sessionFactory.close();
		return list;
		}
	//Facult Dao
	public void insertFaculty(Faculty e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.save(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void deleteFaculty(Faculty e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.delete(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void updateFaculty(Faculty e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.update(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public List getAllFaculty() {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		List l=session.createQuery("FROM Faculty").list();
	    System.out.println(l);
		t.commit();
		session.close();
		sessionFactory.close();
		return l;
		}

	public List getLoginFaculty(String name,String pass) {
		List<Faculty>list;
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		String hql = "FROM Faculty E WHERE E.name = '"+name+"' and E.password = '"+pass+"'"; 
		list=(List<Faculty>)session.createQuery(hql).list();
		
		t.commit();
		session.close();
		sessionFactory.close();
		return list;
		}
	//Test
	public void insertTest(Test e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.save(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public List getAllTest() {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		List l=session.createQuery("FROM Test").list();
	    System.out.println(l);
		t.commit();
		session.close();
		sessionFactory.close();
		return l;
		}
	//result
	public void insertResult(Result e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.save(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public List getAllResult() {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		List l=session.createQuery("FROM Result").list();
	    System.out.println(l);
		t.commit();
		session.close();
		sessionFactory.close();
		return l;
		}
}

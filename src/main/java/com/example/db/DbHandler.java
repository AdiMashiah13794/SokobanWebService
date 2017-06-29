package com.example.db;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DbHandler  {

	protected SessionFactory factory;

	public DbHandler() {
		Configuration configuration= new Configuration();
		configuration.configure();
		factory=configuration.buildSessionFactory();
	}

	public void addSolution(SokobanSolution solution){
		Session session =null;
		Transaction tx=null;
		try{
			session=factory.openSession();
			tx=session.beginTransaction();
			session.save(solution);
			tx.commit();
		}
		catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		finally{
			if(session!=null)
				session.close();
		}
	}


	public String getSolution(String name){
		Session session=null;
		try{
			session=factory.openSession();
			SokobanSolution sol=session.get(SokobanSolution.class, name);
			if(sol!=null){
				return sol.getSolution();
			}
		}
		catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		finally{
			if(session!=null)
				session.close();
		}
		return null;
	}






}

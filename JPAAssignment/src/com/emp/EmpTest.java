
package com.emp;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class EmpTest {
  private static final String PERSISTENCE_UNIT_NAME = "JPAAssignment";
  private static EntityManagerFactory factory;

  public static void main(String[] args) {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
    // read the existing entries and write to console
    try {
    	Emp e =new Emp();
    	em.getTransaction().begin();
    	String update="UPDATE Emp "
    			+ "SET id = 1, "
    			+ "name = :name"
    			+ " WHERE id = 1";
    	
    	Query query = em.createQuery(update);
    	query.setParameter("name",e.getName());
    	query.executeUpdate(); 
    	em.getTransaction().commit();
    /*	em.getTransaction().begin();
        Emp e =new Emp();
        Emp mgr = new Manager();
        e.setId(134);
        e.setName("Arjun");
        mgr.setId(123);
        mgr.setName("IP");
        ((Manager) mgr).setSalary(100.50);
        em.persist(e);
        em.persist(mgr);
        em.getTransaction().commit();
        em.close();*/
  }catch(Exception e){
	 e.printStackTrace();
  }
	  
  }
  }
     

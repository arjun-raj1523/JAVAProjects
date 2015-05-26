package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entities.LoginEntity;

public class LoginDAO {
	private static final String PERSISTENCE_UNIT_NAME = "ALM";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em = factory.createEntityManager();	
	int temp=0;
	public boolean logincheck(Object o){
		
		Query query = em.createQuery("select username from LoginEntity");
		
		List index= query.getResultList();
		System.out.println(index);
		for(temp=0;temp<index.size();temp++) 
			if(((LoginEntity) o).getUsername().equals(index.get(temp)))
			{	
				System.out.println("Here");
				return true;
			}
			
				return false;
		
	}

}

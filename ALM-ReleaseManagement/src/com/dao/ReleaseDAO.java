package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entities.IterationEntity;
import com.entities.ReleaseEntity;

public class ReleaseDAO implements DAOable {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ALM");
	EntityManager em=emf.createEntityManager();

	public void insert(Object o) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		//to Insert		
		em.persist(((ReleaseEntity)o));
		em.getTransaction().commit();

	}

	@Override
	public void edit(Object o) {
		// TODO Auto-generated method stub
		int i=0;
		String temp=null;
		System.out.println(((ReleaseEntity)o).getIndex());
		ArrayList<String> index = new ArrayList<String>();
		Query query1 = em.createQuery("select ReleaseTitle from ReleaseEntity WHERE index= :index ");//Use Class Name not table name
		query1.setParameter("index",((ReleaseEntity) o).getIndex());
		index= (ArrayList<String>) query1.getResultList();	
		System.out.println(index);
		em.getTransaction().begin();
		String updateStatement="UPDATE ReleaseEntity "
				+ "SET "
				+ "ReleaseDescription = :ReleaseDescription, "
				+ "ReleaseStartDate = :ReleaseStartDate, "
				+ "ReleasePlannedDate = :ReleasePlannedDate, "
				+ "ReleaseReleaseDate = :ReleaseReleaseDate, "
				+ "ReleaseType = :ReleaseType, "
				+ "ReleaseTo = :ReleaseTo, "
				+ "ReleaseItems = :ReleaseItems, "
				+ "ReleaseStatus = :ReleaseStatus, "
				+ "ReleaseManager = :ReleaseManager, "
				+ "ReleaseVersion = :ReleaseVersion, "
				+ "ReleaseTitle = :ReleaseTitle "
				+ "WHERE ReleaseTitle = :ReleaseTitleindex ";

		for(i=0;i<index.size();i++)
			temp=index.get(i);
		System.out.println(temp);
		System.out.println(((ReleaseEntity) o).getReleaseTitle());
		Query query = em.createQuery(updateStatement);
		query.setParameter("ReleaseDescription",((ReleaseEntity) o).getReleaseDescription());
		query.setParameter("ReleaseStartDate",((ReleaseEntity) o).getReleaseStartDate());
		query.setParameter("ReleasePlannedDate",((ReleaseEntity) o).getReleasePlannedDate());
		query.setParameter("ReleaseReleaseDate",((ReleaseEntity) o).getReleaseReleaseDate());
		query.setParameter("ReleaseType",((ReleaseEntity) o).getReleaseType());
		query.setParameter("ReleaseTo",((ReleaseEntity) o).getReleaseTo());
		query.setParameter("ReleaseItems",((ReleaseEntity) o).getReleaseItems());		
		query.setParameter("ReleaseStatus",((ReleaseEntity) o).getReleaseStatus());
		query.setParameter("ReleaseManager",((ReleaseEntity) o).getReleaseManager());
		query.setParameter("ReleaseVersion",((ReleaseEntity) o).getReleaseVersion());		
		query.setParameter("ReleaseTitle",((ReleaseEntity) o).getReleaseTitle());
		query.setParameter("ReleaseTitleindex",temp);
		try{
			query.executeUpdate();
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}



	}

	@Override
	public String displayAll() {

		// TODO Auto-generated method stub


		// TODO Auto-generated method stub
		ArrayList<String> index = new ArrayList<String>();
		ArrayList<String> releaseTitle = new ArrayList<String>();
		ArrayList<String> releaseDescription = new ArrayList<String>();
		ArrayList<String> releaseStartDate = new ArrayList<String>();
		ArrayList<String> releasePlannedDate = new ArrayList<String>();
		ArrayList<String> releaseReleaseDate = new ArrayList<String>();
		ArrayList<String> releaseType = new ArrayList<String>();
		ArrayList<String> releaseTo = new ArrayList<String>();
		ArrayList<String> releaseItems = new ArrayList<String>();
		ArrayList<String> releaseStatus = new ArrayList<String>();
		ArrayList<String> releaseManager = new ArrayList<String>();
		ArrayList<String> releaseVersion = new ArrayList<String>();

		// title,description,startDate,plannedDate,releaseDate,type,to,items,status,manager,version;
		Query query = em.createQuery("select index from ReleaseEntity");//Use Class Name not table name
		index= (ArrayList<String>) query.getResultList();

		query = em.createQuery("select ReleaseTitle from ReleaseEntity");//Use Class Name not table name
		releaseTitle= (ArrayList<String>) query.getResultList();

		query = em.createQuery("select ReleaseDescription from ReleaseEntity");//Use Class Name not table name
		releaseDescription = (ArrayList<String>) query.getResultList();

		query = em.createQuery("select ReleaseStartDate from ReleaseEntity");//Use Class Name not table name
		releaseStartDate = (ArrayList<String>) query.getResultList();

		query = em.createQuery("select ReleasePlannedDate from ReleaseEntity");//Use Class Name not table name
		releasePlannedDate = (ArrayList<String>) query.getResultList();

		query = em.createQuery("select ReleaseReleaseDate from ReleaseEntity");//Use Class Name not table name
		releaseReleaseDate = (ArrayList<String>) query.getResultList();

		query = em.createQuery("select ReleaseType from ReleaseEntity");//Use Class Name not table name
		releaseType = (ArrayList<String>) query.getResultList();

		query = em.createQuery("select ReleaseTo from ReleaseEntity");//Use Class Name not table name
		releaseTo = (ArrayList<String>) query.getResultList();	

		query = em.createQuery("select ReleaseItems from ReleaseEntity");//Use Class Name not table name
		releaseItems= (ArrayList<String>) query.getResultList();

		query = em.createQuery("select ReleaseStatus from ReleaseEntity");//Use Class Name not table name
		releaseStatus= (ArrayList<String>) query.getResultList();

		query = em.createQuery("select ReleaseManager from ReleaseEntity");//Use Class Name not table name
		releaseManager= (ArrayList<String>) query.getResultList();

		query = em.createQuery("select ReleaseVersion from ReleaseEntity");//Use Class Name not table name
		releaseVersion= (ArrayList<String>) query.getResultList();



		String s ="[";
		for (int j = 0;j< releaseType.size(); j++)
		{	
			s=s+"{";
			s=s+"\"index\":\""+index.get(j)+"\",";
			s=s+"\"Title\":\""+releaseTitle.get(j)+"\",";
			s=s+"\"Discription\":\""+releaseDescription.get(j)+"\",";
			s=s+"\"StartDate\":\""+releaseStartDate.get(j)+"\",";
			s=s+"\"PlannedDate\":\""+releasePlannedDate.get(j)+"\",";
			s=s+"\"ReleaseDate\":\""+releaseReleaseDate.get(j)+"\",";
			s=s+"\"Type\":\""+releaseType.get(j)+"\",";
			s=s+"\"To\":\""+releaseTo.get(j)+"\",";			
			s=s+"\"Items\":\""+releaseItems.get(j)+"\",";
			s=s+"\"Status\":\""+releaseStatus.get(j)+"\",";
			s=s+"\"Manager\":\""+releaseManager.get(j)+"\",";
			s=s+"\"Version\":\""+releaseVersion.get(j)+"\"";

			s=s+"}";
			if(j <(releaseType.size()-1))
			{
				s=s+",";
			}
		}
		s=s+"]";
		return s;

	}



}

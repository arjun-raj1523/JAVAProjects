package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dao.IterationDAO;
import com.entities.IterationEntity;

public class IterationTest {

	IterationEntity ie= new IterationEntity();
	IterationDAO id= new IterationDAO();
	@Before
	public void setUp() throws Exception {
		System.out.println("Initalized");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}


	@Test
	public void Iterationtest() {
		ie.setIterationTitle("Title4");
		ie.setIterationDescription("Description4");		
		ie.setIterationStartDate("09/01/2014");
		ie.setIterationEndDate("09/01/2014");
		ie.setIterationItems("Items4");
		ie.setIterationStatus("Planned");
		ie.setIterationType("Build");
		id.edit(ie);
		System.out.println("Edited");
		ie.setIterationTitle("Title6");
		ie.setIterationDescription("Description6");		
		ie.setIterationStartDate("09/01/2014");
		ie.setIterationEndDate("09/01/2014");
		ie.setIterationItems("Items6");
		ie.setIterationStatus("Planned");
		ie.setIterationType("Build");
		id.insert(ie);
		System.out.println("Inserted");
		System.out.println(id.displayAll());


	}

}

package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dao.ReleaseDAO;
import com.entities.ReleaseEntity;

public class ReleaseTest {
	ReleaseEntity re= new ReleaseEntity();
	ReleaseDAO rd= new ReleaseDAO();
	@Before
	public void setUp() throws Exception {
		System.out.println("Initalized");
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void Releasetest() {
		re.setReleaseTitle("Title2");
		re.setReleaseDescription("Description for 2");
		re.setReleaseStartDate("09/01/2014");
		re.setReleasePlannedDate("09/03/2014");
		re.setReleaseReleaseDate("09/04/2014");
		re.setReleaseItems("Items2");
		re.setReleaseType("Build");
		re.setReleaseTo("Stage");
		re.setReleaseStatus("Planned");
		re.setReleaseManager("Dev PM");
		re.setReleaseVersion("Version2");
		rd.edit(re);
		System.out.println("Edit");

		re.setReleaseTitle("Title5");
		re.setReleaseDescription("Description for Title5");
		re.setReleaseStartDate("09/01/2014");
		re.setReleasePlannedDate("09/03/2014");
		re.setReleaseReleaseDate("09/04/2014");
		re.setReleaseItems("Items5");
		re.setReleaseType("Build");
		re.setReleaseTo("Stage");
		re.setReleaseStatus("Planned");
		re.setReleaseManager("Dev PM");
		re.setReleaseVersion("Version5");
		rd.insert(re);

		System.out.println("Insert");
		System.out.println(rd.displayAll());
		
	}

}

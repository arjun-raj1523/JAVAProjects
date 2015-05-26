package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import Connt.Conn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConnectionTest {

	@Before
	public void setUp() throws Exception {
		//Conn con= new Conn();
		System.out.println("Initalized");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
		
	}

	@Test
	public void testConnect() throws SQLException, ClassNotFoundException {
		Conn.connect();
		System.out.println("Connected");
	}

}

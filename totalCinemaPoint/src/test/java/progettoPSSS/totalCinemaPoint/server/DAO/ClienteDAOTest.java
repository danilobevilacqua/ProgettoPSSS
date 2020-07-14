package progettoPSSS.totalCinemaPoint.server.DAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {
	
	ClienteDAO c;

	@Before
	public void setUp() throws Exception {
		c = new ClienteDAO();
		assertNotNull(c);
	}

	@After
	public void tearDown() throws Exception {
		c = null;
		assertNull(c);
	}

	@Test
	public void testGetSetUser() {
		c.setUsername("mariaros");
		assertEquals("mariaros", c.getUsername()); 		
	}
	@Test
	public void testGetSetNome() {
		c.setNome("Maria");
		assertEquals("Maria", c.getNome()); 		
	}
	@Test
	public void testGetSetCognome() {
		c.setCognome("Ros");
		assertEquals("Ros", c.getCognome()); 		
	}
	@Test
	public void testGetSetPassword() {
		c.setPassword("passwordMaria");
		assertEquals("passwordMaria", c.getPassword()); 		
	}
	@Test
	public void testGetSetNumeroConto() {
		c.setNumeroCartaCredito("1111111111111111");
		assertEquals("1111111111111111", c.getNumeroCartaCredito()); 		
	}
	@Test
	public void testGetSeteMail() {
		c.seteMail("maria@gmail.it");
		assertEquals("maria@gmail.it", c.geteMail()); 		
	}
	@Test
	public void testGetSetTelefono() {
		c.setTelefono("4444444444");
		assertEquals("4444444444", c.getTelefono()); 		
	}
	
	@Test
	public void testCostruttoreUsername() {
		c = new ClienteDAO("walterwhite"); 	
		assertEquals("walterwhite", c.getUsername());
	}
	
	@Test
	public void testCostruttoreUsernamePassword() {
		c = new ClienteDAO("walterwhite","walter"); 	
		assertEquals("walterwhite", c.getUsername());
		assertEquals("walter", c.getPassword());
	}


}

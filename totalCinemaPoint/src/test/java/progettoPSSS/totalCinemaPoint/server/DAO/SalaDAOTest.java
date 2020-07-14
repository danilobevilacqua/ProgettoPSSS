package progettoPSSS.totalCinemaPoint.server.DAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SalaDAOTest {

	private SalaDAO s;
	
	@Before
	public void setUp() throws Exception {
		s = new SalaDAO();
		assertNotNull(s);
	}

	@After
	public void tearDown() throws Exception {
		s=null;
		assertNull(s);
	}

	@Test
	public void testGetSetIdCinema() {
		s.setIdcinema_fk(5);
		assertEquals(5, s.getIdcinema_fk());
	}
	
	@Test
	public void testGetSetNome() {
		s.setNome("B");
		assertEquals("B", s.getNome());
	}
	
	@Test
	public void testCostruttoreSala() {
		s = new SalaDAO("B");
		assertEquals("B", s.getNome());
	}

}

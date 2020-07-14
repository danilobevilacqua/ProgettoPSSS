package progettoPSSS.totalCinemaPoint.server.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PostoTest {
	
	private Posto p;
	@Before
	public void setUp() throws Exception {
		p = new Posto();
		assertNotNull(p);
	}

	@After
	public void tearDown() throws Exception {
		p = null;
		assertNull(p);
	}

	@Test
	public void testGetSetNumero() {
		p.setNumero(5);
		assertEquals(5, p.getNumero());
	}
	
	@Test
	public void testGetSetNomeSala() {
		p.setNomeSala("A");
		assertEquals("A", p.getNomeSala());
	}

}

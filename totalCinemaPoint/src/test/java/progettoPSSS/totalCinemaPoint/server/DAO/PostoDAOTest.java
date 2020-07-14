package progettoPSSS.totalCinemaPoint.server.DAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PostoDAOTest {

	private PostoDAO p ;
	@Before
	public void setUp() throws Exception {
		p = new PostoDAO();
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
		p.setNomeSala_fk("A");
		assertEquals("A", p.getNomeSala_fk());
	}
	
	@Test
	public void testCostruttoreNumeroSala() {
		p = new PostoDAO(5,"A");
	}

}

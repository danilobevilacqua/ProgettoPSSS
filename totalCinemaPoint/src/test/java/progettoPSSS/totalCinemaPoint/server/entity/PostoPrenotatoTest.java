package progettoPSSS.totalCinemaPoint.server.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import progettoPSSS.totalCinemaPoint.server.DAO.PostoPrenotatoDAO;

public class PostoPrenotatoTest {
	
	private PostoPrenotato pp;

	@Before
	public void setUp() throws Exception {
		pp = new PostoPrenotato();
		assertNotNull(pp);
	}

	@After
	public void tearDown() throws Exception {
		pp = null;
		assertNull(pp);
	}

	@Test
	public void testGetSetCodice() {
		pp.setCodicePrenotazione(5);
		assertEquals(5, pp.getCodicePrenotazione());
	}
	
	@Test
	public void testGetSetNumeroPosto() {
		pp.setNumeroPosto(20);
		assertEquals(20, pp.getNumeroPosto());
	}
	
	@Test
	public void testGetSetNomeSala() {
		pp.setNomeSala("C");
		assertEquals("C", pp.getNomeSala());
	}
	
	@Test
	public void testGetSetTipo() {
		pp.setTipo("prenotato");
		assertEquals("prenotato", pp.getTipo());
	}
	
	@Test
	public void testCostruttoreDAO() {
		PostoPrenotatoDAO ppd = new PostoPrenotatoDAO();
		pp = new PostoPrenotato(ppd);
		assertEquals(0, pp.getNumeroPosto());
	}
	
	@Test
	public void testHash() {
		int r = pp.hashCode();
		assertEquals(961, r);
	}

	@Test
	public void testEquals() {
		PostoPrenotato pp1 = new PostoPrenotato();
		assertEquals(true, pp.equals(pp1));
		assertEquals(true, pp.equals(pp));
		assertEquals(false, pp.equals(null));
		assertEquals(false, pp.equals("ciao"));
		pp1.setNomeSala(null);
		assertEquals(false, pp.equals(pp1));
		pp.setNomeSala(null);
		pp1.setNomeSala("");
		assertEquals(false, pp.equals(pp1));
		pp.setNomeSala("");
		pp.setNumeroPosto(5);
		pp1.setNumeroPosto(10);
		assertEquals(false, pp.equals(pp1));
	}

}

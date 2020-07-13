package progettoPSSS.totalCinemaPoint.client.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PostoPrenotatoTest {
	private PostoPrenotato pp;

	@Before
	public void setUp() throws Exception {
		pp = new PostoPrenotato();
		assertNotNull(pp);
	}

	@After
	public void tearDown() throws Exception {
		pp=null;
		assertNull(pp);
	}

	@Test
	public void testGetSetCodicePrenotazione() {
		pp.setCodicePrenotazione(1);
		assertEquals(1, pp.getCodicePrenotazione());
	}
	@Test
	public void testGetSetNumeroPosto() {
		pp.setNumeroPosto(3);
		assertEquals(3, pp.getNumeroPosto());
	}
	@Test
	public void testGetSetNomeSala() {
		pp.setNomeSala("B");
		assertEquals("B", pp.getNomeSala());
	}
	@Test
	public void testGetSetTipo() {
		pp.setTipo("prenotato");
		assertEquals("prenotato", pp.getTipo());
	}
	@Test
	public void testCostruttoreCompleto() {
		pp = new PostoPrenotato(3, 5, "A", "covid");
		assertEquals(3, pp.getCodicePrenotazione());
		assertEquals(5, pp.getNumeroPosto());
		assertEquals("A", pp.getNomeSala());
		assertEquals("covid", pp.getTipo());
	}

}

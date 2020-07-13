package progettoPSSS.totalCinemaPoint.client.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrenotazioneTest {
	private Prenotazione p;

	@Before
	public void setUp() throws Exception {
		p = new Prenotazione();
		assertNotNull(p);
	}

	@After
	public void tearDown() throws Exception {
		p = null;
		assertNull(p);
	}

	@Test
	public void testGetSetCodice() {
		p.setCodice(1);
		assertEquals(1, p.getCodice());
	}
	
	@Test
	public void testGetSetUserr() {
		p.setUsernameCliente("testUser");
		assertEquals("testUser", p.getUsernameCliente());
	}
	
	@Test
	public void testGetSetidSpettacolo() {
		p.setIdSpettacolo(3);
		assertEquals(3, p.getIdSpettacolo());
	}
	
	@Test
	public void testGetSetListaPostiPrenotati() {
		PostoPrenotato pp = new PostoPrenotato();
		PostoPrenotato pp1 = new PostoPrenotato();		
		ArrayList<PostoPrenotato> lpp = new ArrayList<PostoPrenotato>();
		lpp.add(pp);
		lpp.add(pp1);
		p.setListaPostiPrenotati(lpp);
		assertEquals(lpp, p.getListaPostiPrenotati());
	}
	
	@Test
	public void testCostruttoreCompleto() {
		PostoPrenotato pp = new PostoPrenotato();
		PostoPrenotato pp1 = new PostoPrenotato();		
		ArrayList<PostoPrenotato> lpp = new ArrayList<PostoPrenotato>();
		lpp.add(pp);
		lpp.add(pp1);
		p.setCodice(1);
		p = new Prenotazione(2,"UserTest",9,lpp);
		assertEquals(2, p.getCodice());
		assertEquals("UserTest", p.getUsernameCliente());
		assertEquals(9, p.getIdSpettacolo());
		assertEquals(lpp, p.getListaPostiPrenotati());
	}

}

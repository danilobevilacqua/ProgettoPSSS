package progettoPSSS.totalCinemaPoint.server.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import progettoPSSS.totalCinemaPoint.server.DAO.PrenotazioneDAO;


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
		p.setCodice(10);
		assertEquals(10, p.getCodice());		
	}

	@Test
	public void testGetSetUser() {
		p.setUsernameCliente("walterwhite");
		assertEquals("walterwhite", p.getUsernameCliente());
	}

	@Test
	public void testGetSetIdSpettacolo() {
		p.setIdSpettacolo(50);
		assertEquals(50, p.getIdSpettacolo());
	}

	@Test
	public void testGetSetListaPostiPrenotati() {

		PostoPrenotato pp = new PostoPrenotato();
		PostoPrenotato pp1 = new PostoPrenotato();
		List<PostoPrenotato> lp = new ArrayList<PostoPrenotato>();
		lp.add(pp);
		lp.add(pp1);
		p.setlistaPostiPrenotati(lp);
		assertEquals(lp, p.getlistaPostiPrenotati());
	}
	
	@Test
	public void testCostruttoreDAO() {
		PrenotazioneDAO pd = new PrenotazioneDAO();
		p = new Prenotazione(pd);
		assertEquals(0, p.getCodice());
	}

}

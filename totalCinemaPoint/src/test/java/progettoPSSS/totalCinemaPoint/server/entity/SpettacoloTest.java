package progettoPSSS.totalCinemaPoint.server.entity;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import progettoPSSS.totalCinemaPoint.server.DAO.PrenotazioneDAO;
import progettoPSSS.totalCinemaPoint.server.DAO.SpettacoloDAO;

public class SpettacoloTest {
	
	private Spettacolo s;

	@Before
	public void setUp() throws Exception {
		s = new Spettacolo();
		assertNotNull(s);
	}

	@After
	public void tearDown() throws Exception {
		s = null;
		assertNull(s);
	}

	@Test
	public void testGetSetIdSpettacolo() {
		s.setIdSpettacolo(1);
		assertEquals(1, s.getIdSpettacolo());
	}
	
	@Test
	public void testGetSetData() {
		Date d = new java.sql.Date(System.currentTimeMillis());
		s.setData(d);
		assertEquals(d, s.getData());
	}
	
	@Test
	public void testGetSetOra() {
		String ora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		s.setOra(ora);
		assertEquals(ora, s.getOra());
	}
	
	@Test
	public void testGetSetPrezzo() {
		Double p = 50.0;
		s.setPrezzo(p);
		assertEquals(p, s.getPrezzo());
	}
	
	@Test
	public void testGetSetIdFilm() {
		s.setIdFilm(10);
		assertEquals(10, s.getIdFilm());
	}
	
	@Test
	public void testGetSetNomeSala() {
		s.setNomeSala("A");
		assertEquals("A", s.getNomeSala());
	}
	
	@Test
	public void testGetSetListaPrenotazioni() {
		Prenotazione p = new Prenotazione();
		PrenotazioneDAO p1 = new PrenotazioneDAO();
		ArrayList<Prenotazione> lp = new ArrayList<Prenotazione>();
		s.setListaPrenotazioni(lp);
		assertEquals(lp, s.getListaPrenotazioni());
	}
	
	@Test
	public void testAddeGetPrenotazioni() {
		s.setIdSpettacolo(10);
		s.addListaPrenotazioni();
		assertEquals(1, s.getListaPrenotazioni().size());
	}
	
	@Test
	public void testCostruttoreDAO() {
		SpettacoloDAO sd = new SpettacoloDAO();
		s = new Spettacolo(sd);
		assertEquals(0, s.getIdSpettacolo());
	}
	

}

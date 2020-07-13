package progettoPSSS.totalCinemaPoint.client.entity;

import static org.junit.Assert.*;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		Prenotazione p1 = new Prenotazione();
		ArrayList<Prenotazione> lp = new ArrayList<Prenotazione>();
		s.setListaPrenotazioni(lp);
		assertEquals(lp, s.getListaPrenotazioni());
	}
	
	@Test
	public void testGetSetCostruttoreCompleto() {
		Prenotazione p = new Prenotazione();
		Prenotazione p1 = new Prenotazione();
		ArrayList<Prenotazione> lp = new ArrayList<Prenotazione>();
		s.setListaPrenotazioni(lp);
		Date d = new java.sql.Date(System.currentTimeMillis());
		String ora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		Double prezzo = 100.5;
		s = new Spettacolo(5,d,ora,prezzo,50,"C",lp);
		assertEquals(5, s.getIdSpettacolo());
		assertEquals(d, s.getData());
		assertEquals(ora, s.getOra());
		assertEquals(prezzo, s.getPrezzo());
		assertEquals(50, s.getIdFilm());
		assertEquals("C", s.getNomeSala());
		assertEquals(lp, s.getListaPrenotazioni());
	}

}

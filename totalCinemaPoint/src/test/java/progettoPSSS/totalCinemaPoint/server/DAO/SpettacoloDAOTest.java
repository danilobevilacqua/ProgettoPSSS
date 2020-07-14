package progettoPSSS.totalCinemaPoint.server.DAO;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import progettoPSSS.totalCinemaPoint.client.entity.Prenotazione;

public class SpettacoloDAOTest {
	
	private SpettacoloDAO s;

	@Before
	public void setUp() throws Exception {
		s = new SpettacoloDAO();
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
		s.setIdFilm_fk(10);
		assertEquals(10, s.getIdFilm_fk());
	}
	
	@Test
	public void testGetSetNomeSala() {
		s.setNomeSala_fk("A");
		assertEquals("A", s.getNomeSala_fk());
	}
	
	@Test
	public void testGetSetListaPrenotazioni() {
		PrenotazioneDAO p = new PrenotazioneDAO();
		PrenotazioneDAO p1 = new PrenotazioneDAO();
		ArrayList<PrenotazioneDAO> lp = new ArrayList<PrenotazioneDAO>();
		s.setListaPrenotazioni(lp);
		assertEquals(lp, s.getListaPrenotazioni());
	}
	
	@Test
	public void testGetAllPrenotazioni() {
		List<PrenotazioneDAO> lp = s.getAllPrenotazioni(10);
		assertEquals(1, lp.size());
	}
	
	@Test
	public void testCostruttoreIdSpettacolo() {
		s = new SpettacoloDAO(10);
		assertEquals(10, s.getIdSpettacolo());
	}

}

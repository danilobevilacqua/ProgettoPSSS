package progettoPSSS.totalCinemaPoint.server.DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import progettoPSSS.totalCinemaPoint.client.entity.Spettacolo;

public class FilmDAOTest {

	FilmDAO f;
	
	@Before
	public void setUp() throws Exception {
		f = new FilmDAO();
		assertNotNull(f);
	}

	@After
	public void tearDown() throws Exception {
		f = null;
		assertNull(f);
	}

	@Test
	public void testGetSetIdFilm() {
		f.setIdFilm(1);
		assertEquals(1, f.getIdFilm());		
	}
	@Test
	public void testGetSetTitolo() {
		f.setTitolo("il tempo delle mele");
		assertEquals("il tempo delle mele", f.getTitolo());		
	}
	@Test
	public void testGetSetDescrizione() {
		f.setDescrizione("film romantico");
		assertEquals("film romantico", f.getDescrizione());		
	}
	@Test
	public void testGetSetAnno() {
		f.setAnno(1990);
		assertEquals(1990, f.getAnno());		
	}
	@Test
	public void testGetSetRegista() {
		f.setRegista("un regista");
		assertEquals("un regista", f.getRegista());		
	}
	@Test
	public void testGetSetLocandina() {
		f.setLocandina(null);
		assertEquals(null, f.getLocandina());
	}
	@Test
	public void testGetSetListaSpettacoli() {
		SpettacoloDAO s = new SpettacoloDAO();
		SpettacoloDAO s1 = new SpettacoloDAO();
		ArrayList<SpettacoloDAO> ls = new ArrayList<SpettacoloDAO>();
		ls.add(s);
		ls.add(s1);
		f.setListaSpettacoli(ls);
		assertEquals(ls, f.getListaSpettacoli());
	}
	
	@Test
	public void testGetSetIdCinema() {
		f.setIdcinema_fk(10); 
		assertEquals(10, f.getIdcinema_fk());		
	}
	
	@Test
	public void testCostruttoreIdFilm() {
		f = new FilmDAO(10);
		assertEquals("Inside out", f.getTitolo());
	}
	
	@Test
	public void testGetAllSpettacoli() {
		List<SpettacoloDAO> ls = f.getAllSpettacoli(10);
		assertEquals(4, ls.size());
	}

}

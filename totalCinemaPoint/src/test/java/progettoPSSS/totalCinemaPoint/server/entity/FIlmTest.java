package progettoPSSS.totalCinemaPoint.server.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import progettoPSSS.totalCinemaPoint.server.DAO.FilmDAO;


public class FIlmTest {

	private Film f;

	@Before
	public void setUp() throws Exception {
		f = new Film();
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
		Spettacolo s = new Spettacolo();
		Spettacolo s1 = new Spettacolo();
		List<Spettacolo> ls = new ArrayList<Spettacolo>();
		ls.add(s);
		ls.add(s1);
		f.setListaSpettacoli(ls);
		f.setListaSpettacoli(ls);
		assertEquals(ls, f.getListaSpettacoli());
	}
	
	@Test
	public void testCostruttoreSpettacoloDAO() {
		FilmDAO fd = new FilmDAO();
		f = new Film(fd);
		assertEquals("", f.getTitolo());
	}
	
	@Test
	public void testGetSpettacoli() {
		f.setIdFilm(10);
		f.addListaSpettacoli();
		assertEquals(4, f.getListaSpettacoli().size());
	}
	
	
	

}

package progettoPSSS.totalCinemaPoint.client.entity;

import static org.junit.Assert.*;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilmTest {
	private Film f;
	@Before
	public void setUp() throws Exception {
		f=new Film();
		assertNotNull(f);
	}

	@After
	public void tearDown() throws Exception {
		f=null;
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
		ArrayList<Spettacolo> ls = new ArrayList<Spettacolo>();
		ls.add(s);
		ls.add(s1);
		f.setListaSpettacoli(ls);
		assertEquals(ls, f.getListaSpettacoli());
	}
	
	@Test
	public void testCostruttoreCompleto() {
		Spettacolo s = new Spettacolo();
		Spettacolo s1 = new Spettacolo();
		ArrayList<Spettacolo> ls = new ArrayList<Spettacolo>();
		ls.add(s);
		ls.add(s1);
		f = new Film(2, "l'esorcista", "horror", 1980, "qualcuno", null, ls);
		
		assertEquals(2, f.getIdFilm());
		assertEquals("l'esorcista", f.getTitolo());
		assertEquals("horror", f.getDescrizione());
		assertEquals(1980, f.getAnno());
		assertEquals("qualcuno", f.getRegista());
		assertEquals(null, f.getLocandina());
		assertEquals(ls, f.getListaSpettacoli());

	}

}

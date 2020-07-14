package progettoPSSS.totalCinemaPoint.server.DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CinemaDAOTest {
	
	CinemaDAO c;
	
	@Before
	public void setUp() throws Exception {
		c = new CinemaDAO();
		assertNotNull(c);
	}

	@After
	public void tearDown() throws Exception {
		c = null;
		assertNull(c);
	}

	
	@Test
	public void testGetAllFilmsEGetListaFilm() {
		assertEquals(10, c.getListaFilms().size());		
	}
	
	@Test
	public void testGetSetId() {
		c.setIdCinema(5);
		assertEquals(5, c.getIdCinema());
	}
	
	@Test
	public void testGetSetNome() {
		c.setNome("TestNome");
		assertEquals("TestNome", c.getNome());
	}
	
	@Test
	public void testGetSetIndirizzo() {
		c.setIndirizzo("TestIndirizzo");
		assertEquals("TestIndirizzo", c.getIndirizzo());
	}
	
	@Test
	public void testGetSetTelefono() {
		c.setTelefono("5555555555");
		assertEquals("5555555555", c.getTelefono());
	}
	@Test
	public void testGetSetListaFilm() {
		FilmDAO fd = new FilmDAO();
		FilmDAO fd1 = new FilmDAO();
		List<FilmDAO> lf = new ArrayList<FilmDAO>();
		c.setListaFilms(lf);
		assertEquals(lf, c.getListaFilms());
	}

}

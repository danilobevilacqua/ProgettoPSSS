package progettoPSSS.totalCinemaPoint.server.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CinemaTest {
	
	private Cinema c;

	@Before
	public void setUp() throws Exception {
		c = new Cinema();
		assertNotNull(c);
	}

	@After
	public void tearDown() throws Exception {
		c = null;
		assertNull(c);
	}

	@Test
	public void testGetFilmsGetListaFilms() {
		assertEquals(10, c.getListaFilms().size());
	}

	@Test
	public void testSetGetListafilms() {
		Film f = new Film();
		Film f1 = new Film();
		List<Film> lf = new ArrayList<Film>();
		lf.add(f);
		lf.add(f1);
		c.setListaFilms(lf);
		assertEquals(lf, c.getListaFilms());
	}
}

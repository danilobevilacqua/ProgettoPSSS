package progettoPSSS.totalCinemaPoint.server.DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrenotazioneDAOTest {

	private PrenotazioneDAO p;

	@Before
	public void setUp() throws Exception {
		p = new PrenotazioneDAO();
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
		p.setUsernameCliente_fk("walterwhite");
		assertEquals("walterwhite", p.getUsernameCliente_fk());
	}

	@Test
	public void testGetSetIdSpettacolo() {
		p.setIdSpettacolo_fk(50);
		assertEquals(50, p.getIdSpettacolo_fk());
	}

	@Test
	public void testGetSetListaPostiPrenotati() {

		PostoPrenotatoDAO pp = new PostoPrenotatoDAO();
		PostoPrenotatoDAO pp1 = new PostoPrenotatoDAO();
		List<PostoPrenotatoDAO> lp = new ArrayList<PostoPrenotatoDAO>();
		lp.add(pp);
		lp.add(pp1);
		p.setListaPostiPrenotati(lp);
		assertEquals(lp, p.getListaPostiPrenotati());
	}

	@Test
	public void testGetAllPostiPrenotati() {

		List<PostoPrenotatoDAO> lp = p.getAllPostiPrenotati(72);
		assertEquals(lp, p.getListaPostiPrenotati());
	}
	
	@Test
	public void testCostruttoreCodice() {

		p = new PrenotazioneDAO(72);
		assertEquals(72, p.getCodice());
	}
	
	@Test
	public void testCostruttoreUserID() {

		p = new PrenotazioneDAO("walterwhite",10);
		assertEquals("walterwhite", p.getUsernameCliente_fk());
		assertEquals(10, p.getIdSpettacolo_fk());
	}
}

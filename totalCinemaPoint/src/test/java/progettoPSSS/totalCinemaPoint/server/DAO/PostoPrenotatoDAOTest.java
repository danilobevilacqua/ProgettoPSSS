package progettoPSSS.totalCinemaPoint.server.DAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PostoPrenotatoDAOTest {

	private PostoPrenotatoDAO pp;
	
	@Before
	public void setUp() throws Exception {
		pp = new PostoPrenotatoDAO();
		assertNotNull(pp);
	}

	@After
	public void tearDown() throws Exception {
		pp=null;
		assertNull(pp);
	}

	@Test
	public void testGetSetCodice() {
		pp.setCodicePrenotazione_fk(5);
		assertEquals(5, pp.getCodicePrenotazione_fk());
	}
	
	@Test
	public void testGetSetNumeroPosto() {
		pp.setNumeroPosto_fk(20);
		assertEquals(20, pp.getNumeroPosto_fk());
	}
	
	@Test
	public void testGetSetNomeSala() {
		pp.setNomeSala_fk("C");
		assertEquals("C", pp.getNomeSala_fk());
	}
	
	@Test
	public void testGetSetTipo() {
		pp.setTipo("prenotato");
		assertEquals("prenotato", pp.getTipo());
	}

}

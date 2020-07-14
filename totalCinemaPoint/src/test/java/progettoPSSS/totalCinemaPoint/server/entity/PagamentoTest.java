package progettoPSSS.totalCinemaPoint.server.entity;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PagamentoTest {
	
	private Pagamento p;

	@Before
	public void setUp() throws Exception {
		p = new Pagamento();
		assertNotNull(p);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSetIdPagamento() {
		p.setIdPagamento(10);
		assertEquals(10, p.getIdPagamento());
	}
	
	@Test
	public void testGetSetData() {
		Date d = new java.sql.Date(System.currentTimeMillis());
		p.setData(d);
		assertEquals(d, p.getData());
	}
	
	@Test
	public void testGetSetOra() {
		String ora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		p.setOra(ora);
		assertEquals(ora, p.getOra());
	}
	
	@Test
	public void testGetSetImporto() {
		Double importo = 25.0;
		p.setImporto(importo);;
		assertEquals(importo, p.getImporto());
	}
	
	@Test
	public void testGetSetCodicePrenotazione() {
		p.setCodicePrenotazione(5);
		assertEquals(5, p.getCodicePrenotazione());
	}

}

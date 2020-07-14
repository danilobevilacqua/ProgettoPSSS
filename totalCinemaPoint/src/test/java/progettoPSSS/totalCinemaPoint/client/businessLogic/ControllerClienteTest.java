package progettoPSSS.totalCinemaPoint.client.businessLogic;

import static org.junit.Assert.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import progettoPSSS.totalCinemaPoint.client.entity.Cliente;
import progettoPSSS.totalCinemaPoint.server.servizi.ServerMain;

public class ControllerClienteTest {
		
	private ServerMain sm;
	@Before
	public void setUp() throws Exception {
		sm = new ServerMain();
		sm.main(null);
	}
	
	@After
	public void tearDown() throws Exception {
		sm=null;
		assertNull(sm);
	}
	
	@Test
	public void testLogin() {
		boolean result=false;
		try {
			result = ControllerCliente.logIn("walterwhite","walter");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, result);
	}
	
	@Test
	public void testGetFilmTitles() {
		String films="";
		try {
			films= ControllerCliente.getFilmTitles();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(10, films.split("\n").length);
	}
	
	@Test
	public void testGetSpettacoliDate() {
		List<String> ld = new ArrayList<String>();	
		try {
			ControllerCliente.getFilmTitles();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ld = ControllerCliente.getSpettacoliDate("Inside out");		
		assertEquals(4, ld.size());
	}
	
	@Test
	public void testGetSpettacoliOrari() {
		List<String> ls = new ArrayList<String>();
		try {
			ControllerCliente.getFilmTitles();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControllerCliente.getSpettacoliDate("Inside out");
		List<String> ora = ControllerCliente.getSpettacoliOrari("2020-07-22");
		List<String> oraAttesa = new ArrayList<String>();
		oraAttesa.add("17:00:00");
		assertEquals(oraAttesa, ora);
	}	
	
	@Test
	public void testGetPosti() {
		
		try {
			ControllerCliente.getFilmTitles();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControllerCliente.getSpettacoliDate("Inside out");
		String data = "2020-07-22";
		List<String> ora = ControllerCliente.getSpettacoliOrari(data);
		Map<String,String>mp = new HashMap<String, String>();
		try {
			mp = ControllerCliente.getPosti(data, "17:00:00");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(8, mp.size());
		
	}
	
	@Test (expected = RemoteException.class)
	public void testPrenota() throws JsonProcessingException, RemoteException {
		
		try {
			ControllerCliente.getFilmTitles();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControllerCliente.getSpettacoliDate("Inside out");
		String data = "2020-07-22";
		List<String> ora = ControllerCliente.getSpettacoliOrari(data);
		Map<String,String>mp = new HashMap<String, String>();
		try {
			mp = ControllerCliente.getPosti(data, "17:00:00");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			int ritorno = ControllerCliente.prenota(mp, 12.0);
		
		
		
	}
	
	@Test
	public void testCalcolaImporto() {
		try {
			ControllerCliente.getFilmTitles();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControllerCliente.getSpettacoliDate("Inside out");
		String data = "2020-07-22";
		List<String> ora = ControllerCliente.getSpettacoliOrari(data);
		Map<String,String>mp = new HashMap<String, String>();
		try {
			mp = ControllerCliente.getPosti(data, "17:00:00");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double importo = ControllerCliente.calcolaImporto(mp);
		Double importoAtteso = 12.0;
		assertEquals(importoAtteso, importo);
	}
	
	@Test
	public void testGetNomeSala() {
		
		try {
			ControllerCliente.getFilmTitles();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControllerCliente.getSpettacoliDate("Inside out");
		String sala = ControllerCliente.getNomeSala();
		assertEquals("L", sala);
		
	}
	
	@Test
	public void testGetDatiFilm() {
		
		try {
			ControllerCliente.getFilmTitles();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControllerCliente.getSpettacoliDate("Inside out");
		String dati = ControllerCliente.getDatiFilm();		
		assertEquals(4, dati.split("\n").length);		
	}
	
	@Test
	public void testGetDatiCliente() {
		try {
			ControllerCliente.logIn("walterwhite","walter");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String dati = ControllerCliente.getDatiCliente();
		assertEquals(3, dati.split("\n").length);
	}
	
	@Test 
	public void testGetPrezzoSPettacolo() {
		try {
			ControllerCliente.getFilmTitles();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControllerCliente.getSpettacoliDate("Inside out");
		Double prezzo = ControllerCliente.getPrezzoSpettacolo();
		Double prezzoAtteso = 6.0;
		assertEquals(prezzoAtteso, prezzo);
	}
	
	@Test
	public void testGetDataSpettaoloSelezionato() {
		try {
			ControllerCliente.getFilmTitles();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControllerCliente.getSpettacoliDate("Inside out");
		String data = "2020-07-22";
		List<String> ora = ControllerCliente.getSpettacoliOrari(data);
		Map<String,String>mp = new HashMap<String, String>();
		try {
			mp = ControllerCliente.getPosti(data, "17:00:00");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dataRetrieve = ControllerCliente.getDataSpettacoloSelezionato();
		assertEquals(data, dataRetrieve);
	}
	
	@Test
	public void testGetOraSpettaoloSelezionato() {
		try {
			ControllerCliente.getFilmTitles();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControllerCliente.getSpettacoliDate("Inside out");
		String data = "2020-07-22";
		List<String> ora = ControllerCliente.getSpettacoliOrari(data);
		Map<String,String>mp = new HashMap<String, String>();
		try {
			mp = ControllerCliente.getPosti(data, "17:00:00");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String oraRetrieve = ControllerCliente.getOraSpettacoloSelezionato();
		assertEquals(ora.get(0), oraRetrieve);
	}

}

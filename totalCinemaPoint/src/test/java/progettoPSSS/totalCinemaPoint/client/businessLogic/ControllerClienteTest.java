package progettoPSSS.totalCinemaPoint.client.businessLogic;

import static org.junit.Assert.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	

}

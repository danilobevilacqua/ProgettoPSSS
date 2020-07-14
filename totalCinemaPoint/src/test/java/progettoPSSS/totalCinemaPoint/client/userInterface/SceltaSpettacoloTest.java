package progettoPSSS.totalCinemaPoint.client.userInterface;

import static org.junit.Assert.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import progettoPSSS.totalCinemaPoint.client.businessLogic.ControllerCliente;
import progettoPSSS.totalCinemaPoint.server.servizi.ServerMain;

public class SceltaSpettacoloTest {
	private SceltaSpettacolo sp;
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
	public void test() {
		sp = new SceltaSpettacolo(null);
		
	}

}

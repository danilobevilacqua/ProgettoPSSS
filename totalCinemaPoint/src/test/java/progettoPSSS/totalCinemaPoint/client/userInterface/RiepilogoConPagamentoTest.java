package progettoPSSS.totalCinemaPoint.client.userInterface;

import static org.junit.Assert.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import progettoPSSS.totalCinemaPoint.client.businessLogic.ControllerCliente;
import progettoPSSS.totalCinemaPoint.server.servizi.ServerMain;

public class RiepilogoConPagamentoTest {

	private RiepilogoConPagamento r;
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
		r = new RiepilogoConPagamento(null, mp);
	}

}

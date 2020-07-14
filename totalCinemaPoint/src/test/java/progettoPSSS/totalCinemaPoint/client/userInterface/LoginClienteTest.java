package progettoPSSS.totalCinemaPoint.client.userInterface;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginClienteTest {

	private LoginCliente l;
	

	@After
	public void tearDown() throws Exception {
		l = null;
		assertNull(l); 
	}

	@Test
	public void test() {
		l = new LoginCliente(null);
	}

}

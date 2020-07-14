package progettoPSSS.totalCinemaPoint.client.userInterface;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MenuClienteTest {

	private MenuCliente mc;

	@After
	public void tearDown() throws Exception {
		mc = null;
		assertNull(mc);
	}

	@Test
	public void test() {
		mc = new MenuCliente(null);
	}

}

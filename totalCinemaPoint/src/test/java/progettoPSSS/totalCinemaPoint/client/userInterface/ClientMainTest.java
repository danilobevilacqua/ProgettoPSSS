package progettoPSSS.totalCinemaPoint.client.userInterface;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClientMainTest {
	
	private ClientMain c;

	@Before
	public void setUp() throws Exception {
		c = new ClientMain(null);
		assertNotNull(c);
	}

	@After
	public void tearDown() throws Exception {
		c = null;
		assertNull(c);
	}
	
	@Test
	public void test() {
		
	}

}

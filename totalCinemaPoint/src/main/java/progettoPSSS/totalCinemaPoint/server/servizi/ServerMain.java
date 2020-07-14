package progettoPSSS.totalCinemaPoint.server.servizi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import progettoPSSS.totalCinemaPoint.server.businessLogic.ControllerCliente;

@SuppressWarnings("all")
public class ServerMain {

	public static void main(String[] args) {

		try {
			Registry r = LocateRegistry.getRegistry();

			ControllerCliente sc = new ControllerCliente(r);
			r.rebind("serviziocliente", sc);

		} catch (RemoteException e) {

			e.printStackTrace();
		} 
	}

}

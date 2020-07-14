package sistemaDiPagamento;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import progettoPSSS.totalCinemaPoint.interfacce.IServizioPagamento;

@SuppressWarnings("all")
public class STUBServizioPagamento extends UnicastRemoteObject implements IServizioPagamento {

	protected STUBServizioPagamento() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
		try {
			Registry r = LocateRegistry.getRegistry();
			r.rebind("pagamento", new STUBServizioPagamento());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean paga(double importo, String numeroConto) throws RemoteException {
		return true;
	}
	


}

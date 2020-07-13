package sistemaDiPagamento;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import progettoPSSS.totalCinemaPoint.interfacce.IServizioPagamento;

public class STUBServizioPagamento extends UnicastRemoteObject implements IServizioPagamento {

	protected STUBServizioPagamento() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Registry r = LocateRegistry.getRegistry();
			r.rebind("pagamento", new STUBServizioPagamento());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean paga(double importo, String numeroConto) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}
	


}

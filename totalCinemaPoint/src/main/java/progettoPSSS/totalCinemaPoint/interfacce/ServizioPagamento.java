package progettoPSSS.totalCinemaPoint.interfacce;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServizioPagamento extends Remote {
	public boolean paga(double importo) throws RemoteException;
}

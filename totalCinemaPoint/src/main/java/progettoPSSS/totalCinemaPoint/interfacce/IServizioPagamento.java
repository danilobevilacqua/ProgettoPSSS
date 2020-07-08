package progettoPSSS.totalCinemaPoint.interfacce;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServizioPagamento extends Remote {
	public boolean paga(double importo, String numeroConto) throws RemoteException;
}

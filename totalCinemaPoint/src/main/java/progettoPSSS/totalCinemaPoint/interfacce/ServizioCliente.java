package progettoPSSS.totalCinemaPoint.interfacce;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ServizioCliente extends Remote {
	void logIn(String username, String password) throws RemoteException;
	List<String> getFilmTitles() throws RemoteException;
	
	void prenotaSpettacolo() throws RemoteException;
}

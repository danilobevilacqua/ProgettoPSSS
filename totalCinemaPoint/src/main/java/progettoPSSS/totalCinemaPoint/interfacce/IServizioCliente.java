package progettoPSSS.totalCinemaPoint.interfacce;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServizioCliente extends Remote {
	String logIn(String username, String password) throws RemoteException;
	String getFilm() throws RemoteException;
	String getSpettacoli(String filmSceltoJSON) throws RemoteException;
	int prenotaSpettacolo(String spettacoloSceltoJSON, String postiSceltiJSON, String username, String numeroConto, double importo) throws RemoteException;
}

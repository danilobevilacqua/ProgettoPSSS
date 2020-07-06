package progettoPSSS.totalCinemaPoint.interfacce;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServizioCliente extends Remote {
	String logIn(String username, String password) throws RemoteException;
	String getFilm() throws RemoteException;
	String getSpettacoli(String filmSceltoJSON) throws RemoteException;
	String getPostiSpettacolo(int idSpettacolo) throws RemoteException;
	boolean prenotaSpettacolo(String spettacoloSceltoJSON, String postiSceltiJSON, String username, String numeroConto, double importo) throws RemoteException;
}

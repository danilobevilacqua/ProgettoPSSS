package progettoPSSS.totalCinemaPoint.interfacce;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import progettoPSSS.totalCinemaPoint.server.entity.Film;
import progettoPSSS.totalCinemaPoint.server.entity.Posto;
import progettoPSSS.totalCinemaPoint.server.entity.Spettacolo;

public interface ServizioCliente extends Remote {
	String logIn(String username, String password) throws RemoteException;
	String getFilm() throws RemoteException;
	String getSpettacoli(String filmSceltoJSON) throws RemoteException;
	boolean prenotaSpettacolo(String spettacoloSceltoJSON, String postiSceltiJSON, String username) throws RemoteException;
}

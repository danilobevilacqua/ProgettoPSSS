package progettoPSSS.totalCinemaPoint.interfacce;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import progettoPSSS.totalCinemaPoint.server.entity.Film;
import progettoPSSS.totalCinemaPoint.server.entity.Posto;
import progettoPSSS.totalCinemaPoint.server.entity.Spettacolo;

public interface ServizioCliente extends Remote {
	void logIn(String username, String password) throws RemoteException;
	List<Film> getFilm() throws RemoteException;
	List<Spettacolo> getSpettacoli(Film filmScelto) throws RemoteException;
	boolean prenotaSpettacolo(Spettacolo spettacoloScelto, List<Posto> postiScelti) throws RemoteException;
}

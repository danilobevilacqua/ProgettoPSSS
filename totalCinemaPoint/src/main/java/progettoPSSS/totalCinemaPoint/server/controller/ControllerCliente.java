package progettoPSSS.totalCinemaPoint.server.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import progettoPSSS.totalCinemaPoint.interfacce.ServizioCliente;
import progettoPSSS.totalCinemaPoint.server.entity.Cinema;
import progettoPSSS.totalCinemaPoint.server.entity.Cliente;
import progettoPSSS.totalCinemaPoint.server.entity.Film;

public class ControllerCliente implements ServizioCliente {
	
	List<Cliente> listaClientiLoggati = new ArrayList<Cliente>();
	
	@Override
	public synchronized void prenotaSpettacolo() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public synchronized void logIn(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Cliente cliente = new Cliente(username, password);
			listaClientiLoggati.add(cliente);
		} catch (Exception e) {
			//System.out.println("Log in fallito!");
			throw new RemoteException("Log in fallito");
		}
		
	}

	@Override
	public List<String> getFilmTitles() throws RemoteException {
		// TODO Auto-generated method stub
		List<String> listaTitoli = new ArrayList<String>();
		
		/*for( Film f :  Cinema.getFilms() ) {
			listaTitoli.add(f.getTitolo());		
		}*/
		
		return listaTitoli;
	}

}

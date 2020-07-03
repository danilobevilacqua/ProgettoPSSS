package progettoPSSS.totalCinemaPoint.server.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import progettoPSSS.totalCinemaPoint.interfacce.ServizioCliente;
import progettoPSSS.totalCinemaPoint.server.entity.Cinema;
import progettoPSSS.totalCinemaPoint.server.entity.Cliente;
import progettoPSSS.totalCinemaPoint.server.entity.Film;
import progettoPSSS.totalCinemaPoint.server.entity.Posto;
import progettoPSSS.totalCinemaPoint.server.entity.Prenotazione;
import progettoPSSS.totalCinemaPoint.server.entity.Spettacolo;

public class ControllerCliente implements ServizioCliente {
	
	private List<Cliente> listaClientiLoggati = new ArrayList<Cliente>();
	private Cinema cinema = new Cinema();

	@Override
	public void logIn(String username, String password) throws RemoteException {
		try {
			Cliente cliente = new Cliente(username, password);
			listaClientiLoggati.add(cliente);
		} catch (Exception e) {
			//System.out.println("Log in fallito!");
			throw new RemoteException("Log-in fallito! ");
		}
		
	}

	@Override
	public List<Film> getFilm() throws RemoteException {
		List<Film> listaFilm = new ArrayList<Film>();
		
		/*for( Film f :  Cinema.getFilms() ) {
			listaTitoli.add(f.getTitolo());		
		}*/
		
		listaFilm = cinema.getListaFilms();
		
		return listaFilm;
	}

	@Override
	public synchronized List<Spettacolo> getSpettacoli(Film filmScelto) throws RemoteException {

		filmScelto.addListaSpettacoli();
		
		List<Spettacolo> listaSpettacoli = new ArrayList<Spettacolo>();
		
		for (Spettacolo s : filmScelto.getListaSpettacoli()) {
			s.addListaPrenotazioni();
			
			int totPostiPrenotati = 0;
			
			for (Prenotazione p : s.getListaPrenotazioni()) {
				totPostiPrenotati += p.getlistaPostiPrenotati().size();
			}
			
			if(totPostiPrenotati < 100) {
				listaSpettacoli.add(s);
			}
		}
		
		return listaSpettacoli;
	}

	@Override
	public synchronized boolean prenotaSpettacolo(Spettacolo spettacoloScelto, List<Posto> postiScelti) throws RemoteException {
		
		for (Prenotazione p : spettacoloScelto.getListaPrenotazioni()) {
		}
				
		return false;
	}
}

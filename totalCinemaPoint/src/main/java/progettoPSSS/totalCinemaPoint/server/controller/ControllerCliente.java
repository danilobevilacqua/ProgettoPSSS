package progettoPSSS.totalCinemaPoint.server.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import progettoPSSS.totalCinemaPoint.interfacce.ServizioCliente;
import progettoPSSS.totalCinemaPoint.server.entity.Cinema;
import progettoPSSS.totalCinemaPoint.server.entity.Cliente;
import progettoPSSS.totalCinemaPoint.server.entity.Film;
import progettoPSSS.totalCinemaPoint.server.entity.Posto;
import progettoPSSS.totalCinemaPoint.server.entity.PostoPrenotato;
import progettoPSSS.totalCinemaPoint.server.entity.Prenotazione;
import progettoPSSS.totalCinemaPoint.server.entity.Spettacolo;

public class ControllerCliente implements ServizioCliente {

	private List<Cliente> listaClientiLoggati = new ArrayList<Cliente>();
	private Cinema cinema = new Cinema();
/*
	private String[] [] getLayOutposti(Spettacolo s) {
		String[][] layOutPosti = new String[10][10];

		s.addListaPrenotazioni();
		List<Prenotazione> listaPrenotazioni = s.getListaPrenotazioni();

		for (Prenotazione pr : listaPrenotazioni) {
			List<PostoPrenotato> listaPostiPrenotati = pr.getlistaPostiPrenotati();

			for(PostoPrenotato pp : listaPostiPrenotati) {
				layOutPosti[(pp.getNumeroPosto() - 1) / 10] [(pp.getNumeroPosto() - 1) % 10] = pp.getTipo();
			}
		}		

		return layOutPosti;
	}
	*/

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
	public String getFilm() throws RemoteException {
		List<Film> listaFilm = new ArrayList<Film>();

		/*for( Film f :  Cinema.getFilms() ) {
			listaTitoli.add(f.getTitolo());		
		}*/

		listaFilm = cinema.getListaFilms();

		ObjectMapper om = new ObjectMapper();
		String listaFilmJSON = null;
		try {
			listaFilmJSON = om.writeValueAsString(listaFilm);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException("Impossibile inviare lista di film");
		}

		return listaFilmJSON;
	}

	@Override
	public synchronized String getSpettacoli(String filmSceltoJSON) throws RemoteException {

		Film filmScelto = new Film();
		ObjectMapper om = new ObjectMapper();

		try {
			filmScelto = om.readValue(filmSceltoJSON, Film.class);
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RemoteException("Errore nella lettura del film scelto");
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RemoteException("Errore nella lettura del film scelto");
		}


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

		try {
			return om.writeValueAsString(listaSpettacoli);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException("Impossibile inviare lista di spettacoli");
		}
	}

	@Override
	public synchronized boolean prenotaSpettacolo(String spettacoloSceltoJSON, String postiSceltiJSON) throws RemoteException {
		ObjectMapper om = new ObjectMapper();
		Spettacolo spettacolo = null;
		List<PostoPrenotato> postiScelti = null;

		try {
			spettacolo = om.readValue(spettacoloSceltoJSON, Spettacolo.class);
			postiScelti = om.readValue(postiSceltiJSON, new TypeReference<List<PostoPrenotato>> () {});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException("Errore nella lettura dello spettacolo o dei posti scelti");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException("Errore nella lettura dello spettacolo o dei posti scelti");
		}
		/*
		String[][] layOutPosi = getLayOutposti(spettacolo);

		for(PostoPrenotato p : postiScelti) {
			String tipoPosto = layOutPosi[(p.getNumeroPosto() - 1) / 10] [(p.getNumeroPosto() - 1) % 10];

			if(p.getTipo().equals("prenotato"))
				if (tipoPosto.equals("prenotato") || tipoPosto.equals("covid"))
					throw new RemoteException("Errore il posto di numero " + p.getNumeroPosto() + " è già stato prenotato oppure è indisponibile per via del distanziamento sociale");		
		}
		 */

		List<PostoPrenotato> listaPostiPrenotati = new ArrayList<PostoPrenotato>();
		spettacolo.addListaPrenotazioni();

		for(Prenotazione pr : spettacolo.getListaPrenotazioni())
			listaPostiPrenotati.addAll(pr.getlistaPostiPrenotati());

		for (PostoPrenotato pp : postiScelti) {
			int indice = listaPostiPrenotati.indexOf(pp);
			if (indice != -1) {
				PostoPrenotato ppr = listaPostiPrenotati.get(indice);
				if (pp.getTipo().equals("covid") && ppr.getTipo().equals("covid")) {
					postiScelti.remove(pp);
				} else if (ppr.getTipo().equals("prenotato") || (ppr.getTipo().equals("covid") && pp.getTipo().equals("prenotato"))) {
					throw new RemoteException("Errore il posto di numero " + pp.getNumeroPosto() + " è già stato prenotato oppure è indisponibile per via del distanziamento sociale");
				}
			}
		}
		
		return true;
	}
}

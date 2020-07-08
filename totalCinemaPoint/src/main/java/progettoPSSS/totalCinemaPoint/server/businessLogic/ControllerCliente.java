package progettoPSSS.totalCinemaPoint.server.businessLogic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import progettoPSSS.totalCinemaPoint.interfacce.IServizioCliente;
import progettoPSSS.totalCinemaPoint.interfacce.IServizioPagamento;
import progettoPSSS.totalCinemaPoint.server.entity.Cinema;
import progettoPSSS.totalCinemaPoint.server.entity.Cliente;
import progettoPSSS.totalCinemaPoint.server.entity.Film;
import progettoPSSS.totalCinemaPoint.server.entity.Pagamento;
import progettoPSSS.totalCinemaPoint.server.entity.PostoPrenotato;
import progettoPSSS.totalCinemaPoint.server.entity.Prenotazione;
import progettoPSSS.totalCinemaPoint.server.entity.Spettacolo;

public class ControllerCliente extends UnicastRemoteObject implements IServizioCliente {

//	private List<Cliente> listaClientiLoggati = new ArrayList<Cliente>();
	private Cinema cinema = new Cinema();
	private IServizioPagamento servizioPagamento;
	private ObjectMapper om = new ObjectMapper();
	
	public ControllerCliente(IServizioPagamento servizioPagamento) throws RemoteException {
		super();
		this.servizioPagamento = servizioPagamento;
	}
	
	/*
	private double calcolaImporto(double prezzo, List<PostoPrenotato> postiScelti) {
		double prezzoTotale = 0;
		
		for (PostoPrenotato pp : postiScelti) {
			if (pp.getTipo().equals("prenotato")) {
				prezzoTotale += prezzo;
			}
		}
		return prezzoTotale;
	}
*/
	private List<PostoPrenotato> postiValidati(Spettacolo spettacolo, List<PostoPrenotato> postiScelti) throws RemoteException {
		
		List<PostoPrenotato> listaPostiPrenotati = new ArrayList<PostoPrenotato>();
		spettacolo.addListaPrenotazioni();
		
		for(Prenotazione pr : spettacolo.getListaPrenotazioni())
			listaPostiPrenotati.addAll(pr.getlistaPostiPrenotati());

		ListIterator<PostoPrenotato> li = postiScelti.listIterator();
		
		while (li.hasNext()) {
			PostoPrenotato pp = li.next();
			int indice = listaPostiPrenotati.indexOf(pp);
			if (indice != -1) {
				PostoPrenotato ppr = listaPostiPrenotati.get(indice);
				if (pp.getTipo().equals("covid") && ppr.getTipo().equals("covid")) {
					li.remove();
				} else if (ppr.getTipo().equals("prenotato") || (ppr.getTipo().equals("covid") && ppr.getTipo().equals("prenotato"))) {
					throw new RemoteException("Errore il posto di numero " + pp.getNumeroPosto() + " è già stato prenotato oppure è indisponibile per via del distanziamento sociale");
				}
			}
		}
		return postiScelti;
	}

	@Override
	public String logIn(String username, String password) throws RemoteException {
		String clienteJSON = null;
		try {
			Cliente cliente = new Cliente(username, password);
//			listaClientiLoggati.add(cliente);
			
			clienteJSON = om.writeValueAsString(cliente);
		} catch (Exception e) {
			//System.out.println("Log in fallito!");
			throw new RemoteException("Log-in fallito! ");
		}
		
		return clienteJSON;
	}

	@Override
	public String getFilm() throws RemoteException {
		List<Film> listaFilm = new ArrayList<Film>();

		listaFilm = cinema.getListaFilms();

		String listaFilmJSON = null;
		try {
			listaFilmJSON = om.writeValueAsString(listaFilm);
		} catch (JsonProcessingException e) {
		
			e.printStackTrace();
			throw new RemoteException("Impossibile inviare lista di film");
		}

		return listaFilmJSON;
	}

	@Override
	public synchronized String getSpettacoli(String filmSceltoJSON) throws RemoteException {

		Film filmScelto = new Film();
		
		try {
			filmScelto = om.readValue(filmSceltoJSON, Film.class);
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
			throw new RemoteException("Errore nella lettura del film scelto");
		} catch (JsonProcessingException e1) {
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
			e.printStackTrace();
			throw new RemoteException("Impossibile inviare lista di spettacoli");
		}
	}

	@Override
	public synchronized int prenotaSpettacolo(String spettacoloSceltoJSON, String postiSceltiJSON, String username, String numeroConto, double importo) throws RemoteException {
		Spettacolo spettacolo = null;
		List<PostoPrenotato> postiScelti = null;

		try {
			spettacolo = om.readValue(spettacoloSceltoJSON, Spettacolo.class);
			postiScelti = om.readValue(postiSceltiJSON, new TypeReference<List<PostoPrenotato>> () {});
		} catch (JsonMappingException e) {
			e.printStackTrace();
			throw new RemoteException("Errore nella lettura dello spettacolo o dei posti scelti");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RemoteException("Errore nella lettura dello spettacolo o dei posti scelti");
		}
		
		List<PostoPrenotato> listaPostiValidati = postiValidati(spettacolo, postiScelti);
		
		if (!servizioPagamento.paga(importo, numeroConto))
			throw new RemoteException("Errore, pagamento non avvenuto");
		
		String ora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        Date data = new java.sql.Date(System.currentTimeMillis());
        
		Prenotazione p = new Prenotazione(username, spettacolo.getIdSpettacolo(), listaPostiValidati);
		Pagamento pagamento = new Pagamento(data, ora, importo, p.getCodice());
		
		return p.getCodice();
	}

}

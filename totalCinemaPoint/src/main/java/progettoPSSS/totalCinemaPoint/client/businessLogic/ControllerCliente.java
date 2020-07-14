package progettoPSSS.totalCinemaPoint.client.businessLogic;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import progettoPSSS.totalCinemaPoint.client.entity.Cliente;
import progettoPSSS.totalCinemaPoint.client.entity.Film;
import progettoPSSS.totalCinemaPoint.client.entity.Prenotazione;
import progettoPSSS.totalCinemaPoint.interfacce.IServizioCliente;
import progettoPSSS.totalCinemaPoint.client.entity.PostoPrenotato;
import progettoPSSS.totalCinemaPoint.client.entity.Spettacolo;

@SuppressWarnings("all")
public class ControllerCliente {
	static private IServizioCliente sc;
	static private ObjectMapper om = new ObjectMapper();
	static private Cliente cliente;
	static private List<Film> listaFilm;
	static private Film filmSelezionato;
	static private Spettacolo spettacoloScelto;

	private ControllerCliente() {

	}

	public static synchronized IServizioCliente getInstance() throws RemoteException, NotBoundException {

		Registry r = LocateRegistry.getRegistry();
		sc = (IServizioCliente) r.lookup("serviziocliente");

		return sc;
	}

	public static boolean logIn(String username, String password) throws RemoteException, NotBoundException {
		String clienteJSON = getInstance().logIn(username, password);

		try {
			cliente = om.readValue(clienteJSON, Cliente.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return true;
	}

	public static String getFilmTitles() throws RemoteException, NotBoundException {
		String listaFilmJSON = getInstance().getFilm();

		try {
			listaFilm = om.readValue(listaFilmJSON, new TypeReference<List<Film>> () {});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		String titoliFilm= new String();

		for(Film f : listaFilm) 
			titoliFilm = titoliFilm + f.getTitolo()+"\n";

		return titoliFilm;
	}

	public static List<String> getSpettacoliDate(String titoloFilm)  {
	
		List<String> listaDateReturn = new ArrayList<String>();

		for (Film f : listaFilm) {
			if(f.getTitolo().equals(titoloFilm))
				filmSelezionato = f;
		}

		try {
			String filmSelezionatoJSON = om.writeValueAsString(filmSelezionato);
			String listaSpettacoliJSON = getInstance().getSpettacoli(filmSelezionatoJSON);
			List<Spettacolo> listaSpettacoli = om.readValue(listaSpettacoliJSON, new TypeReference<List<Spettacolo>>() {});
			filmSelezionato.setListaSpettacoli(listaSpettacoli);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

		Set<Date> setDateSpettacoli = new HashSet<Date>();

		for(Spettacolo s : filmSelezionato.getListaSpettacoli()) {
			setDateSpettacoli.add(s.getData());
		}

		List<Date> listaDate = new ArrayList<Date>(setDateSpettacoli);
		Collections.sort(listaDate);
		for(Date d : listaDate) {
			listaDateReturn.add(d.toString());
		}		

		return listaDateReturn;

	}

	public static List<String> getSpettacoliOrari(String data) {
		List<String> listaOrari = new ArrayList<String>();

		for(Spettacolo s : filmSelezionato.getListaSpettacoli()) {
			if (s.getData().toString().equals(data))
				listaOrari.add(s.getOra());
		}

		return listaOrari;

	}

	public static Map<String, String> getPosti(String data, String ora) throws Exception {
		int flagSpettacoli=0;
		Map<String, String> mappaPosti = new Hashtable<String, String>();

		for(Spettacolo s : filmSelezionato.getListaSpettacoli()) {
			if(s.getData().toString().equals(data) && s.getOra().equals(ora)) {
				spettacoloScelto = s;
			}else {
				flagSpettacoli++;
			}				
		}

		if (flagSpettacoli < filmSelezionato.getListaSpettacoli().size()) {
			for(Prenotazione p : spettacoloScelto.getListaPrenotazioni()) {
				for (PostoPrenotato pp : p.getListaPostiPrenotati()) {
					mappaPosti.put(spettacoloScelto.getNomeSala() + " " + pp.getNumeroPosto(), pp.getTipo());
				}
			}
		}else {
			throw new Exception ("posti terminati");
		}

		return mappaPosti;
	}

	public static double calcolaImporto(Map <String,String> mappaPosti) {
		double prezzoTotale = 0;
		double prezzo = spettacoloScelto.getPrezzo();

		for (String pp : mappaPosti.keySet()) {
			if (mappaPosti.get(pp).equals("prenotato")) {
				prezzoTotale += prezzo;
			}
		}
		return prezzoTotale;
	}

	public static int prenota(Map<String, String> mappaPosti, double prezzo) throws JsonProcessingException, RemoteException {
		String spettacoloSceltoJSON = om.writeValueAsString(spettacoloScelto);
		String postiSceltiJSON;

		List<PostoPrenotato> listaPostiPrenotati = new ArrayList<PostoPrenotato>();

		for (String s : mappaPosti.keySet()) {
			PostoPrenotato pp = new PostoPrenotato();
			pp.setNomeSala(spettacoloScelto.getNomeSala());
			pp.setNumeroPosto(Integer.parseInt(s.split(" ")[1]));
			pp.setTipo(mappaPosti.get(s));
			listaPostiPrenotati.add(pp);
		}

		postiSceltiJSON = om.writeValueAsString(listaPostiPrenotati);

		return sc.prenotaSpettacolo(spettacoloSceltoJSON, postiSceltiJSON, cliente.getUsername(), cliente.getNumeroCartaCredito(), prezzo);	
	}

	public static byte[] getLocandinaFilm() {
		return filmSelezionato.getLocandina();
	}

	public static String getNomeSala() {
		return spettacoloScelto.getNomeSala();
	}

	public static String getDatiFilm() {
		return filmSelezionato.getTitolo() + "\n" + filmSelezionato.getAnno() + "\n" + filmSelezionato.getRegista() + "\n" +  filmSelezionato.getDescrizione() + "\n";
	}

	public static String getDatiCliente() {
		return cliente.getUsername() + "\n" + cliente.getNome() + "\n" + cliente.getCognome();
	}

	public static double getPrezzoSpettacolo() {
		double prezzo = 0;
		if(filmSelezionato.getListaSpettacoli().size() != 0) {
			prezzo = filmSelezionato.getListaSpettacoli().get(0).getPrezzo();
		}
		return prezzo;
	}

	public static String getDataSpettacoloSelezionato() {
		return spettacoloScelto.getData().toString();
	}
	public static String getOraSpettacoloSelezionato() {
		return spettacoloScelto.getOra();
	}
}

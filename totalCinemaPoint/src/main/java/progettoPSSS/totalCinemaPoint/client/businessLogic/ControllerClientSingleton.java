package progettoPSSS.totalCinemaPoint.client.businessLogic;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
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
import progettoPSSS.totalCinemaPoint.interfacce.ServizioCliente;
import progettoPSSS.totalCinemaPoint.client.entity.PostoPrenotato;
import progettoPSSS.totalCinemaPoint.client.entity.Spettacolo;

@SuppressWarnings("all")
public class ControllerClientSingleton {
	static private ServizioCliente sc;
	static private ObjectMapper om = new ObjectMapper();
	static private Cliente cliente;
	static private List<Film> listaFilm;
	static private int indicefilmSelezionato;
	static private Film filmSelezionato;
	static private Spettacolo spettacoloScelto;
	
	private ControllerClientSingleton() {
		
	}
	
	public static synchronized ServizioCliente getInstance() throws RemoteException, NotBoundException {
		if(sc == null) {
			Registry r = LocateRegistry.getRegistry();
			sc = (ServizioCliente) r.lookup("serviziocliente");
		}
		
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
	
	public static Set<String> getSpettacoliDate(String titoloFilm) {
		
	/*
		for(int i = 0; i < listaFilm.size(); i++) {
			if (listaFilm.get(i).equals(titoloFilm))  {
				indicefilmSelezionato = i;
				break;
			}
		}
	*/	
		
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
	
		Set<String> setDateSpettacoli = new HashSet<String>();
		
		for(Spettacolo s : filmSelezionato.getListaSpettacoli()) {
			setDateSpettacoli.add(s.getData().toString());
		}
		
		return setDateSpettacoli;
		
	}
	
	public static List<String> getSpettacoliOrari(String data) {
		List<String> listaOrari = new ArrayList<String>();
		
		for(Spettacolo s : filmSelezionato.getListaSpettacoli()) {
			if (s.getData().toString().equals(data))
				listaOrari.add(s.getOra());
		}
		
		return listaOrari;
		
	}
	
	public static Map<String, String> getPosti(String data, String ora) {
		Map<String, String> mappaPosti = new Hashtable<String, String>();
		
		for(Spettacolo s : filmSelezionato.getListaSpettacoli()) {
			if(s.getData().toString().equals(data) && s.getOra().equals(ora))
				spettacoloScelto = s;
		}
		
		for(Prenotazione p : spettacoloScelto.getListaPrenotazioni()) {
			for (PostoPrenotato pp : p.getListaPostiPrenotati()) {
				mappaPosti.put(spettacoloScelto.getNomeSala() + " " + pp.getNumeroPosto(), pp.getTipo());
			}
		}
		
		return mappaPosti;
	}
	
	public static String getNomeSala() {
		return spettacoloScelto.getNomeSala();
	}
	
	/*
	public static void prenota(Map <String,String> mappaPosti) {
		String username = cliente.getUsername();
		String numeroConto = cliente.getNumeroCartaCredito();
		String spettacoloJSON = om.
	}
	*/
	
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
	
	public static String getDatiFilm() {
		return filmSelezionato.getTitolo() + "\n" + filmSelezionato.getAnno() + "\n" + filmSelezionato.getRegista() + "\n" +  filmSelezionato.getDescrizione() + "\n";
	}
	
	public double getPrezzoSpettacolo() {
		return spettacoloScelto.getPrezzo();
	}
	
	public static String getDataSpettacoloSelezionato() {
		return spettacoloScelto.getData().toString();
	}
	public static String getOraSpettacoloSelezionato() {
		return spettacoloScelto.getOra();
	}
}

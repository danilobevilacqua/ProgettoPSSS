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
	
}
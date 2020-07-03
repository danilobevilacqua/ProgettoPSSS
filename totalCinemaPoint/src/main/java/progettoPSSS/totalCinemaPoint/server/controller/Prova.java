package progettoPSSS.totalCinemaPoint.server.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import progettoPSSS.totalCinemaPoint.interfacce.ServizioCliente;
import progettoPSSS.totalCinemaPoint.server.entity.Film;
import progettoPSSS.totalCinemaPoint.server.entity.PostoPrenotato;
import progettoPSSS.totalCinemaPoint.server.entity.Spettacolo;

public class Prova {

	public static void main(String[] args) {

		ServizioCliente sc = new ControllerCliente();
		try {
			sc.logIn("walterwhite", "walter");
			System.out.println("Log-in effettuato correttamente!");
			ObjectMapper om = new ObjectMapper();
			
			String filmJSon = sc.getFilm();
			List<Film> listaFilm = om.readValue(filmJSon, new TypeReference<List<Film>>() {});
			
			for(Film f : listaFilm)
				System.out.println(f.getTitolo() + f.getAnno());
			
			String spettacoliJSON = sc.getSpettacoli(om.writeValueAsString(listaFilm.get(1)));
			List<Spettacolo> listaSpettacol = om.readValue(spettacoliJSON, new TypeReference<List<Spettacolo>>() {});
	/*		
			for(Spettacolo s : listaSpettacol) 
				System.out.println(s.getIdSpettacolo() + " " + s.getIdFilm() + " " + s.getNomeSala() + " " + s.getOra() + " " + s.getPrezzo());
			*/
			
			PostoPrenotato pp = new PostoPrenotato();
			pp.setCodicePrenotazione(2);
			pp.setNumeroPosto(62);
			pp.setNomeSala("C");
			pp.setTipo("prenotato");
			//pp.setPostoPrenotato();
    
			PostoPrenotato pp2 = new PostoPrenotato();
			pp2.setCodicePrenotazione(2);
			pp2.setNumeroPosto(61);
			pp2.setNomeSala("C");
			pp2.setTipo("covid");
			//pp2.setPostoPrenotato();
			
			PostoPrenotato pp3 = new PostoPrenotato();
			pp3.setCodicePrenotazione(2);
			pp3.setNumeroPosto(63);
			pp3.setNomeSala("C");
			pp3.setTipo("covid");
			
			PostoPrenotato pp4 = new PostoPrenotato();
			pp4.setCodicePrenotazione(2);
			pp4.setNumeroPosto(52);
			pp4.setNomeSala("C");
			pp4.setTipo("covid");
			
			PostoPrenotato pp5 = new PostoPrenotato();
			pp5.setCodicePrenotazione(2);
			pp5.setNumeroPosto(72);
			pp5.setNomeSala("C");
			pp5.setTipo("covid");

			List<PostoPrenotato>lp = new ArrayList<PostoPrenotato>();
			lp.add(pp);
			lp.add(pp2);
			lp.add(pp3);
			lp.add(pp4);
			lp.add(pp5);
			
			Spettacolo s = listaSpettacol.get(0);
			s.addListaPrenotazioni();
			
			String spettJson = om.writeValueAsString(s);
			String ppJson = om.writeValueAsString(lp);
			
			boolean flag = sc.prenotaSpettacolo(spettJson, ppJson);
			System.out.println("il flag = "+flag);
			
			
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

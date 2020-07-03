package progettoPSSS.totalCinemaPoint.server.controller;

import java.rmi.RemoteException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import progettoPSSS.totalCinemaPoint.interfacce.ServizioCliente;
import progettoPSSS.totalCinemaPoint.server.entity.Film;
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
			
			for(Spettacolo s : listaSpettacol) 
				System.out.println(s.getIdSpettacolo() + " " + s.getIdFilm() + " " + s.getNomeSala() + " " + s.getOra() + " " + s.getPrezzo());
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

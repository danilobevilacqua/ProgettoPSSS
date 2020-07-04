package progettoPSSS.totalCinemaPoint.server.servizi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import progettoPSSS.totalCinemaPoint.interfacce.ServizioPagamento;
import progettoPSSS.totalCinemaPoint.server.businessLogic.ControllerCliente;
import progettoPSSS.totalCinemaPoint.server.entity.Film;
import progettoPSSS.totalCinemaPoint.server.entity.PostoPrenotato;
import progettoPSSS.totalCinemaPoint.server.entity.Spettacolo;

public class ServerMain {

	public static void main(String[] args) {

		try {
			Registry r = LocateRegistry.getRegistry();
			ServizioPagamento sp = (ServizioPagamento) r.lookup("pagamento");
			ControllerCliente sc = new ControllerCliente(sp);
			r.rebind("serviziocliente", sc);
			/*sc.logIn("walterwhite", "walter");
			System.out.println("Log-in effettuato correttamente!");
			ObjectMapper om = new ObjectMapper();
			
			String filmJSon = sc.getFilm();
			List<Film> listaFilm = om.readValue(filmJSon, new TypeReference<List<Film>>() {});
			
			String spettacoliJSON = sc.getSpettacoli(om.writeValueAsString(listaFilm.get(1)));
			List<Spettacolo> listaSpettacol = om.readValue(spettacoliJSON, new TypeReference<List<Spettacolo>>() {});
			
			PostoPrenotato pp = new PostoPrenotato();
			pp.setCodicePrenotazione(2);
			pp.setNumeroPosto(3);
			pp.setNomeSala("C");
			pp.setTipo("covid");
			//pp.setPostoPrenotato();
    
			PostoPrenotato pp2 = new PostoPrenotato();
			pp2.setCodicePrenotazione(2);
			pp2.setNumeroPosto(13);
			pp2.setNomeSala("C");
			pp2.setTipo("prenotato");
			//pp2.setPostoPrenotato();
			
			PostoPrenotato pp6 = new PostoPrenotato();
			pp6.setCodicePrenotazione(2);
			pp6.setNumeroPosto(14);
			pp6.setNomeSala("C");
			pp6.setTipo("prenotato");
			//pp2.setPostoPrenotato();
			
			PostoPrenotato pp7 = new PostoPrenotato();
			pp7.setCodicePrenotazione(2);
			pp7.setNumeroPosto(23);
			pp7.setNomeSala("C");
			pp7.setTipo("prenotato");
			//pp2.setPostoPrenotato();
			
			PostoPrenotato pp3 = new PostoPrenotato();
			pp3.setCodicePrenotazione(2);
			pp3.setNumeroPosto(24);
			pp3.setNomeSala("C");
			pp3.setTipo("prenotato");
			
			PostoPrenotato pp4 = new PostoPrenotato();
			pp4.setCodicePrenotazione(2);
			pp4.setNumeroPosto(4);
			pp4.setNomeSala("C");
			pp4.setTipo("covid");
			
			PostoPrenotato pp5 = new PostoPrenotato();
			pp5.setCodicePrenotazione(2);
			pp5.setNumeroPosto(33);
			pp5.setNomeSala("C");
			pp5.setTipo("covid");
			
			PostoPrenotato pp8 = new PostoPrenotato();
			pp8.setCodicePrenotazione(2);
			pp8.setNumeroPosto(34);
			pp8.setNomeSala("C");
			pp8.setTipo("covid");
			
			PostoPrenotato pp9 = new PostoPrenotato();
			pp9.setCodicePrenotazione(2);
			pp9.setNumeroPosto(15);
			pp9.setNomeSala("C");
			pp9.setTipo("covid");
			
			PostoPrenotato pp10 = new PostoPrenotato();
			pp10.setCodicePrenotazione(2);
			pp10.setNumeroPosto(25);
			pp10.setNomeSala("C");
			pp10.setTipo("covid");
			
			PostoPrenotato pp11 = new PostoPrenotato();
			pp11.setCodicePrenotazione(2);
			pp11.setNumeroPosto(12);
			pp11.setNomeSala("C");
			pp11.setTipo("covid");
			
			PostoPrenotato pp12 = new PostoPrenotato();
			pp12.setCodicePrenotazione(2);
			pp12.setNumeroPosto(22);
			pp12.setNomeSala("C");
			pp12.setTipo("covid");

			List<PostoPrenotato>lp = new ArrayList<PostoPrenotato>();
			lp.add(pp);
			lp.add(pp2);
			lp.add(pp3);
			lp.add(pp4);
			lp.add(pp5);
			lp.add(pp6);
			lp.add(pp7);
			lp.add(pp8);
			lp.add(pp9);
			lp.add(pp10);
			lp.add(pp11);
			lp.add(pp12);
			
			Spettacolo s = listaSpettacol.get(0);
			s.addListaPrenotazioni();
			
			String spettJson = om.writeValueAsString(s);
			String ppJson = om.writeValueAsString(lp);
			
			boolean flag = sc.prenotaSpettacolo(spettJson, ppJson, "walterwhite", "123456789");
			System.out.println("il flag = "+flag);
			
			*/
		} catch (RemoteException e) {
	
			e.printStackTrace();
		} catch (NotBoundException e) {
	
			e.printStackTrace();
		}
	}

}

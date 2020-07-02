package progettoPSSS.totalCinemaPoint.server.entity;

import java.util.ArrayList;
import java.util.List;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	//PER INSERIRE LA PRENOTAZIONE CON I RELATIVI POSTI
		PostoPrenotato pp = new PostoPrenotato();
		pp.setCodicePrenotazione(2);
		pp.setNumeroPosto(40);
		pp.setNomeSala("C");
		//pp.setPostoPrenotato();
		
		PostoPrenotato pp2 = new PostoPrenotato();
		pp2.setCodicePrenotazione(2);
		pp2.setNumeroPosto(41);
		pp2.setNomeSala("C");
		//pp2.setPostoPrenotato();
		
		List<PostoPrenotato>lp = new ArrayList<PostoPrenotato>();
		lp.add(pp);
		lp.add(pp2);
		
		Prenotazione preno = new Prenotazione(40.0,"ugofantozzi",2,lp);
		*/
		
		/*
		//RETRIEVE LISTA SPETTACOLI PER FILM SCELTO
		List <Spettacolo> ls = Spettacolo.getSpettacoli(1);
		for(Spettacolo s : ls) {
			System.out.println("id dello spettacolo: " + s.getIdSpettacolo());
			for(Prenotazione p : s.getListaPrenotazioni()) {
				System.out.println("     id della prenotazione: "+p.getCodice());
				System.out.println("        Posti Prenotati: ");
				for(PostoPrenotato pp : p.getlistaPostiPrenotati()) {
					System.out.println("        "+pp.getNomeSala()+" "+pp.getNumeroPosto());
				 }
			}						
		}
		*/
		/*
		List<Film> lf = Film.getFilms();
			for(Film f : lf) {
				System.out.println(" titolo: "+f.getTitolo());
				
				for(Spettacolo s : f.getListaSpettacoli()) {
					System.out.println("    id dello spettacolo: " + s.getIdSpettacolo());
					for(Prenotazione p : s.getListaPrenotazioni()) {
						System.out.println("       id della prenotazione: "+p.getCodice());
						if(p.getlistaPostiPrenotati().size()!=0) {
							System.out.print("          Posti Prenotati: ");
							for(PostoPrenotato pp : p.getlistaPostiPrenotati()) {
								System.out.print(pp.getNomeSala()+" "+pp.getNumeroPosto()+" |-| ");
							 }
							System.out.println("\n");
						}
					}						
				}
			}
	*/
		
		Cinema cinema = new Cinema();		
		for(Film f : cinema.getListaFilms()) {
			System.out.println(" titolo: "+f.getTitolo());
			
			for(Spettacolo s : f.getListaSpettacoli()) {
				System.out.println("    id dello spettacolo: " + s.getIdSpettacolo());
				for(Prenotazione p : s.getListaPrenotazioni()) {
					System.out.println("       id della prenotazione: "+p.getCodice());
					if(p.getlistaPostiPrenotati().size()!=0) {
						System.out.print("          Posti Prenotati: ");
						for(PostoPrenotato pp : p.getlistaPostiPrenotati()) {
							System.out.print(pp.getNomeSala()+" "+pp.getNumeroPosto()+" |-| ");
						 }
						System.out.println("\n");
					}
				}						
			}
		}
	}

}

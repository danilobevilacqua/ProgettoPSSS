package progettoPSSS.totalCinemaPoint.server.DAO;

import java.util.List;

import org.hibernate.Session;



public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteDAO d = new ClienteDAO("walterwhite");		
		System.out.println(d.getCognome()+" "+d.getNome()+" "+d.geteMail());
		
		FilmDAO f = new FilmDAO(1);
		System.out.println(f.getTitolo() +" "+f.getAnno()+" "+f.getLocandina());
		
		SpettacoloDAO s = new SpettacoloDAO(1);
		System.out.println(s.getPrezzo() +" "+s.getData()+" "+s.getOra()+" "+s.getNomeSala_fk());
		
		PrenotazioneDAO p = new PrenotazioneDAO(1);
		System.out.println(p.getCodice() +" "+p.getUsernameCliente_fk());
		
		PostoDAO pd = new PostoDAO(1,"A");
		System.out.println(pd.getNumero() +" "+pd.getNomeSala_fk());
		
		SalaDAO sal = new SalaDAO("A");
		System.out.println(sal.getNome());
		
	/*	PostoPrenotatoDAO pp = new PostoPrenotatoDAO(2,2,"A");
		System.out.println(pp.getCodicePrenotazione_fk()+" "+pp.getNumeroPosto_fk()+" "+pp.getNomeSala_fk());
		
		PrenotazioneDAO preno = new PrenotazioneDAO();
		preno.setIdSpettacolo_fk(1);
		preno.setImporto(20.0);
		preno.setUsernameCliente_fk("ugofantozzi");
		
		int idPreno = preno.savePrenotazione();
		System.out.println("codice prenotazione: "+idPreno);
		
		PostoPrenotatoDAO posPreno = new PostoPrenotatoDAO();
		posPreno.setCodicePrenotazione_fk(idPreno);
		posPreno.setNumeroPosto_fk(5);
		posPreno.setNomeSala_fk("A");
		
		PostoPrenotatoDAO res = posPreno.savePostiPrenotati();
		System.out.println("risultato postiprenotazione: "+res.getCodicePrenotazione_fk());
		
		PagamentoDAO pag = new PagamentoDAO(1);
		System.out.println(pag.getCodicePrenotazione_fk()+" "+pag.getOra()+" "+pag.getData());
		
		PagamentoDAO pago = new PagamentoDAO();
		pago.setCodicePrenotazione_fk(9);
		pago.setData(new java.sql.Date(System.currentTimeMillis()));
		pago.setOra("10:47:00");
		
		int id = pago.savePagamento();
		System.out.println("id pagamento: "+id);
		*/
		
		/*
		 * List<FilmDAO> films = FilmDAO.getAllSpettacoli(codiceFilm)();
		 * System.out.println("\nfilms"); for(FilmDAO fi : films) {
		 * System.out.println(fi.getTitolo()); }
		 */
		/*
		System.out.println("\nspettacoli");
		List<SpettacoloDAO> spettacoli = SpettacoloDAO.getAllSpettacoli(2);		
		for(SpettacoloDAO film : spettacoli) {
			System.out.println(film.getIdSpettacolo()+ " "+film.getData());
		}*/
		/*
		System.out.println("\nprenotazione");
		List<PrenotazioneDAO> preontazioni = PrenotazioneDAO.getAllPrenotazioni(2);		
		for(PrenotazioneDAO fc : preontazioni) {
			System.out.println(fc.getUsernameCliente_fk()+ " "+fc.getImporto());
		}
		
		System.out.println("\nposti prenotazione");
		List<PostoPrenotatoDAO> pp2 = PostoPrenotatoDAO.getAllPostiPrenotati(14);		
		for(PostoPrenotatoDAO fw : pp2) {
			System.out.println(fw.getNumeroPosto_fk()+ " "+fw.getNomeSala_fk());
		}*/
		
		//PostoPrenotatoDAO pp= new PostoPrenotatoDAO(1,7,"E");

	}

}

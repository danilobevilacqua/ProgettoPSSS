package progettoPSSS.totalCinemaPoint.server.entity;


import java.util.List;

import progettoPSSS.totalCinemaPoint.server.DAO.PostoPrenotatoDAO;

public class PostoPrenotato {
	
	private int codicePrenotazione;
	private int numeroPosto;
	private String nomeSala;
	
	
	public PostoPrenotato() {
		super();
		this.codicePrenotazione = 0;
		this.numeroPosto = 0;
		this.nomeSala = "";
	}
	
	public PostoPrenotato(PostoPrenotatoDAO pp) {
		this.codicePrenotazione = pp.getCodicePrenotazione_fk();
		this.numeroPosto = pp.getNumeroPosto_fk();
		this.nomeSala = pp.getNomeSala_fk();
	}
	
		
	public int getCodicePrenotazione() {
		return codicePrenotazione;
	}
	public void setCodicePrenotazione(int codicePrenotazione) {
		this.codicePrenotazione = codicePrenotazione;
	}
	public int getNumeroPosto() {
		return numeroPosto;
	}
	public void setNumeroPosto(int numeroPosto) {
		this.numeroPosto = numeroPosto;
	}
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	
	
	public static void setPostiPrenotati(List<PostoPrenotato> listaPostiPrenotati, int codice) {
		
		for(PostoPrenotato p : listaPostiPrenotati) {
			p.setCodicePrenotazione(codice);
			PostoPrenotatoDAO ppd = new PostoPrenotatoDAO(p.getCodicePrenotazione(),p.getNumeroPosto(),p.getNomeSala());
		}
		
	}
	
}

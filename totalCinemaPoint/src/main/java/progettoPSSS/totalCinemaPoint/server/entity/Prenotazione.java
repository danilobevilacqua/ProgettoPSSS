package progettoPSSS.totalCinemaPoint.server.entity;

import java.util.ArrayList;
import java.util.List;

import progettoPSSS.totalCinemaPoint.server.DAO.PostoPrenotatoDAO;
import progettoPSSS.totalCinemaPoint.server.DAO.PrenotazioneDAO;
import progettoPSSS.totalCinemaPoint.server.DAO.SpettacoloDAO;

public class Prenotazione {
	
	private int codice;
	private String usernameCliente;
	private int idSpettacolo;
	private List<PostoPrenotato> listaPostiPrenotati;
	
	
	
	public Prenotazione() {
		super();
		this.codice = 0;
		this.usernameCliente = "";
		this.idSpettacolo = 0;
		this.listaPostiPrenotati = new ArrayList<PostoPrenotato>();
	}
	
	public Prenotazione(PrenotazioneDAO p) {
		super();
		this.codice = p.getCodice();
		this.usernameCliente = p.getUsernameCliente_fk();
		this.idSpettacolo = p.getIdSpettacolo_fk();		
		this.listaPostiPrenotati = getPostiPrenotati(p.getCodice());
			
	}
		
	public Prenotazione(String usernameCliente, int idSpettacolo,List<PostoPrenotato> listaPostiPrenotati) {
		PrenotazioneDAO pd = new PrenotazioneDAO(usernameCliente,idSpettacolo);
		int codicePrenotazione= pd.savePrenotazione();
		this.codice=codicePrenotazione;
		PostoPrenotato.setPostiPrenotati(listaPostiPrenotati, codicePrenotazione);
	}

	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getUsernameCliente() {
		return usernameCliente;
	}
	public void setUsernameCliente(String usernameCliente) {
		this.usernameCliente = usernameCliente;
	}
	public int getIdSpettacolo() {
		return idSpettacolo;
	}
	public void setIdSpettacolo(int idSpettacolo) {
		this.idSpettacolo = idSpettacolo;
	}
	public List<PostoPrenotato> getlistaPostiPrenotati() {
		return listaPostiPrenotati;
	}
	public void setlistaPostiPrenotati(List<PostoPrenotato> listaPostiPrenotati) {
		this.listaPostiPrenotati = listaPostiPrenotati;
	}
	

	public List<PostoPrenotato> getPostiPrenotati(int codicePrenotazione){
		PrenotazioneDAO p = new PrenotazioneDAO();
		p.getAllPostiPrenotati(codicePrenotazione);
		List <PostoPrenotato> listaPostiPrenotati= new ArrayList<PostoPrenotato>();		
		for(int i = 0 ; i < p.getListaPostiPrenotati().size();i++) {
			listaPostiPrenotati.add(new PostoPrenotato(p.getListaPostiPrenotati().get(i)));
		}
		return listaPostiPrenotati;
	}
}

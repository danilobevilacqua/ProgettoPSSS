package progettoPSSS.totalCinemaPoint.client.entity;

import java.util.ArrayList;
import java.util.List;


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

	public Prenotazione(int codice, String usernameCliente, int idSpettacolo,
			List<PostoPrenotato> listaPostiPrenotati) {
		super();
		this.codice = codice;
		this.usernameCliente = usernameCliente;
		this.idSpettacolo = idSpettacolo;
		this.listaPostiPrenotati = listaPostiPrenotati;
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

	public List<PostoPrenotato> getListaPostiPrenotati() {
		return listaPostiPrenotati;
	}

	public void setListaPostiPrenotati(List<PostoPrenotato> listaPostiPrenotati) {
		this.listaPostiPrenotati = listaPostiPrenotati;
	}
		
}

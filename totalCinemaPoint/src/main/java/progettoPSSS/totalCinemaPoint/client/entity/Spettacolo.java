package progettoPSSS.totalCinemaPoint.client.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Spettacolo {
	private int idSpettacolo;
	private Date data;
	private String ora;
	private Double prezzo;
	private int idFilm;
	private String nomeSala;
	private List <Prenotazione> listaPrenotazioni;
	
	public Spettacolo() {
		super();
		this.idSpettacolo = 0;
		this.data = new java.sql.Date(System.currentTimeMillis());
		this.ora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		this.prezzo = 0.0;
		this.idFilm = 0;
		this.nomeSala = "";
		this.listaPrenotazioni = new ArrayList<Prenotazione>();
	}

	public Spettacolo(int idSpettacolo, Date data, String ora, Double prezzo, int idFilm, String nomeSala,
			List<Prenotazione> listaPrenotazioni) {
		super();
		this.idSpettacolo = idSpettacolo;
		this.data = data;
		this.ora = ora;
		this.prezzo = prezzo;
		this.idFilm = idFilm;
		this.nomeSala = nomeSala;
		this.listaPrenotazioni = listaPrenotazioni;
	}

	public int getIdSpettacolo() {
		return idSpettacolo;
	}

	public void setIdSpettacolo(int idSpettacolo) {
		this.idSpettacolo = idSpettacolo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public int getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	public List<Prenotazione> getListaPrenotazioni() {
		return listaPrenotazioni;
	}

	public void setListaPrenotazioni(List<Prenotazione> listaPrenotazioni) {
		this.listaPrenotazioni = listaPrenotazioni;
	}
	
}

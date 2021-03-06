package progettoPSSS.totalCinemaPoint.server.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import progettoPSSS.totalCinemaPoint.server.DAO.SpettacoloDAO;


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
		this.ora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());;
		this.prezzo = 0.0;
		this.idFilm = 0;
		this.nomeSala = "";
		this.listaPrenotazioni = new ArrayList<Prenotazione>();
	}
	
	public Spettacolo(SpettacoloDAO s) {
		this.idSpettacolo = s.getIdSpettacolo();
		this.data = s.getData();
		this.ora = s.getOra();
		this.prezzo = s.getPrezzo();
		this.idFilm = s.getIdFilm_fk();
		this.nomeSala = s.getNomeSala_fk();
		this.listaPrenotazioni = new ArrayList<Prenotazione>();
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
	
	public void addListaPrenotazioni() {
		this.setListaPrenotazioni(getPrenotazioni(this.idSpettacolo));
	}
	
	public List<Prenotazione> getPrenotazioni(int codiceSpettacolo){
		
		SpettacoloDAO s = new SpettacoloDAO();
		s.getAllPrenotazioni(codiceSpettacolo);
		List <Prenotazione> listaPrenotazioni= new ArrayList<Prenotazione>();		
		for(int i = 0 ; i < s.getListaPrenotazioni().size();i++) {
			listaPrenotazioni.add(new Prenotazione(s.getListaPrenotazioni().get(i)));
		}
		return listaPrenotazioni;
	}
}

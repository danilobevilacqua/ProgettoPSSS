package progettoPSSS.totalCinemaPoint.server.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import progettoPSSS.totalCinemaPoint.server.DAO.FilmDAO;

@SuppressWarnings("all")
public class Film implements Serializable {
	
	private int idFilm;
	private String titolo;
	private String descrizione;
	private int anno;
	private String regista;
	private byte [] locandina;
	private List <Spettacolo> listaSpettacoli;
	
	public Film() {
		super();
		this.idFilm = 0;
		this.titolo = "";
		this.descrizione = "";
		this.anno = 0;
		this.regista = "";
		this.locandina = null;
		this.listaSpettacoli = new ArrayList<Spettacolo>();
	}
	
	public Film(FilmDAO f) {
		this.idFilm = f.getIdFilm();
		this.titolo = f.getTitolo();
		this.descrizione = f.getDescrizione();
		this.anno = f.getAnno();
		this.regista = f.getRegista();
		this.locandina = f.getLocandina();
		this.listaSpettacoli = new ArrayList<Spettacolo>();
	}

	
	public int getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public String getRegista() {
		return regista;
	}
	public void setRegista(String regista) {
		this.regista = regista;
	}
	public byte[] getLocandina() {
		return locandina;
	}
	public void setLocandina(byte[] locandina) {
		this.locandina = locandina;
	}
	public List<Spettacolo> getListaSpettacoli() {
		return listaSpettacoli;
	}
	public void setListaSpettacoli(List<Spettacolo> listaSpettacoli) {
		this.listaSpettacoli = listaSpettacoli;
	}
	
	public void addListaSpettacoli() {
		this.setListaSpettacoli(getSpettacoli(this.getIdFilm()));
	}
	
	public List<Spettacolo> getSpettacoli(int codiceFilm){
		FilmDAO f = new FilmDAO();
		f.getAllSpettacoli(codiceFilm);
		List <Spettacolo> listaSpettacoli= new ArrayList<Spettacolo>();		
		for(int i = 0 ; i < f.getListaSpettacoli().size();i++) {
			listaSpettacoli.add(new Spettacolo(f.getListaSpettacoli().get(i)));
		}
		return listaSpettacoli;
	}	
}
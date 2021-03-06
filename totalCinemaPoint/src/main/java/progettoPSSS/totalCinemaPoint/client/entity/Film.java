package progettoPSSS.totalCinemaPoint.client.entity;

import java.util.ArrayList;
import java.util.List;

import progettoPSSS.totalCinemaPoint.client.entity.Spettacolo;

public class Film {
	
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
	
	

	public Film(int idFilm, String titolo, String descrizione, int anno, String regista, byte[] locandina, List<Spettacolo> listaSpettacoli) {
		super();
		this.idFilm = idFilm;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.anno = anno;
		this.regista = regista;
		this.locandina = locandina;
		this.listaSpettacoli = listaSpettacoli;
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

}

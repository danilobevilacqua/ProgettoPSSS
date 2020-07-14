package progettoPSSS.totalCinemaPoint.server.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;


@Entity
@Table(name = "Film")
public class FilmDAO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFilm", nullable = false)
	private int idFilm;
	@Column(name = "titolo", nullable = false)
	private String titolo;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "anno", nullable = false)
	private int anno;
	@Column(name = "regista", nullable = false)
	private String regista;
	@Lob
	@Column(name="locandina", columnDefinition = "longblob")
	private byte [] locandina;
	@Transient
	private List<SpettacoloDAO> listaSpettacoli;
	@Column(name = "CInema_idCinema", nullable = false)
	private int idcinema_fk;
	
	public FilmDAO() {
		super();
		this.idFilm = 0;
		this.titolo = "";
		this.descrizione = "";
		this.anno = 0;
		this.regista = "";
		this.locandina = null;
		this.listaSpettacoli = new ArrayList<SpettacoloDAO>();
		this.idcinema_fk = 0;
	}
	
	public FilmDAO(int idFilm) {
		Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();		 
	    FilmDAO f = (FilmDAO) session.get(FilmDAO.class, idFilm);		    
	    session.close();
	    this.idFilm = f.getIdFilm();
		this.titolo = f.getTitolo();
		this.descrizione = f.getDescrizione();
		this.anno = f.getAnno();
		this.regista = f.getRegista();
		this.locandina = f.getLocandina();
		this.idcinema_fk = f.getIdcinema_fk();
	}
	/*
	public FilmDAO(int idFilm, String titolo, String descrizione, int anno, String regista, byte[] locandina) {
		super();
		this.idFilm = idFilm;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.anno = anno;
		this.regista = regista;
		this.locandina = locandina;
	}*/

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
	
	public List<SpettacoloDAO> getListaSpettacoli() {
		return listaSpettacoli;
	}

	public void setListaSpettacoli(List<SpettacoloDAO> listaSpettacoli) {
		this.listaSpettacoli = listaSpettacoli;
	}

	public int getIdcinema_fk() {
		return idcinema_fk;
	}

	public void setIdcinema_fk(int idcinema_fk) {
		this.idcinema_fk = idcinema_fk;
	}

	public List<SpettacoloDAO> getAllSpettacoli(int codiceFilm) {
	    Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();
	 
	    @SuppressWarnings("unchecked")
	    List<SpettacoloDAO> spettacoli = (List<SpettacoloDAO>) session.createQuery("FROM SpettacoloDAO where Film_idFilm = :idscelto").setParameter("idscelto", codiceFilm).list(); 
	 
	    session.getTransaction().commit();
	    session.close();
	    
	    this.listaSpettacoli=spettacoli;	    		
	    return spettacoli;
	  }	

}

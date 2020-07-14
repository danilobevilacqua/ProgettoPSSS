package progettoPSSS.totalCinemaPoint.server.DAO;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;

@Entity
@Table(name = "Spettacoli")
public class SpettacoloDAO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSpettacolo", nullable = false)
	private int idSpettacolo;
	@Column(name = "data", nullable = false)
	private Date data;
	@Column(name = "ora", nullable = false)
	private String ora;
	@Column(name = "prezzo", nullable = false)
	private Double prezzo;
	@Column(name = "Film_idFilm", nullable = false)
	private int idFilm_fk;
	@Column(name = "Sale_nome", nullable = false)
	private String nomeSala_fk;
	@Transient
	private List<PrenotazioneDAO> listaPrenotazioni;
	
	public SpettacoloDAO() {
		super();
		this.idSpettacolo = 0;
		this.data = new java.sql.Date(System.currentTimeMillis());
		this.ora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		this.prezzo = 0.0;
		this.idFilm_fk = 0;
		this.nomeSala_fk = "";
		this.listaPrenotazioni= new ArrayList<PrenotazioneDAO>();
	}
	
	public SpettacoloDAO(int idSpettacolo) {
		Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();		 
	    SpettacoloDAO s = (SpettacoloDAO) session.get(SpettacoloDAO.class, idSpettacolo);		    
	    session.close();
		this.idSpettacolo = s.getIdSpettacolo();
		this.data = s.getData();
		this.ora = s.getOra();
		this.prezzo = s.getPrezzo();
		this.idFilm_fk = s.getIdFilm_fk();
		this.nomeSala_fk = s.getNomeSala_fk();
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
	public int getIdFilm_fk() {
		return idFilm_fk;
	}
	public void setIdFilm_fk(int idFilm_fk) {
		this.idFilm_fk = idFilm_fk;
	}
	public String getNomeSala_fk() {
		return nomeSala_fk;
	}
	public void setNomeSala_fk(String nomeSala_fk) {
		this.nomeSala_fk = nomeSala_fk;
	}
	
	public List<PrenotazioneDAO> getListaPrenotazioni() {
		return listaPrenotazioni;
	}

	public void setListaPrenotazioni(List<PrenotazioneDAO> listaPrenotazioni) {
		this.listaPrenotazioni = listaPrenotazioni;
	}

	public List<PrenotazioneDAO> getAllPrenotazioni(int idSpettacolo) {
	    Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();	 
	    @SuppressWarnings("unchecked")
	    List<PrenotazioneDAO> prenotazioni = (List<PrenotazioneDAO>) session.createQuery("FROM PrenotazioneDAO where Spettacoli_idSpettacolo = :idscelto").setParameter("idscelto", idSpettacolo).list();
	 
	    session.getTransaction().commit();
	    session.close();
	   this.listaPrenotazioni = prenotazioni;
	    return prenotazioni;
	  }
}

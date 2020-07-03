package progettoPSSS.totalCinemaPoint.server.DAO;

import java.util.ArrayList;
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
@Table(name = "Prenotazioni")
public class PrenotazioneDAO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codice", nullable = false)
	private int codice;
	@Column(name = "Clienti_username", nullable = false)
	private String usernameCliente_fk;
	@Column(name = "Spettacoli_idSpettacolo", nullable = false)
	private int idSpettacolo_fk;
	@Transient
	private List<PostoPrenotatoDAO> listaPostiPrenotati;
	public PrenotazioneDAO() {
		super();
		this.codice = 0;
		this.usernameCliente_fk = "";
		this.idSpettacolo_fk = 0;
		this.listaPostiPrenotati = new ArrayList<PostoPrenotatoDAO>();
	}
	
	public PrenotazioneDAO(int codice) {

		Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();		 
	    PrenotazioneDAO p = (PrenotazioneDAO) session.get(PrenotazioneDAO.class, codice);		    
	    session.close();
	    
		this.codice = p.getCodice();
		this.usernameCliente_fk = p.getUsernameCliente_fk();
		this.idSpettacolo_fk = p.getIdSpettacolo_fk();
	}
	
	public PrenotazioneDAO(String usernameCliente_fk, int idSpettacolo_fk) {
		super();
		this.usernameCliente_fk = usernameCliente_fk;
		this.idSpettacolo_fk = idSpettacolo_fk;
	}
	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getUsernameCliente_fk() {
		return usernameCliente_fk;
	}
	public void setUsernameCliente_fk(String usernameCliente_fk) {
		this.usernameCliente_fk = usernameCliente_fk;
	}
	public int getIdSpettacolo_fk() {
		return idSpettacolo_fk;
	}
	public void setIdSpettacolo_fk(int idSpettacolo_fk) {
		this.idSpettacolo_fk = idSpettacolo_fk;
	}
	
	public List<PostoPrenotatoDAO> getListaPostiPrenotati() {
		return listaPostiPrenotati;
	}

	public void setListaPostiPrenotati(List<PostoPrenotatoDAO> listaPostiPrenotati) {
		this.listaPostiPrenotati = listaPostiPrenotati;
	}

	public int savePrenotazione() {
		Session session = HibernateConnectionManager.getSessionFactory().openSession();
		  session.beginTransaction();
		 
		  int id = (Integer) session.save(this);
		  session.getTransaction().commit();
		  session.close();
		  return id;
	}
	
	public List<PostoPrenotatoDAO> getAllPostiPrenotati(int idPrenotazione) {
	    Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();	 
	    @SuppressWarnings("unchecked")
	    List<PostoPrenotatoDAO> posti = (List<PostoPrenotatoDAO>) session.createQuery("FROM PostoPrenotatoDAO where Prenotazioni_codice = :idscelto").setParameter("idscelto", idPrenotazione).list();	 
	    session.getTransaction().commit();
	    session.close();
	    this.listaPostiPrenotati = posti;
	    return posti;
	  }
	

}

package progettoPSSS.totalCinemaPoint.server.DAO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

@Entity
@Table(name = "Prenotazioni")
public class PrenotazioneDAO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codice", nullable = false)
	private int codice;
	@Column(name = "importo", nullable = false)
	private Double importo;
	@Column(name = "Clienti_username", nullable = false)
	private String usernameCliente_fk;
	@Column(name = "Spettacoli_idSpettacolo", nullable = false)
	private int idSpettacolo_fk;
	
	public PrenotazioneDAO() {
		super();
		this.codice = 0;
		this.importo = 0.0;
		this.usernameCliente_fk = "";
		this.idSpettacolo_fk = 0;
	}
	
	public PrenotazioneDAO(int codice) {

		Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();		 
	    PrenotazioneDAO p = (PrenotazioneDAO) session.get(PrenotazioneDAO.class, codice);		    
	    session.close();
	    
		this.codice = p.getCodice();
		this.importo = p.getImporto();
		this.usernameCliente_fk = p.getUsernameCliente_fk();
		this.idSpettacolo_fk = p.getIdSpettacolo_fk();
	}
	
	public PrenotazioneDAO(Double importo, String usernameCliente_fk, int idSpettacolo_fk) {
		super();
		this.importo = importo;
		this.usernameCliente_fk = usernameCliente_fk;
		this.idSpettacolo_fk = idSpettacolo_fk;
	}
	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public Double getImporto() {
		return importo;
	}
	public void setImporto(Double importo) {
		this.importo = importo;
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
	
	public int savePrenotazione() {
		Session session = HibernateConnectionManager.getSessionFactory().openSession();
		  session.beginTransaction();
		 
		  int id = (Integer) session.save(this);
		  session.getTransaction().commit();
		  session.close();
		  return id;
	}
	
	public static List<PostoPrenotatoDAO> getAllPostiPrenotati(int idPrenotazione) {
	    Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();
	 
	    @SuppressWarnings("unchecked")
	    List<PostoPrenotatoDAO> posti = (List<PostoPrenotatoDAO>) session.createQuery("FROM PostoPrenotatoDAO where Prenotazioni_codice = :idscelto").setParameter("idscelto", idPrenotazione).list();
	 
	    session.getTransaction().commit();
	    session.close();
	    return posti;
	  }
	

}

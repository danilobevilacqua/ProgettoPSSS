package progettoPSSS.totalCinemaPoint.server.DAO;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.query.Query;


@Entity
@Table(name = "CLIENTI")
public class ClienteDAO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "cognome", nullable = false)
	private String cognome;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "numeroCartaDiCredito", nullable = false)
	private String numeroCartaCredito;
	@Column(name = "email", nullable = false)
	private String eMail;
	@Column(name = "telefono")
	private String telefono;
	
	
	
	public ClienteDAO() {
		super();
		this.username = "";
		this.nome = "";
		this.cognome = "";		
		this.password = "";
		this.numeroCartaCredito = "";
		this.eMail = "";
		this.telefono = "";
	}
	
	public ClienteDAO(String username) {
		Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();		 
	    ClienteDAO d = (ClienteDAO) session.get(ClienteDAO.class, username);		    
	    session.close();
		this.username = d.getUsername();
		this.nome = d.getNome();
		this.cognome = d.getCognome();		
		this.password = d.getPassword();
		this.numeroCartaCredito = d.getNumeroCartaCredito();
		this.eMail = d.geteMail();
		this.telefono = d.getTelefono();
	}
	
	public ClienteDAO(String username, String password) {
		Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();		 
	    
	    @SuppressWarnings("all")
	    Query query = session.createQuery("from ClienteDAO where username = :usernameScelto and password = :passwordScelta");
	    query.setParameter("usernameScelto", username);
        query.setParameter("passwordScelta", password);	    
        ClienteDAO d = (ClienteDAO) query.list().get(0);
	    session.getTransaction().commit();
	    session.close();	    
		
	    this.username = d.getUsername();
		this.nome = d.getNome();
		this.cognome = d.getCognome();		
		this.password = d.getPassword();
		this.numeroCartaCredito = d.getNumeroCartaCredito();
		this.eMail = d.geteMail();
		this.telefono = d.getTelefono();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumeroCartaCredito() {
		return numeroCartaCredito;
	}

	public void setNumeroCartaCredito(String numeroCartaCredito) {
		this.numeroCartaCredito = numeroCartaCredito;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	  

}

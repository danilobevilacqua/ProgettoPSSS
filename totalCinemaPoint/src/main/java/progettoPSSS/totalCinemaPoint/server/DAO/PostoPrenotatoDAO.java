package progettoPSSS.totalCinemaPoint.server.DAO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

@SuppressWarnings("all")
@Entity
@Table(name = "PostiPrenotati")
public class PostoPrenotatoDAO implements Serializable{
	
	@Id
	@Column(name = "Prenotazioni_codice", nullable = false)
	private int codicePrenotazione_fk;
	@Id
	@Column(name = "Posti_numero", nullable = false)
	private int numeroPosto_fk;
	@Id
	@Column(name = "Posti_Sale_nome", nullable = false)
	private String nomeSala_fk;
	@Column(name = "tipoOccupazione", nullable = false)
	private String tipo;
	
	public PostoPrenotatoDAO() {
		super();
		this.codicePrenotazione_fk = 0;
		this.numeroPosto_fk = 0;
		this.nomeSala_fk = "";
		this.tipo="";
	}
	
	public PostoPrenotatoDAO(int codicePrenotazione_fk, int numeroPosto_fk, String nomeSala_fk,String tipo) {
		this.codicePrenotazione_fk = codicePrenotazione_fk;
		this.numeroPosto_fk = numeroPosto_fk;
		this.nomeSala_fk = nomeSala_fk;
		this.tipo=tipo;
		savePostiPrenotati();
	}
	
	public int getCodicePrenotazione_fk() {
		return codicePrenotazione_fk;
	}
	public void setCodicePrenotazione_fk(int codicePrenotazione_fk) {
		this.codicePrenotazione_fk = codicePrenotazione_fk;
	}
	public int getNumeroPosto_fk() {
		return numeroPosto_fk;
	}
	public void setNumeroPosto_fk(int numeroPosto_fk) {
		this.numeroPosto_fk = numeroPosto_fk;
	}
	public String getNomeSala_fk() {
		return nomeSala_fk;
	}
	public void setNomeSala_fk(String nomeSala_fk) {
		this.nomeSala_fk = nomeSala_fk;
	}	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public PostoPrenotatoDAO savePostiPrenotati() {
		  Session session = HibernateConnectionManager.getSessionFactory().openSession();
		  session.beginTransaction();
		 
		  PostoPrenotatoDAO ids = (PostoPrenotatoDAO) session.save(this);
		  session.getTransaction().commit();
		  session.close();
		  return ids;
	}	

}

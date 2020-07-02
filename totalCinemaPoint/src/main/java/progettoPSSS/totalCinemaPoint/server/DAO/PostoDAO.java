package progettoPSSS.totalCinemaPoint.server.DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.query.Query;


@Entity
@Table(name = "Posti")
public class PostoDAO implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero", nullable = false)
	private int numero;
	@Id
	@Column(name = "Sale_nome", nullable = false)
	private String nomeSala_fk;
	
	public PostoDAO() {
		super();
		this.numero = 0;
		this.nomeSala_fk = "";
	}
	
	public PostoDAO(int numero, String nomeSala_fk) {
		
	    Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();
	 
	    @SuppressWarnings("unchecked")
	    Query query = session.createQuery("from PostoDAO where numero = :numeroScelto and Sale_nome = :nomeSalaScelta");
	    query.setParameter("numeroScelto", numero);
        query.setParameter("nomeSalaScelta", nomeSala_fk);
	    
	    PostoDAO p = (PostoDAO) query.list().get(0);
	    session.getTransaction().commit();
	    session.close();
		
	    this.numero = p.getNumero();
		this.nomeSala_fk = p.getNomeSala_fk();
	}	
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNomeSala_fk() {
		return nomeSala_fk;
	}
	public void setNomeSala_fk(String nomeSala_fk) {
		this.nomeSala_fk = nomeSala_fk;
	}
	
	

}

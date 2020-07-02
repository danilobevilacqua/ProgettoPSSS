package progettoPSSS.totalCinemaPoint.server.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

@Entity
@Table(name = "Sale")
public class SalaDAO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nome", nullable = false)
	private String nome;

	public SalaDAO() {
		super();
		this.nome = "";
	}
	
	public SalaDAO(String nome) {
		Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();		 
	    SalaDAO s = (SalaDAO) session.get(SalaDAO.class, nome);		    
	    session.close();
	    
		this.nome = s.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}



package progettoPSSS.totalCinemaPoint.server.DAO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

@Entity
@Table(name = "Pagamenti")
public class PagamentoDAO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPagamento", nullable = false)
	private int idPagamento;
	@Column(name = "data", nullable = false)
	private Date data;
	@Column(name = "ora", nullable = false)
	private String ora;
	@Column(name = "Prenotazioni_codice", nullable = false)
	private int codicePrenotazione_fk;
	
	public PagamentoDAO() {
		super();
		this.idPagamento = 0;
		this.data = new java.sql.Date(System.currentTimeMillis());
		this.ora = "";
		this.codicePrenotazione_fk = 0;
	}
	
	public PagamentoDAO(int idPagamento) {
		Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();		 
	    PagamentoDAO p = (PagamentoDAO) session.get(PagamentoDAO.class, idPagamento);		    
	    session.close();
		this.idPagamento = p.getIdPagamento();
		this.data = p.getData();
		this.ora = p.getOra();
		this.codicePrenotazione_fk = p.getCodicePrenotazione_fk();
	}
	
	public PagamentoDAO(int idPagamento, Date data, String ora, int codicePrenotazione_fk) {
		super();
		this.idPagamento = idPagamento;
		this.data = data;
		this.ora = ora;
		this.codicePrenotazione_fk = codicePrenotazione_fk;
		savePagamento();
	}
	
	public int getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
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
	public int getCodicePrenotazione_fk() {
		return codicePrenotazione_fk;
	}
	public void setCodicePrenotazione_fk(int codicePrenotazione_fk) {
		this.codicePrenotazione_fk = codicePrenotazione_fk;
	}
	
	public int savePagamento() {
		Session session = HibernateConnectionManager.getSessionFactory().openSession();
		  session.beginTransaction();
		 
		  int id = (Integer) session.save(this);
		  session.getTransaction().commit();
		  session.close();
		  return id;
	}		

}

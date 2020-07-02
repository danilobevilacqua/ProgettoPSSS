package progettoPSSS.totalCinemaPoint.server.entity;

import java.sql.Date;

import javax.persistence.Column;

import progettoPSSS.totalCinemaPoint.server.DAO.PagamentoDAO;

public class Pagamento {
	
	private int idPagamento;
	private Date data;
	private String ora;
	private int codicePrenotazione;
	
	
	public Pagamento() {
		super();
		this.idPagamento = 0;
		this.data = new java.sql.Date(System.currentTimeMillis());;
		this.ora = "";
		this.codicePrenotazione = 0;
	}
	
	public Pagamento(int idPagamento, Date data, String ora, int codicePrenotazione) {
		super();
		this.idPagamento = idPagamento;
		this.data = data;
		this.ora = ora;
		this.codicePrenotazione = codicePrenotazione;
		PagamentoDAO pagamento = new PagamentoDAO(idPagamento,data,ora,codicePrenotazione);		
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
	public int getCodicePrenotazione() {
		return codicePrenotazione;
	}
	public void setCodicePrenotazione(int codicePrenotazione) {
		this.codicePrenotazione = codicePrenotazione;
	}
	
	
	
	

}

package progettoPSSS.totalCinemaPoint.server.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import progettoPSSS.totalCinemaPoint.server.DAO.PagamentoDAO;

public class Pagamento {
	
	private int idPagamento;
	private Date data;
	private String ora;
	private Double importo;
	private int codicePrenotazione;
	
	
	public Pagamento() {
		super();
		this.idPagamento = 0;
		this.data = new java.sql.Date(System.currentTimeMillis());
		this.ora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		this.importo = 0.0;
		this.codicePrenotazione = 0;
	}
	
	public Pagamento(Date data, String ora, Double importo, int codicePrenotazione) {
		this.data = data;
		this.ora = ora;
		this.importo = importo;
		this.codicePrenotazione = codicePrenotazione;
		PagamentoDAO pagamento = new PagamentoDAO(data,ora,importo,codicePrenotazione);		
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
	public Double getImporto() {
		return importo;
	}
	public void setImporto(Double importo) {
		this.importo = importo;
	}
	public int getCodicePrenotazione() {
		return codicePrenotazione;
	}
	public void setCodicePrenotazione(int codicePrenotazione) {
		this.codicePrenotazione = codicePrenotazione;
	}
	
}

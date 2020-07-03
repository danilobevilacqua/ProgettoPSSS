package progettoPSSS.totalCinemaPoint.client.entity;

public class PostoPrenotato {
	private int codicePrenotazione;
	private int numeroPosto;
	private String nomeSala;
	private String tipo;
	
	public PostoPrenotato() {
		super();
		this.codicePrenotazione = 0;
		this.numeroPosto = 0;
		this.nomeSala = "";
		this.tipo = "";
	}

	public PostoPrenotato(int codicePrenotazione, int numeroPosto, String nomeSala, String tipo) {
		super();
		this.codicePrenotazione = codicePrenotazione;
		this.numeroPosto = numeroPosto;
		this.nomeSala = nomeSala;
		this.tipo = tipo;
	}

	public int getCodicePrenotazione() {
		return codicePrenotazione;
	}

	public void setCodicePrenotazione(int codicePrenotazione) {
		this.codicePrenotazione = codicePrenotazione;
	}

	public int getNumeroPosto() {
		return numeroPosto;
	}

	public void setNumeroPosto(int numeroPosto) {
		this.numeroPosto = numeroPosto;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}

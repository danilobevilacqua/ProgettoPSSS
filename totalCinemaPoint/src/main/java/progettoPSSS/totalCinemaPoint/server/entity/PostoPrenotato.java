package progettoPSSS.totalCinemaPoint.server.entity;



import progettoPSSS.totalCinemaPoint.server.DAO.PostoPrenotatoDAO;
@SuppressWarnings("all")
public class PostoPrenotato {

	private int codicePrenotazione;
	private int numeroPosto;
	private String nomeSala;
	private String tipo;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeSala == null) ? 0 : nomeSala.hashCode());
		result = prime * result + numeroPosto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostoPrenotato other = (PostoPrenotato) obj;
		if (nomeSala == null) {
			if (other.nomeSala != null)
				return false;
		} else if (!nomeSala.equals(other.nomeSala))
			return false;
		if (numeroPosto != other.numeroPosto)
			return false;
		return true;
	}

	public PostoPrenotato() {
		super();
		this.codicePrenotazione = 0;
		this.numeroPosto = 0;
		this.nomeSala = "";
		this.tipo = "";
	}

	public PostoPrenotato(PostoPrenotatoDAO pp) {
		this.codicePrenotazione = pp.getCodicePrenotazione_fk();
		this.numeroPosto = pp.getNumeroPosto_fk();
		this.nomeSala = pp.getNomeSala_fk();
		this.tipo = pp.getTipo();
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

	public void setPostoPrenotato() {
		PostoPrenotatoDAO ppd = new PostoPrenotatoDAO(this.getCodicePrenotazione(),this.getNumeroPosto(),this.getNomeSala(),this.getTipo());
	}

}

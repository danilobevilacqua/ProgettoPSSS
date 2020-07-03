package progettoPSSS.totalCinemaPoint.client.entity;

public class Cliente {
	private String username;
	private String nome;
	private String cognome;
	private String password;
	private String numeroCartaCredito;
	private String eMail;
	private String telefono;
	
	public Cliente() {
		super();
		this.username = "";
		this.nome = "";
		this.cognome = "";
		this.password = "";
		this.numeroCartaCredito = "";
		this.eMail = "";
		this.telefono = "";
	}
	
	public Cliente(String username, String nome, String cognome, String password, String numeroCartaCredito, String eMail, String telefono) {
		super();
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.numeroCartaCredito = numeroCartaCredito;
		this.eMail = eMail;
		this.telefono = telefono;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

package progettoPSSS.totalCinemaPoint.server.entity;

import progettoPSSS.totalCinemaPoint.server.DAO.ClienteDAO;

public class Cliente {	

	private String username;
	private String nome;
	private String cognome;
	private String password;
	private String numeroCartaCredito;
	private String eMail;
	private String telefono;
	
	
	public Cliente(String username, String password) {
		
		ClienteDAO d = new ClienteDAO(username,password);
		
		this.username = d.getUsername();
		this.nome = d.getNome();
		this.cognome = d.getCognome();
		this.password = d.getPassword();
		this.numeroCartaCredito = d.getNumeroCartaCredito();
		this.eMail = d.geteMail();
		this.telefono = d.getTelefono();
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

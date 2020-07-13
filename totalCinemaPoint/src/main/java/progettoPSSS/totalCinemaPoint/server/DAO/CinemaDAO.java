package progettoPSSS.totalCinemaPoint.server.DAO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Session;

public class CinemaDAO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCinema", nullable = false)
	private int idCinema;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "indirizzo", nullable = false)
	private String indirizzo;
	@Column(name = "telefono", nullable = false)
	private String telefono;
	
	List<FilmDAO> listaFilms;
	
	public CinemaDAO() {		
		this.listaFilms = getAllFilms();
	}
/*
	public CinemaDAO(List<FilmDAO> listaFilms) {
		super();
		this.listaFilms = listaFilms;
	}*/
	
	

	public List<FilmDAO> getListaFilms() {
		return listaFilms;
	}

	public int getIdCinema() {
		return idCinema;
	}



	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getIndirizzo() {
		return indirizzo;
	}



	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public void setListaFilms(List<FilmDAO> listaFilms) {
		this.listaFilms = listaFilms;
	}
	
	public List<FilmDAO> getAllFilms() {
	    Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();
	 
	    @SuppressWarnings("unchecked")
	    List<FilmDAO> films = (List<FilmDAO>) session.createQuery("FROM FilmDAO").list();
	 
	    session.getTransaction().commit();
	    session.close();
	    return films;
	  }
	

}

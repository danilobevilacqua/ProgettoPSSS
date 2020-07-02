package progettoPSSS.totalCinemaPoint.server.DAO;

import java.util.List;

import org.hibernate.Session;

public class CinemaDAO {
	
	List<FilmDAO> listaFilms;
	
	
	public CinemaDAO() {		
		this.listaFilms = getAllFilms();
	}

	public CinemaDAO(List<FilmDAO> listaFilms) {
		super();
		this.listaFilms = listaFilms;
	}

	public List<FilmDAO> getListaFilms() {
		return listaFilms;
	}

	public void setListaFilms(List<FilmDAO> listaFilms) {
		this.listaFilms = listaFilms;
	}
	
	public static List<FilmDAO> getAllFilms() {
	    Session session = HibernateConnectionManager.getSessionFactory().openSession();
	    session.beginTransaction();
	 
	    @SuppressWarnings("unchecked")
	    List<FilmDAO> films = (List<FilmDAO>) session.createQuery("FROM FilmDAO").list();
	 
	    session.getTransaction().commit();
	    session.close();
	    return films;
	  }
	

}

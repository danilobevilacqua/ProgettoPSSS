package progettoPSSS.totalCinemaPoint.server.entity;

import java.util.ArrayList;
import java.util.List;

import progettoPSSS.totalCinemaPoint.server.DAO.CinemaDAO;


public class Cinema {
	
	private List<Film> listaFilms;
	
	public Cinema() {
		super();
		this.listaFilms = getFilms();
	}
	
	public Cinema(List<Film> listaFilms) {
		super();
		this.listaFilms = listaFilms;
	}

	public List<Film> getListaFilms() {
		return listaFilms;
	}

	public void setListaFilms(List<Film> listaFilms) {
		this.listaFilms = listaFilms;
	}
	
	public static List<Film> getFilms(){		
		CinemaDAO  c = new CinemaDAO();
		List <Film> listaFilms= new ArrayList<Film>();		
		for(int i = 0 ; i < c.getListaFilms().size();i++) {
			listaFilms.add(new Film(c.getListaFilms().get(i)));
		}
		return listaFilms;
	}

}

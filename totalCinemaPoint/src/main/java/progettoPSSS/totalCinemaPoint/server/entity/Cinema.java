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

		List <Film> listaFilms= new ArrayList<Film>();		
		for(int i = 0 ; i < CinemaDAO.getAllFilms().size();i++) {
			listaFilms.add(new Film(CinemaDAO.getAllFilms().get(i)));
		}
		return listaFilms;
	}

}

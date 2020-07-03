package progettoPSSS.totalCinemaPoint.server.controller;

import java.rmi.RemoteException;

import progettoPSSS.totalCinemaPoint.interfacce.ServizioCliente;
import progettoPSSS.totalCinemaPoint.server.entity.Film;

public class Prova {

	public static void main(String[] args) {

		ServizioCliente sc = new ControllerCliente();
		try {
			sc.logIn("walterwhite", "walter");
			System.out.println("Log-in effettuato correttamente!");
			
			for(Film f : sc.getFilm())
				System.out.println(f.getTitolo() + f.getAnno());
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		}
		
	}

}

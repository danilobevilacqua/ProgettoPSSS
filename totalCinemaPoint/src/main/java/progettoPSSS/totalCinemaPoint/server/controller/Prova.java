package progettoPSSS.totalCinemaPoint.server.controller;

import java.rmi.RemoteException;

import progettoPSSS.totalCinemaPoint.interfacce.ServizioCliente;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServizioCliente sc = new ControllerCliente();
		try {
			sc.logIn("walterwhite", "walter");
			System.out.println("Log in effettuato!");
			
			for(String s : sc.getFilmTitles())
				System.out.println(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}

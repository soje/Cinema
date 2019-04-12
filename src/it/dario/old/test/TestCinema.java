package it.dario.old.test;

import java.io.*;

import it.dario.old.cinema.*;

public class TestCinema {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		File f = new File("Cinema.dat");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		Cinema prova = (Cinema) in.readObject();
		
		System.out.println(prova.getClienti());
		System.out.println(prova.getGestore());
		System.out.println(prova.getSpettacoli());
		System.out.println(prova.getSpettacoli().get(0));
		System.out.println(prova.getPrenotazioni());
	}
}

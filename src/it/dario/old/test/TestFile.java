package it.dario.old.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import it.dario.old.cinema.Cinema;

public class TestFile {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		File f = new File("Cinema.dat");
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		Cinema nuovo = (Cinema) in.readObject();
		
		System.out.println(nuovo.getClienti());
		System.out.println(nuovo.getGestore());
	}

}

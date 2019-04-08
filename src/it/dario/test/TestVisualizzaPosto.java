package it.dario.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import it.dario.cinema.*;
import it.dario.gui.ValidaPosto;
import it.dario.gui.VisualizzaPosto;

public class TestVisualizzaPosto {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
	
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Cinema.dat"));
		Cinema x = (Cinema) in.readObject();
		
		//System.out.println(x.getSpettacoli().get(0));
		
		VisualizzaPosto win = new VisualizzaPosto(x.getSpettacoli().get(0));
		
		
	}
}

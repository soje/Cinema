package it.dario.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import it.dario.cinema.*;
import it.dario.gui.*;

public class TestGui {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		
		/*Film ironman = new Film("ironman", "film supereroistico", new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		Sala sala= new Sala(7);
		
		String info = "film videogiocoso";
		
		Film pac = new Film("Pac-man", info, new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		Sala sala1= new Sala(1);
		
		Film buono = new Film("Il buono", "film western", new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		Sala sala2= new Sala(4);
		
		Film brutto = new Film("Il brutto", "film americano", new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		Sala sala3= new Sala(10);
		
		Film cattivo = new Film("Il cattivo", "film cinese", new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		Sala sala4= new Sala(2);
		
		Film nuovo = new Film("Il nuovo mondo", "film scifi", new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		Sala sala5= new Sala(8);
		
		Film hobbit = new Film("lo hobbit", "film fantasy", new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		Sala sala6= new Sala(5);
		
		Film casa = new Film("la casa", "film horror", new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		Sala sala7= new Sala(3);
		
		Film topolino = new Film("topolino", "film cartoon", new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		Sala sala8= new Sala(25);
		
		Film sventre = new Film("Sventrato", "film splatter", new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		Sala sala9= new Sala(85);
		
		Film illusione = new Film("illusionist 1", "film magico", new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		Sala sala10= new Sala(42);
		
		Film illusione1 = new Film("illusionist 2", "film magico", new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		illusione1.setIncasso(25.20);
		Sala sala11= new Sala(43);
		
		Film illusione2 = new Film("illusionist 3", "film magico", new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 5), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 15));
		illusione2.setIncasso(148.36);
		Sala sala12= new Sala(44);
		
		Spettacolo s = new Spettacolo(sala, ironman, 7.50, 23, 15);
		Spettacolo s1 = new Spettacolo(sala1, pac, 7.50, 23, 30);
		Spettacolo s2 = new Spettacolo(sala2, buono, 7.50, 23, 45);
		Spettacolo s3 = new Spettacolo(sala3, brutto, 7.50, 23, 45);
		Spettacolo s4 = new Spettacolo(sala4, cattivo, 7.50, 23, 45);
		s4.getSala().setPostiDisponibili(2);
		Spettacolo s5 = new Spettacolo(sala5, nuovo, 7.50, 23, 45);
		Spettacolo s6 = new Spettacolo(sala6, hobbit, 7.50, 23, 45);
		s6.getSala().setPostiDisponibili(57);
		Spettacolo s7 = new Spettacolo(sala8, topolino, 7.50, 23, 45);
		Spettacolo s8 = new Spettacolo(sala9, sventre, 7.50, 23, 45);
		s8.getSala().setPostiDisponibili(25);
		Spettacolo s9 = new Spettacolo(sala10, illusione, 7.50, 23, 58);
		Spettacolo s10 = new Spettacolo(sala7, casa, 7.50, 23, 45);
		Spettacolo s11 = new Spettacolo(sala11, illusione1, 7.50, 23, 45);
		Spettacolo s12 = new Spettacolo(sala12, illusione2, 7.50, 23, 45);
		
		Cinema prova = new Cinema();
		
		prova.addSpettacolo(s);
		prova.addSpettacolo(s1);
		prova.addSpettacolo(s2);
		prova.addSpettacolo(s3);
		prova.addSpettacolo(s4);
		prova.addSpettacolo(s5);
		prova.addSpettacolo(s6);
		prova.addSpettacolo(s7);
		prova.addSpettacolo(s8);
		prova.addSpettacolo(s9);
		prova.addSpettacolo(s10);
		prova.addSpettacolo(s11);
		prova.addSpettacolo(s12);
		prova.addSpettacolo(s10);
		prova.addSpettacolo(s10);
		prova.addSpettacolo(s11);
		prova.addSpettacolo(s12);
		prova.setGestore(new Gestore("admin","password"));*/
		
		/*File f = new File("Cinema.dat");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(prova);
		out.close();*/
		
		Login log = new Login();
		
	}
}

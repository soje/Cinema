package it.dario.old.test;

import it.dario.old.cinema.Film;

public class TestFilm {
	public static void main(String[] args) {
		
	Film rambo = new Film();
	Film avangers = new Film("Avangers", "Film supereroe");
	
	System.out.println(avangers.getTitolo());
	System.out.println(avangers.getInfo());
	System.out.println(avangers.getIncasso());

	rambo.setTitolo("Ero tuo padre");
	System.out.println(rambo.getTitolo());
	rambo.setInfo("Film mafioso");
	System.out.println(rambo.getInfo());
	rambo.setIncasso(25.2);
	System.out.println(rambo.getIncasso());

	System.out.println(rambo);
	System.out.println(rambo.equals(avangers));
	Film ramboClone= rambo.clone();
	System.out.println(ramboClone);
	}
}

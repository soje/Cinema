package it.dario.cinema;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Classe che gestisce il concetto di uno sconto da poter applicare al prezzo di un biglietto
 * questo sceglie tar tre tipi di sconti preimpostati
 * 
 * @author Dario
 *
 */
public class Sconto implements Cloneable, Serializable{
	
	/**
	 * Applica al prezzo del biglietto la politica di sconto numero 1
	 * 
	 * @param prezzo
	 * @return prezzo detratto dello sconto applicato
	 */
	public double applicaPoliticauno(double prezzo){
		double perc = prezzo*POLITICA1/100;
		prezzo-=perc;
		return prezzo;
	}
	
	/**
	 * Applica al prezzo del biglietto la politica di sconto numero 2
	 * 
	 * @param prezzo
	 * @return prezzo detratto dello sconto applicato
	 */
	public double applicaPoliticadue(double prezzo){
		ora = new GregorianCalendar();
		if(ora.getTime().getDay() == Calendar.WEDNESDAY){
			double perc = prezzo*POLITICA2/100;
			prezzo-=perc;
		} return prezzo;
	}
	/**
	 * Applica al prezzo del biglietto la politica di sconto numero 3
	 * 
	 * @param prezzo
	 * @return prezzo detratto dello sconto applicato
	 */
	public double applicaPoliticatre(double prezzo){
		ora = new GregorianCalendar();
		if(ora.getTime().getHours() < 18){
			double perc = prezzo*POLITICA3/100;
			prezzo-=perc;
		} return prezzo;
	}
	
	/**
	 * Metodo che compara tutte e 3 le politiche di sconto per controllare se esse siano attive su di uno
	 * spettacolo, se siano applicabili su una determinata fascia e tra le 3 calcola il prezzo più agevolato
	 * da applicare
	 * 
	 * @param s
	 * @param fascia
	 * @return prezzo finale del biglietto
	 */
	public double calcolaSconto(Spettacolo s, boolean fascia){
		double tmp=0.0;
		if(s.isPolitica1() && fascia == true){ tmp = applicaPoliticauno(s.getPrezzo()); }
		if(s.isPolitica2()){ if(applicaPoliticadue(s.getPrezzo()) < tmp) tmp = applicaPoliticadue(s.getPrezzo()); }
		if(s.isPolitica3()){ if(applicaPoliticatre(s.getPrezzo()) < tmp) tmp = applicaPoliticatre(s.getPrezzo()); }
		else tmp = s.getPrezzo(); 
		return tmp;
	}
	
	private final double POLITICA1 = 40.0;
	private final double POLITICA2= 50.0;
	private final double POLITICA3 = 35.0;
	private GregorianCalendar ora;
}

package it.dario.old.cinema;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Classe che gestisce l'astrazione di uno Spettacolo contenuto all'interno del cinema
 * 
 * @author Dario
 *
 */

public class Spettacolo implements Cloneable, Serializable{

	/**
	 * Costruttore che istanzia un oggetto con valori di default
	 */
	
	public Spettacolo(){
		this.sala= new Sala();
		this.film= new Film();
		this.prezzo=0.0;
		this.inizio= null;
		this.politica1 = false;
		this.politica2 = false;
		this.politica3 = false;
	}
	
	/**
	 * Costruttore che istanzia un oggetto spettacolo mediante parametri 
	 * 
	 * @param s sala dello spettacolo
	 * @param f film dello spettacolo
	 * @param prezzo prezzo del biglietto dello spettacolo
	 * @param mese mese di proiezione
	 * @param giorno giorno di proiezione
	 * @param ora ora di inizio
	 * @param minuto minuto di inizio
	 */
	public Spettacolo(Sala s, Film f, double prezzo,int mese, int giorno, int ora, int minuto){
		this.sala=s;
		this.film=f;
		this.prezzo=prezzo;
		this.inizio = new GregorianCalendar(2014, mese-1, giorno ,ora, minuto);
		this.politica1 = false;
		this.politica2 = false;
		this.politica3 = false;
	}

	/**
	 * 
	 * @return sala dello spettacolo
	 */
	public Sala getSala() {
		return sala;
	}
	
	/**
	 * 
	 * @param sala
	 */
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	/**
	 * 
	 * @return il film dello spettacolo
	 */
	public Film getFilm() {
		return film;
	}
	
	/**
	 * 
	 * @param film
	 */
	public void setFilm(Film film) {
		this.film = film;
	}
	
	/**
	 * 
	 * @return il prezzo del biglietto del film
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * 
	 * @param prezzo
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * 
	 * @return ora di inizio del film
	 */
	public int getOraInizio(){
		return getInizio().getTime().getHours();
	}
	
	/**
	 * 
	 * @return minuto inizio del film
	 */
	public int getMinutoInizio(){
		return getInizio().getTime().getMinutes();
	}
	
	/**
	 * Metodo che imposta la data e l'ora dell'inizio di uno spettacolo
	 * 
	 * @param me mese 
	 * @param gi giorno
	 * @param or ora 
	 * @param mi minuto
	 */
	public void setInizio(int me, int gi, int or, int mi) {
		this.inizio = new GregorianCalendar(2015, me-1, gi, or, mi);
	}

	/**
	 * 
	 * @return la data e l'ora d'inizio dello spettacolo
	 */
	public GregorianCalendar getInizio(){
		return inizio;
	}
	
	/**
	 * Controlla se la politica di sconto 1 è attiva per uno spettacolo
	 * 
	 * @return stato della politica 1 
	 */
	public boolean isPolitica1() {
		return politica1;
	}

	/**
	 * 
	 * @param politica1
	 */
	public void setPolitica1(boolean politica1) {
		this.politica1 = politica1;
	}

	/**
	 * Controlla se la politica di sconto 2 è attiva per uno spettacolo
	 * 
	 * @return stato della politica 2
	 */
	public boolean isPolitica2() {
		return politica2;
	}

	/**
	 * 
	 * @param politica2
	 */
	public void setPolitica2(boolean politica2) {
		this.politica2 = politica2;
	}

	/**
	 * Controlla se la politica di sconto 3 è attiva per uno spettacolo
	 * 
	 * @return stato della politica 3
	 */
	public boolean isPolitica3() {
		return politica3;
	}
	
	/**
	 * 
	 * @param politica3
	 */
	public void setPolitica3(boolean politica3) {
		this.politica3 = politica3;
	}

	@Override
	public String toString(){
		return getClass().getName()+"[sala="+sala+"][film="+film+"][prezzo="+prezzo+"][inizio="+inizio+"]";
	}
	@Override
	public boolean equals(Object other){
		if(other==null) return false;
		if(getClass() != other.getClass()) return false;
		Spettacolo obj = (Spettacolo) other;
		return (sala.equals(obj.sala)) && (film.equals(obj.film)) && (prezzo == obj.prezzo) && (inizio.equals(obj.inizio));
	}
	@Override
	public Spettacolo clone(){
		try{
			Spettacolo cloned = (Spettacolo) super.clone();
			cloned.film= film.clone();
			cloned.sala=sala.clone();
			cloned.inizio= (GregorianCalendar) inizio.clone();
			return cloned;
		}catch(CloneNotSupportedException e){ return null; }
	} 
	
	private Sala sala;
	private Film film;
	private double prezzo;
	private GregorianCalendar inizio;
	private boolean politica1;
	private boolean politica2;
	private boolean politica3;
}
	
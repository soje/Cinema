package it.dario.cinema;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Classe che gestisce il concetto di prenotazione di un biglietto 
 * 
 * @author Dario
 *
 */
public class Prenotazione implements Serializable{
	
	/**
	 * Costruttore che istanzia un oggetto prenotazione
	 *  
	 * @param s spettacolo della prenotazione
	 * @param c cliente della renotazione
	 */
	public Prenotazione(Spettacolo s, Cliente c){
		this.s=s;
		this.c=c;
		this.sconto = new Sconto();
		this.prezzoFinale=0.0;
		generaScadenza();
	}
	
	/**
	 * Metodo che prenota un posto e lo salva nella prenotazione
	 * 
	 * @param p
	 */
	
	public void prenota(Posto p){
		s.getSala().getPosto(p).setStato(2);
		postoPrenotato = p;
	}
	
	/**
	 * Metodo che conferma una prenotazione
	 * 
	 * @param p
	 */
	
	public void confermaPrenotazione(Posto p){
		s.getSala().getPosto(p).setStato(0);
	}
	
	/**
	 * metodo che rimuove una prenotazione
	 * 
	 * @param p
	 */
	public void rimuoviPrenotazione(Posto p){
		s.getSala().getPosto(p).setStato(1);
	}
	
	/**
	 * Metodo che genera una data e un orario che rappresentano
	 * il tempo nel quale una prenotazione può essere acquistata prima della sua scadenza
	 */
	
	public void generaScadenza(){
		GregorianCalendar g = new GregorianCalendar();
		g.add(Calendar.HOUR, 12);
		this.dataScadenza = g;
	}
	
	/**
	 * Metodo che applica lo sconto al prezzo finale del biglietto
	 * 
	 * @param fascia
	 * @return prezzo del biglietto
	 */
	
	public double ApplicaSconto(boolean fascia){
		prezzoFinale = sconto.calcolaSconto(s, fascia);
		return prezzoFinale;
	}
	
	/**
	 * 
	 * @return lo spettacolo della prenotazione
	 */
	public Spettacolo getSpettacolo(){
		return this.s;
	}
	
	/**
	 * 
	 * @return il clinete della prenotazione
	 */
	public Cliente getC() {
		return c;
	}

	/**
	 * 
	 * @param c
	 */
	public void setC(Cliente c) {
		this.c = c;
	}

	/**
	 * 
	 * @param s
	 */
	public void setS(Spettacolo s) {
		this.s = s;
	}
	
	/**
	 * 
	 * @return la data di scadenza della prenotazione
	 */
	
	public GregorianCalendar getDataScadenza(){
		return this.dataScadenza;
	}
	
	/**
	 * 
	 * @return il prezzo della prenotazione 
	 */
	public double getPrezzoFinale(){
		return this.prezzoFinale;
	}
	
	/**
	 * 
	 * @return il posto prenotato dal cliente
	 */
	public Posto getPostoPrenotato(){
		return this.postoPrenotato;
	}
	
	@Override
	public boolean equals(Object other){
		if(other == null) return false;
		if(other.getClass() != getClass())return false;
		Prenotazione obj = (Prenotazione) other;
		return (c.equals(obj.c)) && (s.getInizio().equals(obj.s.getInizio()) && postoPrenotato.equals(obj.postoPrenotato));
	}
	
	private Spettacolo s;
	private Cliente c;
	private Sconto sconto;
	private Posto postoPrenotato;
	private GregorianCalendar dataScadenza;
	private double prezzoFinale;
}

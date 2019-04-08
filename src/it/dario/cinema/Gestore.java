package it.dario.cinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

import it.dario.cinema.*;

/**
 * Classe che gestisce l'astrazione di un Gestore
 * 
 * @author Dario
 *
 */

public class Gestore implements Serializable, Cloneable{

	/**
	 * Costruttore che istanzia un Gestore con user e password preformattate 
	 */
	public Gestore(){
		this.user = "admin";
		this.pswd = "password";
	}
	
	/**
	 * Costruttore che istanzia un Gestore mediante inserimento di user e password
	 * @param user
	 * @param pswd
	 */
	
	public Gestore(String user, String pswd) {
		this.user = user;
		this.pswd = pswd;
	}
	
	//Prezzi inizio
	
	 /** 
	 * @param s
	 * @return restituisce l'incasso dello spettacolo passato come parametro
	 */
	public double getIncassoFilm(Spettacolo s){
		return s.getFilm().getIncasso();
	}
	
	/**
	 * 
	 * @param s
	 * @return retituisce l'incasso totale di tutti gli spettacoli contenuti nell'ArrayList
	 */
	public double getIncassoTotale(ArrayList<Spettacolo> s){
		double incassoTot=0.0;
		for(Spettacolo e : s){
			incassoTot+=e.getFilm().getIncasso();
		} return incassoTot;
	}
	
	//get-set inizio
	/**
	 * 
	 * @return user del Gestore
	 */
	public String getUser() {
		return user;
	}
	/**
	 * 
	 * @param user nuovo utente
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * 
	 * @return la password del Gestore
	 */
	public String getPswd() {
		return pswd;
	}
	
	/**
	 * 
	 * @param pswd nuova password
	 */
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	//get-set fine
	
	@Override
	public String toString(){
		return getClass().getName()+"[user="+user+"][pswd="+pswd+"]";
	}
	
	@Override
	public boolean equals(Object other){
		if(other == null) return false;
		if(getClass() != other.getClass()) return false;
		Gestore obj = (Gestore) other;
		return (obj.user.equals(user)) && (obj.pswd.equals(pswd));
	}
	
	public Gestore clone(){
		try{
			Gestore cloned = (Gestore) super.clone();
			return cloned;
		}catch(CloneNotSupportedException ex){ return null; }
	}

	private String user;
	private String pswd;
}

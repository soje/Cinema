package it.dario.cinema;

import java.io.Serializable;

/**
 * Classe che gestisce l'astrazione di un posto all'interno della sala del cinema
 * 
 * @author Dario
 *
 */

public class Posto implements Cloneable, Serializable{
	/**
	 * istanzia un posto vuoto
	 */
	public Posto(){}
	
	/**
	 * istanzia un oggetto Posto assegnandogli un numero di posto e una lettera della fila
	 * il parametro stato può assumere 4 valori {0 venduto, 1 disponibile, 2 prenotato, 3 indisponibile }
	 * 
	 * @param nPosto
	 * @param lFila
	 */
	public Posto(int nPosto, char lFila){
		this.nPosto=nPosto;
		this.lFila=lFila;
		this.stato=1; 
	}
	
	/**
	 * 
	 * @return numero del posto 
	 */
	public int getnPosto() {
		return nPosto;
	}
	/**
	 * 
	 * @param nPosto
	 */
	public void setnPosto(int nPosto) {
		this.nPosto = nPosto;
	}
	/**
	 * 
	 * @return lettera della fila in cui si trova il posto
	 */
	public char getlFila() {
		return lFila;
	}
	/**
	 * 
	 * @param lFila
	 */
	public void setlFila(char lFila) {
		this.lFila = lFila;
	}
	/**
	 * 
	 * @return lo stato del posto
	 */
	
	public int getStato() {
		return stato;
	}
	/**
	 * 
	 * @param stato
	 */
	public void setStato(int stato) {
		this.stato = stato;
	}

	@Override
	public String toString(){
		return getClass().getName()+"[nPosto="+nPosto+"][lFila="+lFila+"][stato="+stato+"]";
	}
	@Override
	public boolean equals(Object other){
		if(other==null) return false;
		if(getClass() != other.getClass()) return false;
		Posto obj = (Posto) other;
		return (obj.lFila == lFila) && (obj.nPosto==nPosto);
	}
	@Override
	public Posto clone(){
		try{
			Posto cloned = (Posto) super.clone();
			return cloned;
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
	
	private int nPosto;
	private char lFila;
	private int stato;
}

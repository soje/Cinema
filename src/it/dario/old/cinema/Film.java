package it.dario.old.cinema;

/**
 * Classe che gestisce l'astrazione di un Film
 * contiene metodi per gestire le sue istanze
 */

import java.io.Serializable;

public class Film implements Cloneable, Serializable{

	/**
	 *	Istanzia un oggetto Film con parametri vuoti
	 */
	public Film(){
		this.titolo="";
		this.info="";
		this.incasso=0.0;
	}
	/**
	 * Istanzia un oggetto Film
	 * 
	 * @param titolo Stringa che contiene il titolo del film
	 * @param info Stringa che contiene le info del film
	 */
	public Film(String titolo, String info){
		this.titolo=titolo;
		this.info=info;
		this.incasso=0.0;
	}
	/**
	 * 
	 * @return titolo del film
	 */
	public String getTitolo() {
		return titolo;
	}
	/**
	 * 
	 * @param titolo cambia il titolo del film
	 */
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	/**
	 * 
	 * @return info del film
	 */
	public String getInfo() {
		return info;
	}
	
	/**
	 * 
	 * @param info cambia le info del film
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	
	/**
	 * 
	 * @return incasso del film
	 */
	public double getIncasso() {
		return incasso;
	}
	
	/**
	 * 
	 * @param incasso cambia l'incasso del film
	 */
	public void setIncasso(double incasso) {
		this.incasso = incasso;
	}

	@Override
	public String toString(){
		return getClass().getName()+"[titolo="+titolo+"][info="+info+"][incasso="+incasso+"]";
	}
	@Override
	public boolean equals(Object other){
		if(other==null) return false;
		if(getClass() != other.getClass()) return false;
		Film obj = (Film) other;
		return (obj.titolo == titolo) && (obj.info == info) && (obj.incasso == incasso); 
	}
	@Override
	public Film clone(){
		try{
			Film cloned = (Film) super.clone();
			return cloned;
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
	
	private String titolo;
	private String info;
	private double incasso;
}

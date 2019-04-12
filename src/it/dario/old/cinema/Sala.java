package it.dario.old.cinema;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe che gestisce l'astrazione di un oggetto Sala 
 * @author Dario
 *
 */
public class Sala implements Cloneable, Serializable{

	/**
	 * Costruttore che imposta parametri di default
	 */
	public Sala(){
		posti = new ArrayList<Posto>();
		this.nSala=0;
		postiDisponibili=MAX_POSTI;
	}
	
	/**
	 * Costruttore che istanzia un ogeeto sala mediante il parametro che rappresenta il nuemro
	 * 
	 * @param nSala
	 */
	public Sala(int nSala){
		posti= new ArrayList<Posto>();
		this.nSala=nSala;
		postiDisponibili=MAX_POSTI;
	}
	
	//gestione arraylist dei posti
	
	/**
	 * Questo metodo ricevendo come parametro un posto p, lo ricerca all'interno dell'ArrayList di 
	 * tutti i posti inseriti nella sala, restituendolo
	 * 
	 * @param p
	 * @return un oggetto Posto
	 */
	public Posto getPosto(Posto p){
		int index = 0; 
		Posto a = new Posto();
		for(Posto e : posti){
			if(e.getnPosto()==p.getnPosto() && e.getlFila() == p.getlFila()){
					a = e;
			}
		}return a;
	}
	
	/**
	 * Questo metodo ricevendo come parametro un posto p, lo aggiunge all'interno dell'ArrayList di 
	 * tutti i posti inseriti nella sala, 
	 * 
	 * @param p posto da aggiungere
	 */
	public void addPosto(Posto p){
		if(!isPiena()){
			posti.add(p);
			checkPiena();
		}
	}
	
	//gestione arraylistfine
	
	/**
	 * 
	 * @return ArrayList di tutti i posti
	 */
	public ArrayList<Posto> getPosti() {
		return posti;
	}
	
	/**
	 * 
	 * @return numero della sala
	 */
	public int getnSala() {
		return nSala;
	}
	
	/**
	 * 
	 * @param nSala
	 */
	public void setnSala(int nSala) {
		this.nSala = nSala;
	}
	
	/**
	 * 
	 * @return il numero di posti disponibili nella sala
	 */
	public int getPostiDisponibili() {
		return postiDisponibili;
	}
	
	/**
	 * Questo metodo modifica il numero dei posti disponibili all'interno della sala
	 * controllando che il numero inserito sia minore o uguale della massima capienza
	 * 
	 * @param postiDisponibili
	 */
	public void setPostiDisponibili(int postiDisponibili){
		if(postiDisponibili <= MAX_POSTI){
			this.postiDisponibili = postiDisponibili;
		}
	}
	
	/**
	 * 
	 * @return valore che monitore l'andamento della capienza della sala
	 */
	public boolean isPiena() {
		return piena;
	}
	
	/**
	 * Metodo che controlla se la sala non ha più posti disponibili
	 *  
	 */
	
	public void checkPiena() {
		if(postiDisponibili==0)
			piena = true;
	}
	
	/**
	 * 
	 * @return numero massimo di posti disponibili
	 */
	public int getMaxPosti() {
		return MAX_POSTI;
	}
	
	@Override
	public String toString(){
		return getClass().getName()+"[posti="+posti+"][nSala="+nSala+"][postiDisponibili="+postiDisponibili+"][MAX_POSTI="+MAX_POSTI+"]";
	}
	
	@Override
	public boolean equals(Object other){
		if(other==null) return false;
		if(getClass() != other.getClass()) return false;
		Sala obj = (Sala) other;
		return (posti.equals(obj.posti)) && (nSala == obj.nSala) && (postiDisponibili == obj.postiDisponibili) && (MAX_POSTI == obj.MAX_POSTI) && (piena == obj.piena);
	}
	
	@Override
	public Sala clone(){
		try{
			Sala cloned = (Sala) super.clone();
			return cloned;
		}catch(CloneNotSupportedException e){ return null; }
	}
	
	private ArrayList<Posto> posti;
	private int nSala;
	private int postiDisponibili;
	private final int MAX_POSTI = 100;
	private boolean piena=false;
}

package it.dario.old.cinema;

/**
 * Classe che gestisce l'astrazione di un Utente
 * contiene metodi per gestire le sue istanze
 */

import java.io.Serializable;

public class Cliente implements Cloneable, Serializable{

	/**
	 * Istanzia un oggetto Utente con parametri vuoti
	 */
	public Cliente(){
		this.nome=null;
		this.cognome=null;
		this.eta=0;
		this.user=null;
		this.pswd=null;
	}
	/**
	 * Istanzia un oggetto Utente
	 * 
	 * @param nome Stringa che contiene il nome del cliente
	 * @param cognome Stringa che contiene il cognome del cliente
	 * @param eta Intero che contiene l'età del cliente
	 * @param user Stringa che contiene l'user del cliente
	 * @param pswd Stringa che contiene la password del cliente
	 */
	public Cliente(String nome, String cognome, int eta, String user, String pswd){
		this.nome=nome;
		this.cognome=cognome;
		this.eta=eta;
		this.user=user;
		this.pswd=pswd;
	}
	
	/**
	 * 
	 * @return nome del cliente
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * 
	 * @param nome 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * 
	 * @return cognome del cliente
	 */
	public String getCognome() {
		return cognome;
	}
	/**
	 *  
	 * @param cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**
	 * 
	 * @return età del cliente
	 */
	public int getEta() {
		return eta;
	}
	/**
	 * 
	 * @param eta
	 */
	public void setEta(int eta) {
		this.eta = eta;
	}
	/**
	 * 
	 * @return user del cliente
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * 
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * 
	 * @return password del cliente
	 */
	public String getPswd() {
		return pswd;
	}
	/**
	 * 
	 * @param pswd
	 */
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
	//get-set fine
	
	@Override
	public String toString(){
		return getClass().getName()+"[nome="+nome+"][cognome="+cognome+"][eta="+eta+"][user="+user+"][pswd="+pswd+"]";
	}
	@Override
	public boolean equals(Object other){
		if(other == null) return false;
		if(getClass() != other.getClass()) return false;
		Cliente obj = (Cliente) other;
		return (obj.nome.equals(nome)) && (obj.cognome.equals(cognome)) && (obj.eta == eta) && (obj.user.equals(user)) && (obj.pswd.equals(pswd)); 
	}
	@Override
	public Cliente clone(){
		try{
			Cliente cloned = (Cliente) super.clone();
			return cloned;
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
	
	private String nome;
	private String cognome;
	private int eta;
	private String user;
	private String pswd;
}

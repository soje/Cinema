package it.dario.old.cinema;

import java.io.Serializable;
import java.util.ArrayList;

public class Cinema implements Serializable{

	public Cinema(){
		spettacoli= new ArrayList<Spettacolo>();
		prenotazioni = new ArrayList<Prenotazione>();
		clienti = new ArrayList<Cliente>();
		gestore = new Gestore();
	}
	
	//punto3 inizio
	public String getInfo(Spettacolo x){
		String info="";
		for(Spettacolo e : spettacoli){
			if(x.equals(e)){
				info+="Titolo: "+x.getFilm().getTitolo()+"\n";
				info+="Info: "+x.getFilm().getInfo()+"\n";
				info+="Data Proiezione: "+x.getInizio().getTime()+"\n";
			}
		}
		return info; 
	}
	//punto3 fine
	
	//gestione arrayList inizio
	public void addSpettacolo(Spettacolo s){
		spettacoli.add(s);
	}
	
	//gestione ArrayList fine
	
	//get-set inizio
	public ArrayList<Spettacolo> getSpettacoli() {
		return spettacoli;
	}

	public void setSpettacoli(){
		this.spettacoli = new ArrayList<Spettacolo>();
	}
	
	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	
	public ArrayList<Cliente> getClienti() {
		return clienti;
	}

	public void setClienti(ArrayList<Cliente> clienti) {
		this.clienti = clienti;
	}

	public Gestore getGestore() {
		return gestore;
	}

	public void setGestore(Gestore gestore) {
		this.gestore = gestore;
	}
	

	public Cliente getSessioneAttuale() {
		return sessioneAttuale;
	}

	public void setSessioneAttuale(Cliente sessioneAttuale) {
		this.sessioneAttuale = sessioneAttuale;
	}
	//get-set fine

	private ArrayList<Spettacolo> spettacoli;
	private ArrayList<Prenotazione> prenotazioni;
	private ArrayList<Cliente> clienti;
	private Gestore gestore;
	private Cliente sessioneAttuale;
}

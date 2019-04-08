package it.dario.eccezioni;

/**
 * Classe che gestisce l'eccezione sulla prenotazione dei posti 
 * 
 * @author Dario
 *
 */
public class PostoIndisponibileException extends Exception {

	public PostoIndisponibileException(String msg){
		super(msg);
	}
}

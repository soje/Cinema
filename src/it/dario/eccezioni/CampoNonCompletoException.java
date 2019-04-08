package it.dario.eccezioni;

import it.dario.gui.*;
/**
 * Classe che gestisce una eccezione generica per alcuni errori di inserimento
 * 
 * @author Dario
 *
 */
public class CampoNonCompletoException extends Exception {

	public CampoNonCompletoException(String msg){
		FrameErrore win = new FrameErrore(msg);
	}
	
}

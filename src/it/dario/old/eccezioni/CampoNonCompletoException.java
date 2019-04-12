package it.dario.old.eccezioni;

import it.dario.old.gui.*;
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

package it.dario.model.gestione;

import it.dario.model.multisala.Posto;
import it.dario.model.multisala.Spettacolo;

import java.util.GregorianCalendar;

public class Prenotazione {

    private Spettacolo spettacolo;
    private Utente utente;
    private Posto posto;
    private double prezzoPagato;
    private GregorianCalendar scadenzaPrenotazione;

    public Prenotazione(Spettacolo spettacolo, Utente utente, Posto posto, double prezzoPagato,
                        GregorianCalendar scadenzaPrenotazione) {
        this.spettacolo = spettacolo;
        this.utente = utente;
        this.posto = posto;
        this.prezzoPagato = prezzoPagato;
        this.scadenzaPrenotazione = scadenzaPrenotazione;
    }

    public Spettacolo getSpettacolo() {
        return spettacolo;
    }

    public Utente getUtente() {
        return utente;
    }

    public Posto getPosto() {
        return posto;
    }

    public double getPrezzoPagato() {
        return prezzoPagato;
    }

    public GregorianCalendar getScadenzaPrenotazione() {
        return scadenzaPrenotazione;
    }

    public void setSpettacolo(Spettacolo spettacolo) {
        this.spettacolo = spettacolo;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }

    public void setPrezzoPagato(double prezzoPagato) {
        this.prezzoPagato = prezzoPagato;
    }

    public void setScadenzaPrenotazione(GregorianCalendar scadenzaPrenotazione) {
        this.scadenzaPrenotazione = scadenzaPrenotazione;
    }
}

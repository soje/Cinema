package it.dario.multisala;

import java.util.GregorianCalendar;

public class Spettacolo {

    public Spettacolo(double prezzo, boolean politica_uno, boolean politica_due, boolean politica_tre, Sala sala, Film film, GregorianCalendar inizio) {
        this.prezzo = prezzo;
        this.politica_uno = politica_uno;
        this.politica_due = politica_due;
        this.politica_tre = politica_tre;
        this.sala = sala;
        this.film = film;
        this.inizio = inizio;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public boolean isPolitica_uno() {
        return politica_uno;
    }

    public boolean isPolitica_due() {
        return politica_due;
    }

    public boolean isPolitica_tre() {
        return politica_tre;
    }

    public Sala getSala() {
        return sala;
    }

    public Film getFilm() {
        return film;
    }

    public GregorianCalendar getInizio() {
        return inizio;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setPolitica_uno(boolean politica_uno) {
        this.politica_uno = politica_uno;
    }

    public void setPolitica_due(boolean politica_due) {
        this.politica_due = politica_due;
    }

    public void setPolitica_tre(boolean politica_tre) {
        this.politica_tre = politica_tre;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setInizio(GregorianCalendar inizio) {
        this.inizio = inizio;
    }

    @Override
    public String toString(){
        String str = String.format("[prezzo=%f][politica_uno=%b][politica_due=%b][politica_tre=%b][sala=%s][film=%s][inizio=%s]",
                this.prezzo, this.politica_uno, this.politica_due, this.politica_tre, this.sala, this.film, this.inizio);
        return getClass()+str;
    }

    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        if(getClass() != object.getClass()) return null;

        Spettacolo spettacolo = (Spettacolo) object;

        return ()
    }

    private double prezzo;
    private boolean politica_uno;
    private boolean politica_due;
    private boolean politica_tre;
    private Sala sala;
    private Film film;
    private GregorianCalendar inizio;
}

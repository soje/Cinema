package it.dario.multisala;

public class Posto {

    public Posto(char fila, int posto, int stato) {
        this.fila = fila;
        this.numero = posto;
        this.stato = stato;
    }

    public char getFila() {
        return fila;
    }

    public int getPosto() {
        return numero;
    }

    public int getStato() {
        return stato;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public void setPosto(int posto) {
        this.numero = posto;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    @Override
    public String toString(){
        return getClass().getName() + String.format(
                "[fila=%c][posto=%d][stato=%d]",
                this.fila,
                this.numero,
                this.stato
        );
    }
    
    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        if(getClass() != object.getClass()) return false;
        
        Posto posto = (Posto) object;
        
        return (posto.fila == this.fila) && (posto.numero == this.numero) && (posto.stato == this.stato);
    }

    @Override
    public Posto clone(){
        try{
            Posto cloned = (Posto) super.clone();
            return cloned;
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }
    
    private char fila;
    private int numero;
    private int stato;
}

package it.dario.model.multisala;
import java.util.ArrayList;

public class Sala {

    public Sala(ArrayList<Posto> platea, int numeroSala, boolean piena, int postiDisponibili) {
        this.platea = platea;
        this.numeroSala = numeroSala;
        this.piena = piena;
        this.postiDisponibili = postiDisponibili;
    }

    public ArrayList<Posto> getPlatea() {
        return platea;
    }

    public int getnSala() {
        return numeroSala;
    }

    public boolean isPiena() {
        return piena;
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    public static int getMaxPosti() {
        return MAX_POSTI;
    }

    public void setPlatea(ArrayList<Posto> platea) {
        this.platea = platea;
    }

    public void setnSala(int nSala) {
        this.numeroSala = nSala;
    }

    public void setPiena(boolean piena) {
        this.piena = piena;
    }

    public void setPostiDisponibili(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    @Override
    public String toString(){
        return getClass().getName() + String.format(
                "[platea=%s][numeroSala=%d][piena=%b][postiDisponibli=%d][MAX_POSTI=%d]",
                this.platea.toString(),
                this.numeroSala,
                this.piena,
                this.postiDisponibili,
                MAX_POSTI);
    }

    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        if(getClass() != object.getClass()) return false;

        Sala sala = (Sala) object;

        return sala.platea.equals(this.platea) && (sala.numeroSala == this.numeroSala) && (sala.piena == this.piena) && (sala.postiDisponibili == this.postiDisponibili) && (sala.MAX_POSTI == MAX_POSTI);
    }

    @Override
    public Sala clone(){
        try{
            return (Sala) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }

    private ArrayList<Posto> platea;
    private int numeroSala;
    private boolean piena;
    private int postiDisponibili;
    private final static int MAX_POSTI = 100;

}

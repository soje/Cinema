package it.dario.multisala;

public class Film {

    private String titolo;
    private String info;
    private int durata;

    public Film(String titolo, String info, int durata){
        this.titolo = titolo;
        this.info = info;
        this.durata = durata;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getInfo() {
        return info;
    }

    public int getDurata() {
        return durata;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString(){
        return getClass().getName() + String.format(
                "[titolo=%s][info=%s][durata=%d]",
                this.titolo,
                this.info,
                this.durata
        );
    }

    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        if(getClass() != object.getClass()) return false;

        Film film = (Film) object;

        return (film.titolo.equals(this.titolo)) && (film.info.equals(this.info)) && (film.durata == this.durata);
    }

    @Override
    public Film clone(){
        try{
            Film cloned = (Film) super.clone();
            return cloned;
        }catch(CloneNotSupportedException e){
            return null;
        }
    }
}

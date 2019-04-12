package it.dario.model.gestione;

public class Utente {

    public Utente(String nome, String cognome, int eta, String username, String pswd) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.username = username;
        this.pswd = pswd;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public String getUsername() {
        return username;
    }

    public String getPswd() {
        return pswd;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    @Override
    public String toString(){

        return getClass().getName() + String.format(
                "[nome=%s][cognome=%s][eta=%d][username=%s][pswd=%s]",
                this.nome,
                this.cognome,
                this.eta,
                this.username,
                this.pswd
        ) ;
    }

    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        if(getClass() != object.getClass()) return false;

        Utente utente = (Utente) object;

        return (this.nome == utente.nome) && (this.cognome == utente.cognome) && (this.eta == utente.eta) && (this.username == utente.username) && (this.pswd == utente.pswd);
    }

    @Override
    public Utente clone(){
        try{
            return (Utente) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }

    private String nome;
    private String cognome;
    private int eta;
    private String username;
    private String pswd;
}

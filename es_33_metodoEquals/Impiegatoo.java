public class Impiegatoo {
    private String nome;
    private String cognome;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override //questa annotazione indica che stiamo sovrascrivendo il metodo equals ereditato dalla classe Object
    public boolean equals(Object obj){
        impiegato other = (Impiegato) obj; //Qui viene effettuato un cast dell'oggetto obj al tipo Impiegato. L'obiettivo è trattare obj come un oggetto di tipo Impiegato, poiché il metodo equals è definito all'interno di una classe che si chiama Impiegato. stai dicendo al programma che considererai l'oggetto obj come un'istanza di tipo Impiegato. Questo è un passo necessario per accedere alle proprietà specifiche degli oggetti di tipo Impiegato.
        if(cognome.equals(other.getCognome())&& nome.equals(other.getNome()))//controllo di uguaglianza tra le proprietà cognome e nome dell'oggetto corrente (chiamato this) e dell'oggetto other.
            return true;
        else
            return false;

    }
    
}

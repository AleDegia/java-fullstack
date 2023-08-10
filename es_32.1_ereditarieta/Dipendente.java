public class Dipendente extends Persona {
    private double stipendio; //dichiaro solo i nuovi attributi/metodi (quelli della classe padre non serve dichiararli nuovamente, vengono ereditati)

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public Dipendente() {}

    //esempio di overload del metodo costruttore
    public Dipendente(String nome, String cognome, double stipendio){
        super(nome, cognome);//col metodo super chiamo il costruttore della superclasse che ha i parametri che metto dentro super
        this.stipendio = stipendio;//questo è l'attributo in + rispetto alla superclasse
    } 
}

public class Main {
    public static void main(String[] args) {
   //per riferimento (perchè viene nel metodo viene copiato il riferimento a quell'oggetto)
   //sempre di una copia si tratta ..
   PassaggioParametri p = new PassaggioParametri();
    Impiegato tmp = new Impiegato();
    tmp.setNome("paperino");
    p.hello(tmp);
    System.out.println(tmp.getNome());
    //il risultato sarà pippo perchè ad un oggetto passato come parametro ad un metodo saranno riportate tutte le modifiche fatte su di esso. x e tmp si riferiscono allo stesso oggetto.
    //Impiegato tmp = new Impiegato(); crea la cella con dentro le variabili nome e cognome, ed un altra cella che contiene l'indirizzo dell'oggetto vero e proprio(tmp).
    //diamo il nome paperino e dentro il metodo hello viene creata una variabile x in cui viene copiato il riferimento all'oggetto contenuto in tmp
 }
}

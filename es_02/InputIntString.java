/*
con import installiamo delle libreria di sistema, in questo caso 
la libreria/classe scanner in modo da avere i suoi metodi.
dopodichè istanziamo un nuovo oggetto di tipo scanner con new.
il metodo next() ci restituisce qualcosa, cio chè è tra le parentesi, 
sottoforma di stringa.
main è il metodo da cui parte la lettura del programma, prende in ingresso e coverta in stringa 
il codice che ci inseriamo dentro.
Questo programma pur non presentando errori di compilazione presenta alcune eccezioni non gestite
(InputMismatchException)
 */

import java.util.Scanner;

public class InputIntString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci il tuo nome: ");
        String nome = input.next();

        System.out.print("Inserisci la tua età: ");
        int eta = input.nextInt();
        // inserisco una condizione che verifica l'età dell'utente, verifico se l'input utente è maggiorenne 

        //int soglia = 18;

        if(eta<18){
            // se lo è, l'utente è autorizzato e riceve un messaggio di benvenuto, se è < di 18 l'utente riceve un mess di errore
            System.out.println("non hai 18 anni");
        }
            //se lo è, l'utente è autorizzato e riceve un messaggio di benvenuto,
        System.out.println("Ciao, " + nome + "! Hai " + eta + " anni.");
    }
}
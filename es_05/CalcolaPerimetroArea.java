//package java_workspaces.esercitazioni.es_05;

import java.util.Scanner;

public class CalcolaPerimetroArea {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // crea un oggetto Scanner per leggere i dati inseriti dall'utente dopo
                                                // la scritta del nostro print grazie all'input.nextInt
        System.out.print("inserisci il valore della base in cm: ");
        int base = input.nextInt();
        System.out.print("inserisci l'altezza in cm: ");
        int altezza = input.nextInt();
        int perimetro = (base + altezza) * 2;
        if (base > 400 || altezza > 400) {
            System.out.println("il numero è troppo grosso");
        } else {
            System.out.println("il perimetro è di " + perimetro + "cm");
            System.out.print("l'area è di " + base * altezza + "cm");
            input.close();
        }

    }//ciao

}

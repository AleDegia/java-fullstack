//package java_workspaces.esercitazioni.es_07;

import java.util.Scanner;

public class calcolaPerimetroArea {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci la lunghezza del lato");
        int lato; // questo sarà il parametro che utilizzerò per i calcoli
        lato = input.nextInt();
        // lato=5;
        int area = lato + lato;
        int perimetro = lato * 4;
        // aggiunto una condizione che verifica l'input
        if (lato > 40) {
            System.out.println("hai inserito un numero troppo grande");

        } else {
            //se l'input è <= a 40
            System.out.println("il lato inserito: " + lato);
            System.out.println("l'area è: " + area);
            System.out.println("il perimetro è: " + perimetro);
        }
        //lascio fuori da if else la chiusura della classe input (se mi da errore non metterlo)
        input.close();
    }
}
//package java_workspaces.esercitazioni.es_07;

import java.util.Scanner;

public class calcolaPerimetroArea {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci la lunghezza del lato");
        int lato; //questo sarà il parametro che utilizzerò per i calcoli 
        lato= input.nextInt();
        //lato=5;
        int area= lato+lato;
        int perimetro= lato*4;
        System.out.println(lato);
        System.out.println(area);
        System.out.println(perimetro);
    }
}
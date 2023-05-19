//package java_workspaces.esercitazioni.es_random3.1;

import java.util.Scanner;
import java.util.Random;

public class esRandom3_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random casuale = new Random();
        int casual = casuale.nextInt(100)+1;
        int numeroUtente; //dichiaro solamente la variabile utente
        do{
            System.out.println("indovina un numero da 1 a 100: ");
            numeroUtente = input.nextInt();
            if(numeroUtente<casual){
                System.out.println("Il numero che hai scelto è troppo basso");
            }
            else if(numeroUtente > casual){
                System.out.println("Il numero che hai scelto è troppo alto");
            }
        }
        while (numeroUtente != casual);
        {
            System.out.println("complimenti, hai indovinato il numero" + casual);
        }
    }
    
}

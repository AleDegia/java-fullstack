//package java_workspaces.esercitazioni.es_indovina_numero2;

import java.util.Scanner;

public class indovinaNumero2 {
    public static void main(String[] args) {
        int numeroDaIndovinare = 11;
        //int tentativi = 0;
        Scanner input = new Scanner(System.in);
        int tentativo;
        boolean vincita = false;

        while (vincita == false) {
            System.out.println("indovina numero tra 1 e 100");
            tentativo = input.nextInt();
            // tentativi++

            if (tentativo == numeroDaIndovinare) {
                vincita = true;
            } else if (tentativo < numeroDaIndovinare) {
                System.out.println("troppo basso! Prova ancora");

            } else if (tentativo > numeroDaIndovinare) {
                System.out.println("Troppo alto! Prova ancora!");
            }
        }
        System.out.println("Bravo! Hai indovinato il numero");
        //System.out.println("Bravo! Hai indovinato il numero dopo "+tentativi + " tentativi");
    }

}
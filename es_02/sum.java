//package esercitazioni.es_02;

import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  //crea un oggetto Scanner per leggere i dati inseriti dall'utente dopo la scritta del nostro print grazie all'input.nextInt
        System.out.print("inserisci il tuo nome: ");  //stampa "inserisi il primo numero"
        String nome = input.nextLine();   //legge la prossima stringa inserita in risposta a ciò che manda a schermo il system.out.print
        System.out.print("inserisci il primo numero: "); 
        int num = input.nextInt();   //legge il prossimo numero intero inserito dall'utente dopo la scritta che appare grazie al nostro print
        System.out.print("inserisci il secondo numero: "); 
        int num2 = input.nextInt();
        int sum = num + num2;
        System.out.print(nome + " la somma dei due numeri è "+sum);
    }
}
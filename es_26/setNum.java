//package java_workspaces.esercitazioni.es_26;

import java.util.HashSet; //rappresenta un insieme non ordinato di elementi senza duplicati.
import java.util.Scanner;
import java.util.Set;  //sta con l'hashset

public class setNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Set<Integer> setNumeri = new HashSet<Integer>();
        System.out.println("Inserisci gli interi separati da uno spazio:");
        String[] numeri = input.nextLine().split(" "); //la stringa numeri viene suddivisa in un array di stringhe utilizzando il metodo split(" ")
        for (String numero : numeri) {
            setNumeri.add(Integer.parseInt(numero)); //viene convertita ogni stringa in un numero intero (setNumeri vuole interi)
        }
        System.out.println("Il numero di elementi inseriti è: " + numeri.length);
        System.out.println("Il numero di elementi del set è: " + setNumeri.size());
        System.out.println("Il Set senza duplicati è:");
        for (int numero : setNumeri) {
            System.out.print(numero + " ");
        }
    }
}

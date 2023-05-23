//package java_workspaces.esercitazioni.es_24;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class accettaElementoCoda {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Integer> coda = new LinkedList<Integer>();
        System.out.println("Inserisci gli elementi della Queue (inserisci 0 per terminare l'inserimento)");
        int elemento = input.nextInt();
        while (elemento != 0) {
            coda.add(elemento);
            elemento = input.nextInt();
        }
        Queue<Integer> codaSenzaNegativi = new LinkedList<Integer>();
        while (!coda.isEmpty()) {
            int elementoCorrente = coda.remove();
            if (elementoCorrente >= 0) {
                codaSenzaNegativi.add(elementoCorrente);
            }
        }
        System.out.println("La Queue senza elementi negativi è:");
        while (codaSenzaNegativi.isEmpty()) {
            System.out.println(codaSenzaNegativi.remove());
        }
    }
}

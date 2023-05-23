//package java_workspaces.esercitazioni;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class tempoCoda {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Queue<Integer> codaClienti = new LinkedList<Integer>();
        Queue<Integer> codaTempoServizio = new LinkedList<Integer>();
        System.out.println("Inserisci il numero di clienti:");
        int numeroClienti = input.nextInt();
        for (int i = 1; i <= numeroClienti; i++){
            System.out.println("Inserisci il tempo di servizio per il cliente" + i +":");
            int tempoServizio = input.nextInt();
            codaClienti.add(i);
            codaTempoServizio.add(tempoServizio);
        }
        int tempoTotale = 0;
        int tempoTrascorso = 0;
        while(!codaClienti.isEmpty()){
            int clienteCorrente = codaClienti.remove();  //rimuovi sempre l'ultimo elemento nella coda
            int tempoServizioCorrente = codaTempoServizio.remove();
            tempoTotale += tempoTrascorso + tempoServizioCorrente;
            tempoTrascorso += tempoServizioCorrente;
        }
        System.out.println("il tempo totale di attesa per tutti i clienti è " + tempoTotale + ".");
    }
    
}

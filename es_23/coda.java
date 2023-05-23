//package java_workspaces.esercitazioni.es_23;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class coda {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Queue<String> coda = new LinkedList<String>();
        System.out.println("inserisci gli elementi della queue (inserisci \"fine\" per terminare l'inserimento):");
        String elemento = input.nextLine();
        while(!elemento.equals("fine"))
        {
            coda.add(elemento);
            elemento = input.nextLine();
        }
        System.out.println("Gli elementi della queue sono:");
        while(!coda.isEmpty()){
            System.out.println(coda.remove()); //facendo cosi si rimuovono tutti gli elementi
        }
        input.close();
    }
}

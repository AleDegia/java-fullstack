//package java_workspaces.esercitazioni.es_13_diverso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class arrayListDiverso {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        fruits.add("Mela"); // il metodo add della classe aggiunge un elemento
        fruits.add("Banana");
        fruits.add("Arancia");

        System.out.println(" Scegli 0 per aggiungere un elemento. Scegli 1 per eliminare");
        int scelta = input.nextInt();
        if (scelta == 0) {

            System.out.println("Scrivi il frutto che vuoi inserire");
            String daAggiungere = input.next();
            fruits.add(daAggiungere);
            System.out.println(fruits);
        } else if (scelta == 1) {
            System.out.println("dimmi il frutto da rimuovere");
            String noFrutto = input.next();
            fruits.remove(noFrutto);
            System.out.println(fruits);
        }
    }
}// il metodo per rimuovere un elemento specifico
/*
 * System.out.println("Nuova lista: ");
 * for (String fruit : fruits) {
 * System.out.println(fruit);
 * }
 * ////
 * }
 * }
 */
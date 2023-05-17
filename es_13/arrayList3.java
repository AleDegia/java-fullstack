//package java_workspaces.esercitazioni.es_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class arrayList3 {
    public static void main(String[] args) 
    {
        List<String> fruits = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        fruits.add("Mela"); //il metodo add della classe aggiunge un elemento
        fruits.add("Banana");
        fruits.add("Arancia");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println("dimmi il frutto da rimuovere");
        int noFrutto = input.nextInt();
        fruits.remove(noFrutto); //il metodo per rimuovere un elemento specifico 
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

    }
    
}

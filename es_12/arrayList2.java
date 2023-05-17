//package java_workspaces.esercitazioni.es_11;

import java.util.ArrayList;
import java.util.List;

public class arrayList2 {
    public static void main(String[] args) 
    {
        List<String> fruits = new ArrayList<String>();
        fruits.add("Mela"); //il metodo add della classe aggiunge un elemento
        fruits.add("Banana");
        fruits.add("Arancia");
        //fruits.clear(); //con questo non stamperà nulla perchè stamperà una lista vuota
        //fruits.remove(0); //il metodo per rimuovere un elemento specifico 
        fruits.size();

        for(String fruit : fruits)
        {
            System.out.println(fruit);
            //System.out.println(fruits.size());
           // System.out.println(fruits.isEmpty());

        }
        //System.out.println(fruits.isEmpty());
    }
    
}
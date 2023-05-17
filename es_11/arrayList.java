//package java_workspaces.esercitazioni.es_11;

import java.util.ArrayList;
import java.util.List;

public class arrayList {
    public static void main(String[] args) 
    {
        List<String> fruits = new ArrayList<String>();
        fruits.add("Mela"); //il metodo add della classe aggiunge un elemento
        fruits.add("Banana");
        fruits.add("Arancia");

        for(String fruit : fruits)
        {
            System.out.println(fruit);
        }
    }
    
}

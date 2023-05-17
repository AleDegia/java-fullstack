//package java_workspaces.esercitazioni.es_14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class arraySpostoLista {
    public static void main(String[] args) {
        List<String> pacco1 = new ArrayList<String>();
        List<String> pacco2 = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        pacco1.add("Mela"); // il metodo add della classe aggiunge un elemento
        pacco1.add("Banana");
        pacco1.add("Arancia");

        pacco2.add("albicocca"); // il metodo add della classe aggiunge un elemento
        pacco2.add("fragola");
        pacco2.add("mirtillo");

        System.out.println(" quale elemento eliminare dal pacco 1 tra"+pacco1);
        String scelta = input.next();
        pacco1.remove(scelta);
        System.out.println(" il tuo pacco 1 ora è "+pacco1);
        pacco2.add(scelta);
        System.out.println("il tuo pacco 2 ora è: " + pacco2);

        //System.out.println(" quale elemento aggiungere al pacco 2");
        //String aggiunta = input.next();
        //pacco1.add(aggiunta);
        //System.out.println(pacco2);
    }
    
}

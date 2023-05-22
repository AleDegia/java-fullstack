//package java_workspaces.esercitazioni.es_22;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class cercaLista {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<String> lista = new ArrayList<String>();
        System.out.println("Inserisci gli elementi della lista( inserisci \"fine\" per terminare l'inserimento)");
        String elemento = input.nextLine();
        while (!elemento.equals("fine")); //finchè l'elemento è diverso da fine (non si può dire è diverso al posto di equals)
        {
            lista.add(elemento);
            elemento = input.nextLine();
        }
        System.out.println("Inserisci l'elemento da cercare: ");
        String elementoCercato = input.nextLine();
        int indice = lista.indexOf(elementoCercato);
        if(indice != -1) //gli elementi che non esistono hanno indice di -1. Se indexOf non trova l'elemento nella lista, restituirà il valore -1. 
        {
        System.out.println("L'elemento si trova all'indice " + indice + " della lista.");

        }
        System.out.println("L'elemento non è presente nella lista");
        }
}

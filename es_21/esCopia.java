//package java_workspaces.esercitazioni.es_21;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class esCopia {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        List<Integer> lista  = new ArrayList <Integer>();
        System.out.println("Inserisci gli elementi della lista (inserisci 0 per terminare l'inserimento)");
        while(input.nextInt()!=0)
        {
        lista.add(input.nextInt());

    }
    }
    
}

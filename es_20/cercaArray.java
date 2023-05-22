//package java_workspaces.esercitazioni.es_20;

import java.util.Scanner;

public class cercaArray {
 public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("inserisci la dimensione dell'array");
    int dimensione = input.nextInt();
    int[] array = new int[dimensione];
    System.out.println("inserisci gli elementi dell'array");
    for (int i = 0; i<dimensione; i++){  //il ciclo for continua finchè il contatore raggiunge la dimensione inserita dall'utente
        array[i] = input.nextInt();  //assegno gli input dell'utente ad un array 
    }
    System.out.print("Inserisci il numero da cercare ");
    int  numeroCercato = input.nextInt(); //definisco una variabile e la inizializzo con valore pari all'input dell'utente
    int indice = -1; //variabile che rappresenta l'indice di un elemento che non esiste
    for (int i = 0; i<dimensione;i++){
        if((array[i]) == numeroCercato){
            indice = i;
            break;
        }
    }
    if (indice != -1){
        System.out.println("Il numero si trova all'indice " + indice + " dell'array");
    } else{
        System.out.println("il numero non è presente nell'array");
    }
 }
    
}

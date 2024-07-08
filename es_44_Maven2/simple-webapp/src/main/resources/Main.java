

import java.util.Scanner;public class Main {    public static void main(String[] args) {
        // Crea uno scanner per leggere l'input dell'utente
        Scanner scanner = new Scanner(System.in);

        //Stampa il menu
        System.out.println("Seleziona un opzione:");
        System.out.println("1: Crea il database e le tabelle");
        System.out.println("2: Inserisci i dati nelle tabelle");
        System.out.println("3: Salva i dati in un file CSV");

        //leggi la scelta dell'utente
        int scelta = scanner.nextInt();

        try {
            
        while(scelta ==1 || scelta ==2 || scelta ==3){
        //esegui l'operazione scelta
        switch(scelta){
            
            case 1:
                CreaDBCollegato.main(args);
                
        scanner = new Scanner(System.in);
        //Stampa il menu
        System.out.println("Seleziona un opzione:");
        System.out.println("1: Crea il database e le tabelle");
        System.out.println("2: Inserisci i dati nelle tabelle");
        System.out.println("3: Salva i dati in un file CSV");
        scelta = scanner.nextInt();
                break;
            case 2:
                InserisciDatiCollegati.main(args);
                scanner = new Scanner(System.in);

        //Stampa il menu
        System.out.println("Seleziona un opzione:");
        System.out.println("1: Crea il database e le tabelle");
        System.out.println("2: Inserisci i dati nelle tabelle");
        System.out.println("3: Salva i dati in un file CSV");
        scelta = scanner.nextInt();
                break;
            case 3:
                SalvaInCSV.main(args);
                scanner = new Scanner(System.in);

        //Stampa il menu
        System.out.println("Seleziona un opzione:");
        System.out.println("1: Crea il database e le tabelle");
        System.out.println("2: Inserisci i dati nelle tabelle");
        System.out.println("3: Salva i dati in un file CSV");
        scelta = scanner.nextInt();
                break;
            default:
                System.out.println("Scelta non valida. Inserisci 1. 2 o 3.");
                
        }}
    } catch(Exception e) {
        System.out.println("Scelta non valida. Inserisci 1. 2 o 3.");
    }

        scanner.close();
    }


}

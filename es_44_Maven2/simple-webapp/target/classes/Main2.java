import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continua;

        do {
            // Stampa il nome
            System.out.println("Seleziona un opzione");
            System.out.println("1: Crea il database e le tabelle");
            System.out.println("3: Salva i dati in un file CSV");

            // leggi la scelta dell'utente
            int scelta = scanner.nextInt();
            scanner.nextLine(); // rimuove il newline rimanente

            // Esegui l'operazione scelta
            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il nome del database da creare");
                    break;
                case 2:
                    System.out.println("Inserisci il nome del database nel quale inserire i dati");
                    break;
                case 3:
                    System.out.println("Inserisci il nome del database dal quale estrarre i dati:");
                    break;
                default:
                    System.out.println("Scelta non valida. Inserisci 1. 2 o 3.");
            }
            String dbName = scanner.nextLine();

            switch (scelta) {
                case 1:
                    CreaDBCollegato.main(new String[] { dbName });
                    break;
                case 2:
                    InserisciDatiCollegati.main(new String[] { dbName });
                    break;
                case 3:
                    SalvaInCSV(new String[] { dbName });
                    break;
                default:
                    System.out.println("Scelta non valida. Inserisci 1. 2 o 3.");
            }

            // Chiedi all'utente se desidera continuare
            System.out.println("Vuoi eseguire un altra operazione? (S/N)");
            continua = scanner.nextLine();
        } while (continua.equals.IgnoreCase("S"));
        scanner.close();
    }

}

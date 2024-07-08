import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continua;

        do {
            // Stampa il nome
            System.out.println("Seleziona un'opzione");
            System.out.println("1: Crea il database e le tabelle");
            System.out.println("2: Inserisci dati nel database");
            System.out.println("3: Salva i dati in un file CSV");
            System.out.println("4: Modifica i dati");
            System.out.println("5: Cancella i dati");
            System.out.println("6: Salva i dati in un file CSV");


            // leggi la scelta dell'utente
            int scelta = scanner.nextInt();
            scanner.nextLine(); // rimuove il newline rimanente

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il nome del database da creare");
                    break;
                case 2:
                    System.out.println("Inserisci il nome del database dal quale visualizzare i dati");
                    break;
                case 3:
                    System.out.println("Inserisci il nome del database dal quale estrarre i dati:");
                    break;
                case 4:
                    System.out.println("Inserisci il nome del database dal quale modificare i dati");
                    break;
                case 5:
                    System.out.println("Inserisci il nome del database dal quale cancellare i dati");
                    break;
                case 6:
                    System.out.println("Inserisci il nome del database dal quale estrarre i dati:");
                    break;    
                default:
                    System.out.println("Scelta non valida. Inserisci 1, 2 o 3.");
            }
            String dbName = scanner.nextLine();

            // Esegui l'operazione scelta
            switch (scelta) {
                case 1:
                    CreaDBCollegato2.main(new String[] { dbName + ".db" });
                    break;
                case 2:
                    InserisciDatiCollegati2.main(new String[] { dbName + ".db" });
                    break;
                case 3:
                    SalvaInCSV.main(new String[] { dbName + ".db" });
                    break;
                case 4:
                    CreaDBCollegato2.main(new String[] { dbName + ".db" });
                    break;
                case 5:
                    InserisciDatiCollegati2.main(new String[] { dbName + ".db" });
                    break;
                case 6:
                    SalvaInCSV.main(new String[] { dbName + ".db" });
                    break;    
                default:
                    System.out.println("Scelta non valida. Inserisci 1, 2, 3, 4, 5 o 6");
            }

            // Chiedi all'utente se desidera continuare
            System.out.println("Vuoi eseguire un'altra operazione? (S/N)");
            continua = scanner.nextLine();
        } while (continua.equalsIgnoreCase("S"));
        scanner.close();
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InserisciManual {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_collegato' come nome di default.");
            args = new String[] { "database_collegato" };
        }

        Connection conn = null;
        Scanner scanner = new Scanner(System.in);
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:" + args[0] + ".db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            System.out.println(
                    "Se vuoi aggiungere un prodotto alla categoria esistente premi 0 altrimenti premi 1 per aggiungere una categoria.");
            int scelta = Integer.parseInt(scanner.nextLine());

            if (scelta == 0) {
                // query x i dati utenti che poi inserira manualmente
                String sqlInserisciDatiUtente = "INSERT INTO prodotti(nome, quantita, prezzo, id_categoria) VALUES(?, ?, ?, ?)";
                PreparedStatement pstmtInserisciDatiUtente = conn.prepareStatement(sqlInserisciDatiUtente);

                // inserisce il nome del prodtoo
                System.out.println("inserisci nome prodotto");
                String nomeProdotto = scanner.nextLine();
                pstmtInserisciDatiUtente.setString(1, nomeProdotto);

                // inserisci quantita
                System.out.println("inserisci quantità prodotto");
                int quantitaProdotto = Integer.parseInt(scanner.nextLine());
                pstmtInserisciDatiUtente.setInt(2, quantitaProdotto);

                // inserisci prezzo

                System.out.println("inserisci prezzo prodotto");
                double prezzoProdotto = Double.parseDouble(scanner.nextLine());
                pstmtInserisciDatiUtente.setDouble(3, prezzoProdotto);

                // inserisci nome categoria

                System.out.println("inserisci il nome della categoria prodotto");
                String nomeCategoria = scanner.nextLine();

                // esegue una seconda query che seleziona l'id della categoria che ha scritto
                // l'utente
                String sqlControlloCategoria = "SELECT categorie.id AS id FROM categorie WHERE categorie.nome = ?";
                PreparedStatement ptsmtControlloCategoria = conn.prepareStatement(sqlControlloCategoria);
                ptsmtControlloCategoria.setString(1, nomeCategoria);
                ResultSet rsCc = ptsmtControlloCategoria.executeQuery();

                // se dal risultato della seconda query esce almeno una riga, allora aggiunge
                // come 4 valore della prima query
                // il valore dell'id che è risultato dalla prima query
                if (rsCc.next() == true) {
                    int id_categoria = rsCc.getInt("id");
                    pstmtInserisciDatiUtente.setInt(4, id_categoria);
                    pstmtInserisciDatiUtente.executeUpdate();
                } else {
                    System.out.println("crea categroia");
                }
            } else if (scelta == 1) {

                String sqlInserisciCategoria = "INSERT INTO categorie(nome) VALUES(?)";
                PreparedStatement pstmtInserisciCategoria = conn.prepareStatement(sqlInserisciCategoria);
                System.out.println("inserisci il nome della categoria");
                String nomeCategoria = scanner.nextLine();
                pstmtInserisciCategoria.setString(1, nomeCategoria);
                pstmtInserisciCategoria.executeUpdate();

            } else {
                System.out.println("scelta non valida. Digita 0 o 1");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    // scanner.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
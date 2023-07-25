import java.sql.Connection; //Questa riga importa la classe Connection dal package java.sql, che è necessaria per gestire le connessioni al database.
import java.sql.DriverManager; //Questa riga importa la classe DriverManager dal package java.sql, che fornisce i metodi per registrare i driver JDBC e ottenere connessioni al database.
import java.sql.SQLException; //Questa riga importa la classe SQLException dal package java.sql, che rappresenta un'eccezione generata quando si verificano errori durante 
import java.sql.Statement;

public class CreaDB {

    public static void main(String[] args) {

        Connection conn = null;  //Viene dichiarata una variabile conn di tipo Connection e inizializzata con il valore null. Questa variabile sarà utilizzata per stabilire la connessione al database.
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:database.db"; //Crea una stringa url contenente l'URL del database. In questo caso, il database è un file chiamato "database.db" che sarà gestito da SQLite.
            conn = DriverManager.getConnection(url); //Ottiene una connessione al database utilizzando l'URL specificato. Viene utilizzato DriverManager.getConnection() per ottenere la connessione e il riferimento ad essa viene assegnato alla variabile conn.

            System.out.println("Connessione a SQLite stabilita.");

            // Creo la tabella
            String sql = "CREATE TABLE IF NOT EXISTS prodotti (\n" //Viene creata una stringa sql contenente l'istruzione SQL per creare una tabella chiamata "prodotti" con due colonne: "nome_prodotto" di tipo testo (stringa) e "quantita" di tipo intero.
                    + " nome_prodotto text NOT NULL,\n"
                    + " quantita integer NOT NULL\n"
                    + ");";

            Statement stmt = conn.createStatement(); //Viene creato un oggetto Statement utilizzando la connessione conn. Gli oggetti Statement sono utilizzati per eseguire query SQL sul database.
            stmt.execute(sql); //l'istruzione SQL è quella per creare la tabella "prodotti" nel database.

            System.out.println("Tabella 'prodotti' creata.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
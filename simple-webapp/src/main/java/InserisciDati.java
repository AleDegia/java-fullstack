import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InserisciDati {

    public static void main(String[] args) {

        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:database.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Inserisco i dati di esempio
            String sql1 = "INSERT INTO prodotti (nome_prodotto, quantita, categoria_prodotto, prezzo_prodotto) VALUES ('Mela', 100, 'Frutta', 0.5);";
            String sql2 = "INSERT INTO prodotti (nome_prodotto, quantita, categoria_prodotto, prezzo_prodotto) VALUES ('Pera', 120, 'Frutta', 0.6);";
            String sql3 = "INSERT INTO prodotti (nome_prodotto, quantita, categoria_prodotto, prezzo_prodotto) VALUES ('Banana', 80, 'Frutta', 0.3);";

            Statement stmt1 = conn.createStatement();
            stmt1.execute(sql1);

            Statement stmt2 = conn.createStatement();
            stmt2.execute(sql2);

            Statement stmt3 = conn.createStatement();
            stmt3.execute(sql3);

            System.out.println("I dati di esempio sono stati inseriti.");

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
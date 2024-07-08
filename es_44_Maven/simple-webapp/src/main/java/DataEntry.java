import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataEntry {

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
            
            String sql4 = "INSERT INTO prodotti (ID_prodotto, nome_prodotto, categoria_Prodotto, prezzo_prodotto, quantita_Prodotto, data_ScadenzaProdotto) VALUES (1, 'Mela', 'Frutta', 0.50, 100, '2023-06-10');";
            String sql5 = "INSERT INTO prodotti (ID_prodotto, nome_prodotto, categoria_Prodotto, prezzo_prodotto, quantita_Prodotto, data_ScadenzaProdotto) VALUES (2, 'Panino', 'Pane' , 1.00 , 50, '2023-06-11');";
            String sql6 = "INSERT INTO prodotti (ID_prodotto, nome_prodotto, categoria_Prodotto, prezzo_prodotto, quantita_Prodotto, data_ScadenzaProdotto) VALUES (3, 'Latte', 'Latticini', 1.502, 30, '2023-06-12');";
            /* "1,Mela,Frutta,0.50,100,2023-06-10",
        "2,Panino,Pane,1.00,50,2023-06-11",
        "3,Latte,Latticini,1.50,30,2023-06-12",
        "4,Cereali,Colazione,2.50,20,2023-06-13",
        "5,Pasta,Pasta,0.75,80,2023-06-14",
        "6,Arancia,Frutta,0.60,70,2023-06-15",
        "7,Burro,Latticini,1.25,40,2023-06-16",
        "8,Pane,Pane,1.00,60,2023-06-17",
        "9,Riso,Pasta,1.10,40,2023-06-18",
        "10,Yogurt,Latticini,1.50,30,2023-06-19"*/

            Statement stmt1 = conn.createStatement();
            stmt1.execute(sql4);

            Statement stmt2 = conn.createStatement();
            stmt2.execute(sql5);

            Statement stmt3 = conn.createStatement();
            stmt3.execute(sql6);

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
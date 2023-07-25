import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisualizzaDati {
    public static void main(String[] args) {

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");

            //creo una connessione al database
            String url = "jdbc:sqlite:database.db";
            conn = DriverManager.getConnection(url);

            System.out.println("connessione a SQLite stabilita.");

            //Eseguo la query select
            String sql = "SELECT * FROM prodotti;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //stampo i risultati
            while (rs.next()) {
                String nomeProdotto = rs.getString("nome_prodotto");
                int quantita = rs.getInt("quantita");
                String categoriaProdotto = rs.getString("categoria_prodotto");
                double prezzoProdotto = rs.getDouble("prezzo_prodotto");

                System.out.println("Nome Prodotto: " + nomeProdotto + ", Quantita: " + quantita + ", Categoria Prodotto: " + categoriaProdotto + ", Prezzo Prodotto: " + prezzoProdotto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:database.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita");

            // Eseguo la query SELECT
            String sql = "SELECT * FROM prodotti;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String csvFile = "./prodotto.csv";
            String header = "Nome_Prodotto, Quantita, Categoria, Prezzo\n";
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(csvFile);
                fileWriter.append(header);
                while (rs.next()) {
                    String nomeProdotto = rs.getString("nome_prodotto");
                    int quantita = rs.getInt("quantita");
                    String categoriaProdotto = rs.getString("categoria_prodotto");
                    double prezzoProdotto = rs.getDouble("prezzo_prodotto");
                    String str = nomeProdotto + ", " + quantita + ", " + categoriaProdotto + ", " + prezzoProdotto;
                    fileWriter.append(str);
                    fileWriter.append("\n");
                    System.out.println("Nome Prodotto: " + nomeProdotto + ", Quantita: " + quantita + ", Categoria: " + categoriaProdotto + ", Prezzo: " + prezzoProdotto);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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

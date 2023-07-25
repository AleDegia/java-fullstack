import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CancellaDati {
    public static void main(String[] args) {
       
        Connection conn = null;
        try{
            //carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            //Creo una connessione al database
            String url = "jdbc:sqlite:database.db";
            conn= DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            String sql = "DELETE FROM prodotti WHERE nom_prodotto = 'Pera';";

            Statement stmt = conn.createStatement();
            stmt.execute(sql);

             System.out.println("La pera è stata cancellata");
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


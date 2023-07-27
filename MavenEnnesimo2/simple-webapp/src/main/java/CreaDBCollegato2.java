import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreaDBCollegato2 {
    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("Nome del database non fornito. Uso 'database collegato' come nome di default");
            args = new String[]{"database_collegato"};
        }

        Connection conn = null;
        try{
            //carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            //Crea una connessione al database
            String url = "jdbc:sqlite:" + args[0] + ".db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita");

            //Creo le tabelle
            String sqlCreaTabellaProdotti = "CREATE TABLE IF NOT EXISTS prodotti (\n"
            + " id integer PRIMARY KEY,\n"
            + " nome text NOT NULL,\n"
            + " quantita integer NOT NULL,\n"
            + " prezzo real NOT NULL,\n"
            + " id_categoria integer,\n"
            + ");"; 
        Statement stmt1 = conn.createStatement();
            stmt1.execute(sqlCreaTabellaProdotti);

            System.out.println("Tabelle 'categorie' e 'prodotti' create.");

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

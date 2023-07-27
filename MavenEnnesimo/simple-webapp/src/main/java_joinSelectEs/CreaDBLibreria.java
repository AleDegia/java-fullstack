import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreaDBLibreria {

    public static void main(String[] args) {

        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:libreria.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Creo la tabella 'autori'
            String sql1 = "CREATE TABLE IF NOT EXISTS autori (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " titolo text NOT NULL,\n"
                    + " annoPubblicazione integer PRIMARY KEY,\n"
                    + " id_libri integer,\n"
                    + ");";
                    
            // Creo la tabella 'generi'
            String sql2 = "CREATE TABLE IF NOT EXISTS generi (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " nomeAutore text NOT NULL,\n"
                    + " cognome text NOT NULL,\n"
                    + " id_libri integer,\n"
                    + ");";
                    

            // Creo la tabella 'libri' con chiavi esterne che si riferiscono alle tabelle 'autori' e 'generi'
            String sql3 = "CREATE TABLE IF NOT EXISTS libri (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " nomeLibro text NOT NULL,\n"
                    + " id_autore integer PRIMARY KEY,\n"
                    + " FOREIGN KEY(id_autore) REFERENCES libri(autori)\n"
                    + " id_genere integer PRIMARY KEY,\n"
                    + " FOREIGN KEY(id_genere) REFERENCES libri(genere)\n"
                    + ");";
                    

            Statement stmt1 = conn.createStatement();
            stmt1.execute(sql1);

            Statement stmt2 = conn.createStatement();
            stmt2.execute(sql2);

            Statement stmt3 = conn.createStatement();
            stmt3.execute(sql3);


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
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


//esegui una query JOIN che combini le tabelle "libri", "autori" e "generi" per ottenere un elenco di libri con il nome dell'autore e il genere associato. Stampa i risultati ottenuti a console in un formato leggibile.

//all'id del libro associo nome autore e genere come foreign key?
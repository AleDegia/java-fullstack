import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VisualizzaDati {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_collegato' come nome di default.");
            args = new String[] { "database_collegato" };
        }

        Connection conn = null;
        try {
            //Qui viene costruita l'URL di connessione al database SQLite. L'URL è composto da "jdbc:sqlite:", che è il prefisso comune per tutte le connessioni a database SQLite, seguito dal nome del file del database.
            // Il nome del file del database viene passato come argomento da riga di comando (args[0]) e dovrebbe avere un'estensione ".db".
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:" + args[0] + ".db";
            conn = DriverManager.getConnection(url);

            // Questa riga di codice definisce una stringa SQL che contiene una query di selezione dei dati da due tabelle, "prodotti" e "categorie". 
            //La query seleziona alcune colonne dalla tabella "prodotti" (id, nome, quantita, prezzo) e una colonna dalla tabella "categorie" (nome) utilizzando 
            //una clausola JOIN per collegare le due tabelle in base all'ID della categoria.
            String sql = "SELECT prodotti.id, prodotti.nome, prodotti.quantita, prodotti.prezzo, categorie.nome AS nomeCategoria FROM prodotti JOIN categorie ON prodotti.id_categoria=categorie.id;";
            Statement stmt = conn.createStatement(); //Qui viene creato un oggetto Statement che verrà utilizzato per eseguire la query sul database. conn è presunto essere un oggetto di connessione al database.
            ResultSet rs = stmt.executeQuery(sql); //memorizza i risultati nella variabile rs, che è un oggetto ResultSet. Questo oggetto conterrà i dati restituiti dalla query.

            // tabulazione nome Database. \t: viene utilizzato per inserire un carattere di tabulazione, che rappresenta una serie di spazi. In questo caso, ci sono tre tabulazioni \t \t \t all'inizio della riga, che inseriscono uno spazio vuoto equivalente a tre caratteri di larghezza.
            System.out.println("\n \t \t \t|" + "Database " + args[0] + "|\t \t \n"); //titolo del visualizza dati

            // Tabulazione Nomi Colonne
            System.out.println(
                    "ID: \t|" + "Nome: \t \t \t \t|" + "Quantita: \t|" + "Prezzo: \t|" + "Nome_Categoria:");

            // Cicliamo i record ottenuti dalla query e li stampiamo tabulandoli in modo che
            // seguano la tabulazione delle colonne

            // nel caso in quale il nome del prodotto sia troppo lumngo, aumaentare i \t
            // dopo la string nome, cosi andra smepre tabulato in modo corretot
            while (rs.next()) { //scorriamo le righe del resultSet 
                String prezzoInVirgola = Double.toString(rs.getDouble("prezzo")).replace(".", ",");
                if (rs.getString("nome").length() > 20) {
                    System.out.println(
                            rs.getInt("id") + "\t|" + rs.getString("nome") + "\t|" + rs.getInt("quantita")
                                    + "\t \t|" + prezzoInVirgola + "\t \t|" + rs.getString("nomeCategoria"));
                } else if (rs.getString("nome").length() <= 20 && rs.getString("nome").length() >= 7) {
                    System.out.println(
                            rs.getInt("id") + "\t|" + rs.getString("nome") + "\t \t \t|" + rs.getInt("quantita")
                                    + "\t \t|" + prezzoInVirgola + "\t \t|" + rs.getString("nomeCategoria"));
                } else {
                    System.out.println(
                            rs.getInt("id") + "\t|" + rs.getString("nome") + "\t \t \t \t|" + rs.getInt("quantita")
                                    + "\t \t|" + prezzoInVirgola + "\t \t|" + rs.getString("nomeCategoria"));
                }
            }

            System.out.println("\t");

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
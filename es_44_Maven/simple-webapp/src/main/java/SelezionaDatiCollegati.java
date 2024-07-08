import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelezionaDatiCollegati {

    public static void main(String[] args) {

        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:database_collegato.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Eseguo la query JOIN
            String sql = "SELECT prodotti.nome AS nome_prodotto, prodotti.quantita, prodotti.prezzo, categorie.nome AS nome_categoria " + //è una query di selezione (SELECT) che recupera dati da due tabelle, "prodotti" e "categorie", e restituisce quattro colonne specifiche: prodotti.nome AS nome_prodotto seleziona la colonna "nome" dalla tabella "prodotti". L'alias AS nome_prodotto viene utilizzato per rinominare la colonna che viene stampata (come "nome_prodotto".) in modo che sia accessibili come "nome_prodotto" nel ResultSet.
                         "FROM prodotti " + //la query inizierà selezionando i dati dalla tabella "prodotti".
                         "JOIN categorie ON prodotti.id_categoria = categorie.id;"; //Questa parte indica che si sta eseguendo un'operazione di JOIN tra la tabella "prodotti" e la tabella "categorie". La parola chiave JOIN indica che vogliamo combinare i dati da entrambe le tabelle in base alla condizione specificata.

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Stampo i risultati (Vengono stampati i risultati della query utilizzando un ciclo while. La query JOIN restituisce colonne selezionate da entrambe le tabelle, quindi vengono estratti i valori delle colonne "nome_prodotto", "quantita", "prezzo" e "nome_categoria" dal ResultSet, e vengono stampati a schermo.)
            while (rs.next()) { //Questa parte del codice utilizza un ciclo "while" per iterare attraverso il ResultSet.
                String nomeProdotto = rs.getString("nome_prodotto"); //Per ogni riga di risultati, vengono estratti i valori delle colonne "nome_prodotto", "quantita", "prezzo" e "nome_categoria" utilizzando i metodi appropriati come "rs.getString()" e "rs.getInt()".
                int quantita = rs.getInt("quantita");
                double prezzo = rs.getDouble("prezzo");
                String nomeCategoria = rs.getString("nome_categoria");

                
                System.out.println("Nome Prodotto: " + nomeProdotto + ", Quantita: " + quantita +
                        ", Prezzo: " + prezzo + ", Categoria: " + nomeCategoria);
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

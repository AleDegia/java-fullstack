import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalvaInCSV {

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
            String sql = "SELECT prodotti.nome AS nome_prodotto, prodotti.quantita, prodotti.prezzo, categorie.nome AS nome_categoria " + //selziono i campi con cui mi interessa creare il csv
                         "FROM prodotti " + //La clausola FROM specifica la tabella da cui vengono selezionati i dati. In questo caso, selezioniamo i dati dalla tabella "prodotti".
                         "JOIN categorie ON prodotti.id_categoria = categorie.id;"; //l'operazione di JOIN consente di combinare i dati da più tabelle in base a una condizione di corrispondenza, La parola chiave "ON" indica come le righe delle due tabelle dovrebbero essere abbinate. La colonna "id_categoria" nella tabella "prodotti" viene utilizzata come chiave per la combinazione con la tabella "categorie". La colonna "id" nella tabella "categorie" viene utilizzata come chiave per la combinazione con la tabella "prodotti".
                        //unisci categorie a prodotti se nella riga presa in esame i valori di 'id_categoria' in 'prodotti' corrispondono ai valori di 'id' in 'categorie'.
                        //La condizione di join è specificata dopo ON.
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Preparo il file CSV
            FileWriter fileWriter = new FileWriter("prodotti_categorie.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Nome Prodotto, Quantita, Prezzo, Categoria");  // Intestazione del CSV

            // Stampo i risultati nel file CSV
            while (rs.next()) {
                String nomeProdotto = rs.getString("nome_prodotto"); //Recupera il valore della colonna "nome_prodotto" dalla riga corrente del ResultSet e lo assegna alla variabile nomeProdotto di tipo String.
                int quantita = rs.getInt("quantita");
                double prezzo = rs.getDouble("prezzo");
                String nomeCategoria = rs.getString("nome_categoria");

                printWriter.println(nomeProdotto + ", " + quantita + ", " + prezzo + ", " + nomeCategoria);
            }

            printWriter.close();
            System.out.println("I dati sono stati salvati nel file 'prodotti_categorie.csv'.");

        } catch (SQLException | ClassNotFoundException | IOException e) {
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

//Join: Nel tuo caso, stai eseguendo una INNER JOIN, che restituisce solo le righe dove c'è una corrispondenza tra i valori delle colonne specificate nella condizione di JOIN.
/*Ecco come funziona la query:

JOIN: Questo indica che stai unendo le tabelle 'prodotti' e 'categorie'.
categorie: Questo è il nome della tabella con cui stai unendo la tabella 'prodotti'.
ON prodotti.id_categoria = categorie.id: Questa parte della query specifica la condizione di JOIN. Stai dicendo al database di unire le righe delle due tabelle in base alla corrispondenza tra il valore della colonna 'id_categoria' nella tabella 'prodotti' e il valore della colonna 'id' nella tabella 'categorie'. Questo significa che verranno selezionate solo le righe in cui i valori di 'id_categoria' in 'prodotti' corrispondono ai valori di 'id' in 'categorie'. */ 


/*Quindi, il risultato della query includerà quattro colonne: "nome_prodotto", "quantita", "prezzo" e "nome_categoria". 
Queste colonne mostreranno i nomi dei prodotti, le relative quantità disponibili, i prezzi di ciascun prodotto e il nome della categoria a cui appartiene 
ciascun prodotto. Questi dati saranno ottenuti combinando le informazioni dalle tabelle "prodotti" e "categorie" in base alla relazione definita nella 
clausola JOIN. */
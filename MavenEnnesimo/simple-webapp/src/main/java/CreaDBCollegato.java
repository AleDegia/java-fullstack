import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//associeremo i prodotto alle loro categorie
public class CreaDBCollegato3 {

    public static void main(String[] args) {

        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:database_collegato.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Creo la tabella 'categoria'
            String sql1 = "CREATE TABLE IF NOT EXISTS categorie (\n"
                    + " id integer PRIMARY KEY,\n" //La specifica PRIMARY KEY indica che questa colonna sarà la chiave primaria della tabella, il che significa che conterrà un valore univoco per ogni riga e identificherà univocamente ogni riga nella tabella.(come fosse il suo codice fiscale..) Stiamo dicendo che l'attributo 'id'aavrà uno ed un solo valore. se hai l'id di una categoria, puoi facilmente recuperare le informazioni associate a quella categoria dal database utilizzando la chiave primaria.
                    + " nome text NOT NULL\n"
                    + ");";

            // Creo la tabella 'prodotti' con una chiave esterna che si riferisce alla tabella 'categorie'
            String sql2 = "CREATE TABLE IF NOT EXISTS prodotti (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " nome text NOT NULL,\n"
                    + " quantita integer NOT NULL,\n"
                    + " prezzo real NOT NULL,\n"
                    + " id_categoria integer,\n"
                    + " FOREIGN KEY(id_categoria) REFERENCES categorie(id)\n" //FOREIGN KEY(id_categoria) indica che stiamo creando una chiave esterna nella colonna 'id_categoria' della tabella 'prodotti', e stabilendo un collegamento con la chiave primaria di un'altra tabella. REFERENCES Indica che la colonna 'id_categoria' della tabella 'prodotti' fa riferimento alla colonna 'id' della tabella 'categorie'. 
                    + ");";                                                   //L'utilità della chiave esterna sta nel creare relazioni tra le tabelle, consentendo di collegare dati correlati. la chiave esterna "id_categoria" nella tabella "prodotti" stabilisce un legame tra i prodotti e le loro categorie corrispondenti.In altre parole, i valori inseriti nella colonna'id_categoria' di 'prodotti' devono corrispondere a valori validi presenti nella colonna 'id' di 'categorie'.

            Statement stmt1 = conn.createStatement();
            stmt1.execute(sql1);

            Statement stmt2 = conn.createStatement();
            stmt2.execute(sql2);

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

//Nella tabella "categorie", la colonna "id" è definita come chiave primaria (PRIMARY KEY). Ciò significa che ogni riga nella tabella "categorie" ha un valore univoco per la colonna "id".

//Nella tabella "prodotti", c'è una colonna "id_categoria" che rappresenta la categoria di appartenenza di un prodotto. Questa colonna è definita come chiave esterna (FOREIGN KEY) che fa riferimento alla colonna "id" della tabella "categorie" (REFERENCES categorie(id)).
//Per collegare questa informazione alla tabella delle categorie, viene utilizzata una chiave esterna.
// Gli identificatori (ID) sono generalmente valori univoci e distinti per ciascuna riga della tabella. Questo garantisce che ogni riferimento incrociato sia affidabile e non ambiguo. Diversi prodotti potrebbero avere lo stesso nome all'interno della tabella "prodotti", ma usando un ID univoco per ogni prodotto, si evita qualsiasi confusione o ambiguità quando si fa riferimento alle categorie associate.
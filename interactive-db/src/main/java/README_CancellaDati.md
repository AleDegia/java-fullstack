# CancellaDati.java

Questa classe serve per cancellare un prodotto dalla tabella. Viene utilizzato uno scanner per permettere all'utente di selezionare il prodotto che vuole cancellare dalla tabella inserendo l'id del prodotto.


## Classi importate

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



## Codice

```
if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_collegato' come nome di default.");
            args = new String[] { "database_collegato" };
        }
```

if (args.length == 0) controlla se l'array args è vuoto, quindi se l'utente non ha inserito alcun input quando ha eseguito il programma. 
In tal caso viene stampato un messaggio e viene assegna un nuovo valore all'array args con la seguente riga:

args = new String[] { "database_collegato" };

In sostanza, questo codice assicura che ci sia almeno un argomento nell'array args anche se l'utente non ne ha fornito alcuno, e utilizza "database_collegato" come valore predefinito nel caso in cui l'utente non ne abbia specificato uno.

```
VisualizzaDati.main(args);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci l'ID del prodotto da cancellare:");
        String idProdotto = scanner.next();

        Connection conn = null;
```

VisualizzaDati.main(args); -> richiama il metodo main dalla classe VisualizzaDati
Dopodichè viene utilizzato uno scanner per prendere ciò che inserisce l'utente come id del prodotto da cancellare e lo assegna alla variabile String idProdotto
 Connection conn = null; -> dichiarazione variabile per stabilire una connessione col database, impostata su null.


```
 try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:" + args[0] + ".db";
            conn = DriverManager.getConnection(url);

            String sql = "DELETE FROM prodotti WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(idProdotto)); // Cancella il prodotto con l'id inserito dall'utente
            pstmt.executeUpdate();

            System.out.println("Dati cancellati con successo.");
            VisualizzaDati.main(args);
    }
```

Viene effettuata la connessione al database e viene creata un istruzione SQL che cancellerà una riga dalla tabella "prodotti" dove l'ID corrisponde al valore specificato dall'utente.
pstmt.executeUpdate();: Questo metodo esegue effettivamente l'istruzione SQL preparata. Ciò comporterà la cancellazione del prodotto con l'ID specificato.
Viene poi stampato un messaggio di conferma dell'andamento dell'operazione e viene poi chiamato il main di visualizza dati per visualizzare la tabella dei prodotti aggiornata.


```
catch (SQLException | ClassNotFoundException e) {
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
```

questa prozione di codice serve a verificare che non ci siano eventuali errore del codice.
if (conn != null) { conn.close(); } -> viene verificato se la variabile conn (che rappresenta la connessione al database) è diversa da null. Se la connessione è stata stabilita con successo (non è null), viene chiusa utilizzando il metodo close().
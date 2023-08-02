# riassunto gestionale database



nel main abbiamo creato un menu principale in cui l'utente può scegliere una delle seguenti opzioni:

- 1: Crea un nuovo DB
- 2: Seleziona un DB esistente
- 3: Elimina un DB
- 4: Esci

nell'opzione 1 viene chiamata il main della classe CreaDatabase tramite CreaDatabase.main().

CreaDatabase permette di creare una nuova tabella se non esiste già. Crea prima la tabella categorie e poi quella prodotti, che avrà con una Foreign Key per refenziare l'id categoria del prodotto all' id della categoria.
Dopo averlo creato si passa ad un altro ciclo, che permette di inserire dati predefiniti, modificare i dati, cancellarli o inserirli manualmente. In questo ciclo:
- InserisciManualmente parte con un messaggio per l'utente che chiede di selezionare l'opzione 0 per inserire un prodotto ad una categoria esistente, mentre di selezionare la uno se si vuole inserire una nuova categoria nella tabella categorie.
Selezionando la 0 vengono chiesti i vari campi del prodotto, dopodichè (String sqlControlloCategoria = "SELECT categorie.id AS id FROM categorie WHERE    categorie.nome = ?") seleziona l'ID della categoria dalla tabella "categorie" dove il campo "nome" corrisponde al parametro di posizione "?", memorizza il risultato in un oggetto ResultSet chiamato rsCc.
Viene eseguita perciò una query per verificare l'esistenza della categoria specificata dall'utente.
Se la categoria esiste, viene recuperato il suo ID e viene eseguita la query di inserimento del nuovo prodotto con l'ID della categoria.
Se la categoria non esiste, viene stampato un messaggio che indica di creare la categoria.
Selzionando la 1 viene perciò chiesto di digitare il nome della categoria che si vuole creare e viene eseguita la query di inserimento della nuova categoria.

- SalvaInCSV tramite String sql = "SELECT prodotti.nome AS nome_prodotto, prodotti.quantita, prodotti.prezzo, categorie.nome AS nome_categoria " + "FROM prodotti " + "JOIN categorie ON prodotti.id_categoria = categorie.id;" selziono i campi con cui mi interessa creare il csv, selezioniamo i dati dalla tabella "prodotti" e JOIN consente di combinare i dati da più tabelle in base a una condizione di corrispondenza: unisci categorie a prodotti se nella riga presa in esame i valori di 'id_categoria' in 'prodotti' corrispondono ai valori di 'id' in 'categorie'. La condizione di join è specificata dopo ON.

- ModificaDati utilizza la query (UPDATE) per aggiornare il campo "quantita" nella tabella "prodotti" con il valore fornito. L'aggiornamento viene effettuato solo per il prodotto con l'ID specificato dal secondo parametro.
scegliendo l'opzione 2 l'applicazione mostra un elenco dei database disponibili (i file con estensione ".db" nella directory corrente)

- CancellaDati tramite la stringa sql = "DELETE FROM prodotti WHERE id = ?" definisce una stringa contenente la query SQL di cancellazione (DELETE). La query cancella tutte le righe dalla tabella "prodotti" dove il campo "id" corrisponde al valore del parametro di posizione "?".
pstmt.setInt(1, Integer.parseInt(idProdotto)) Imposta il valore del parametro di posizione "?" nella query con il valore dell'ID del prodotto inserito dall'utente. Il valore viene convertito da String a int utilizzando Integer.parseInt().

l'opzione 3 chiama il main ii DeleteDatabase che ha permette di eliminare un database selezionato dall'elenco dei database disponibili (nello specifico se ci sono file .db viene mostrato l'elenco dei database disponibili, verificando se il numero inserito dall'utente corrisponde ad un database gia esitente)if

-la 4 stampa un messaggio e mette count uguale a false per non far entrare piu nel ciclo





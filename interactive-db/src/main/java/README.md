# Main.java

il file Main .java è l'entry point dell'applicazione che permette di selezionare le azioni possibili attraverso 2 menu collegati
inoltre questo file passa alle altre classi delle informazioni attraverso il metodo main
il file main ha il compito di gestire le sessioni del database attraverso il blocco finally che gestisce la connessione  al database


## Classi importate

* java.util.Scanner

Abbiamo utilizzato delle classi specifiche tipo ad esempio import java.util.Scanner; che ha dato il seguente problema:
nonostante vengano creati più oggetti scanner con nomi diversi, comunque la chiusura di uno scanner influisce sulla chiusura di tutti gli altri quindi quando facciamo scanner.close da errore in quanto l'isruzione successiva trova l'oggetto già chiuso.

* java.io.File

Abbiamo utilizzato questa classe per lavorare con i files in quanto dobbiamo creare, eliminare e modificare database

* java.io.FilenameFilter

Classe utilizzata per filtrare nella directory i file che finiscono con .db

## Parte Iniziale
In questa prima parte definiamo alcune variabili utili al programma


Dopo la firma del programma istanzio una classe scanner che servirà alla ricezione degli input
```
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
```
Definisco la variabile choice che prende in seguito il valore inserito dall'utente

```
        int choice;
```
Definisco una variabile booleana vera "cont" come condizione di verifica per i cicli, diventerà falsa quando dovremo uscire dal ciclo

```
        boolean cont = true;
```
Dichiaro la variabile che corrisponderà al nome del database fornito dall'utente e che a sua volta sarà l'argomento del main per "CreaDataBase"
```
        String databaseName = null;
```

A questo punto mostriamo all'utente le prime funzionalità chiedendo di scegliere un'opzione, utilizziamo un ciclo while che ci permette la continuità del programma affinchè la condizione "cont" sia vera.

```
        while (cont) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1: Crea un nuovo DB");
            System.out.println("2: Seleziona un DB esistente");
            System.out.println("3: Elimina un DB");
            System.out.println("4: Esci");
```
ora assegnamo alla variabile choice il numero inserito dall'utente
            choice = scanner.nextInt();
```
in questo caso utilizziamo nextInt() per gestire meglio gli errori, ma lo scanner leggerà solo un carattere non tutta la riga del terminale (Line), per questo la facciamo consumare al programma con il seguente comando:
```
            scanner.nextLine(); // Consuma il newline lasciato da nextInt()


## Crea Database
Se l'utente sceglie di creare il database verrà richiesto all'utente di inserirne il nome

```
            if (choice == 1) {
                System.out.println("Inserisci il nome del nuovo database:");
```
l'utente inserisce il nome del database
```
                databaseName = scanner.nextLine();
```
Passiamo come argomento (al posto di args) a CreaDatabase il nome fornito dall'utente
```
                CreaDatabase.main(new String[] { databaseName });
            }
```

## Seleziona Database

Se l'utente vuole selezionare un database esistente, devo ottenere i file contenuti nella directory corrente attraverso il metodo accept della classe FilenameFilter che mi restituirà i files che terminano con ".db"
```
            else if (choice == 2) {
                File dir = new File("."); // Directory corrente
                String[] files = dir.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".db");
                    }
                });
```
Stampo poi i database disponibili, vengono numerati con automaticamente con il ciclo for
```

                // Stampa l'elenco dei database
                System.out.println("Database disponibili:");
                for (int i = 0; i < files.length; i++) {
                    System.out.println((i + 1) + ": " + files[i]);
                }
```
A questo punto l'utente può scegliere tra i database esistenti selezionandone il numero

```
                System.out.println("Scegli un database (inserisci il numero):");
                int dbChoice = scanner.nextInt();
                scanner.nextLine(); // Consuma il newline lasciato da nextInt()
```
Assegna a databaseName il nome del database scelto (corrisponddente alla stringa nell'array files all'indice dbChoice-1)e rimuove l'estensione .db dal nome del database
```
                databaseName = files[dbChoice - 1].replace(".db", ""); // Rimuovi l'estensione .db dal nome del database
```
## Cancella Database
In questa parte il programma esegue solamente il file che corrisponde al programma di cancellazione di un database.

```
else if (choice == 3) {
DeleteDatabase.main(new String[] {});
}
```
## Esci dal programma e condizione di Default
In questa parte c'è l'opzione per uscire dal programma
```
else if (choice == 4) {
                System.out.println("Addio!");
```
la condizione diventa falsa e viene poi rieseguito il ciclo while con "continue" ma la condizione risulterà falsa quindi uscirà.
```
                cont = false;
                continue;
```
Viene ,essa anche una condizione di default per opzioni non valide:
```
            } else { //
                System.out.println("Opzione non valida. Riprova.");
                continue;
            }
```


## Operazioni da eseguire su database scelto

Ogni scelta porta a una funzionalità racchiusa nel main di ciascuna classe

```
boolean backToMainMenu = false;
            while (!backToMainMenu) {
                System.out.println("Scegli un'opzione per il database " + databaseName + ":");
                System.out.println("1: Inserisci dummy datas");
                System.out.println("2: Salva in CSV");
                System.out.println("3: Modifica dati");
                System.out.println("4: Cancella dati");
                System.out.println("5: Inserisci i dati a mano");
                System.out.println("6: Torna al menu principale");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consuma il newline lasciato da nextInt()
```
In questa fase passiamo a ciascun main il nome del database (databaseName) come unico elemento dell'array String[]
```
try {
                    switch (choice) {
                        case 1:
                            InserisciDummyDatas.main(new String[] { databaseName });
                            break;
                        case 2:
                            SalvaInCSV.main(new String[] { databaseName });
                            break;
                        case 3:
                            ModificaDati.main(new String[] { databaseName });
                            break;
                        case 4:
                            CancellaDati.main(new String[] { databaseName });
                            break;
                        case 5:
                            InserisciManual.main(new String[] { databaseName });
                            break;
                        case 6:
                            System.out.println("Torna al menu principale.");
                            backToMainMenu = true;
                            break;
                        default:
                            System.out.println("Opzione non valida. Riprova.");
                    }
```
Il  programma per fornirci maggiore chiarezza stampa i dati del database dopo ogni azione, eccetto all'uscita, eseguendo il file VisualizzaDati
```
        if (cont) {
            VisualizzaDati.main(new String[] { databaseName });
        }
```
Gestiamo le eccezioni attraverso il catch
```
 } catch (Exception e) {
                    System.out.println("Si è verificato un errore: " + e.getMessage());
                    scanner.close();
                }
            }

        }
```
Il codice dentro finally verrà eseguito indipendentemente dal fatto che un'eccezione sia stata lanciata o meno.

## Problemi con scanner.close()

Il metodo close() dell'oggetto Scanner chiude solo quello specifico oggetto Scanner su cui viene chiamato. Non influisce sugli altri oggetti Scanner che
potresti avere nel tuo programma. Tuttavia, è importante notare che se due oggetti Scanner stanno leggendo dalla stessa sorgente (come System.in), chiudere uno di questi oggetti Scanner interromperà anche l'altro. Questo accade perchè la chiusura di uno Scanner chiuderà anche la sua sorgente di input se quella sorgente implementa l'interfaccia Closeable. Poichè System.in è una sorgente di input Closeable, chiudendo uno Scanner che legge da System.in, System.in sarà chiuso e quindi non sarà più disponibile per la lettura da parte di altri oggetti Scanner.

```
        scanner.close();
    }
}
```

# Crea Database

Il primo compito di questa applicazione è quindi la **creazione** di un database contenente due tabelle: *Prodotti* e *Categorie*.

La tabella *Categorie* è composta da 2 Colonne:
* la prima colonna appartiene all'*ID della categoria* ovvero un numero che viene assegnato automaticamente ad ogni categoria inserita. A questa colonna viene assegnata una chiave primaria che sarà successivamente collegata nella tabella prodotti ad una chiave esterna, questo metterà in relazione le due tabelle e permettetterà di identificare in modo univoco ogni riga.

* la seconda invece appartiene al *Nome* della categoria, che specificherà così a quale categoria appartengono i prodotti con l'id relativo.


Nella tabella Prodotti vengono invece create 5 colonne:
* la prima colonna appartiene all'*ID del prodotto* che associa un numero univoco per ogni prodotto
* La seconda corrisponderà al *nome del prodotto* quindi conterrà dati in formato text. (Esempio 'Mela')
* La terza colonna rappresenterà la *quantità del prodotto* (quindi conterrà dati di tipo integer) (Esempio 12)
* La quarta sarà del *Prezzo*, in formato real overo accetterà dati sottoforma di numeri decimali (Esempio 0,99)
* La quinta colonna sarà invece assegnata all'*id categoria di appartenenza*, quest'ultima infatti è collegata tramite una chiave esterna all'id della tabella categorie. In questo modo potrò assegnare in modo univoco un prodotto ad una categoria

## Classi importate

* java.sql.Connection


* java.sql.DriverManager
* java.sql.SQLException
* java.sql.Statement

## Codice

Se non viene assegnato nessun nome al database il programma darà un nome di default: "database_collegato"
```
public class CreaDatabase {
    public static void main(String[] args) {
if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_collegato' come nome di default.");
            args = new String[] { "database_collegato" };
        }
```
Stabiliamo la connessione al database, definiamo un oggetto chiamato conn dalla classe Connection
```
Connection conn = null;
```
Per gestire le eccezioni utilizziamo un try-catch, all'interno carichiamo il driver Java Database Connectivity di SQlite

```
        try {
            
            Class.forName("org.sqlite.JDBC");
```
Stabilisco la connessione al databse, all'indirizzo url viene passato args[0] corrispondente al nome del database, in quanto si trova all'indice 0 di args che è un array di stringhe
```
            String url = "jdbc:sqlite:" + args[0] + ".db";//
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");
```
Scriviamo la query per la creazione della tabella "categorie"

```
String sqlCreaTabellaCategorie = "CREATE TABLE IF NOT EXISTS categorie (" +
                    "id INTEGER PRIMARY KEY," +
                    "nome TEXT NOT NULL" +
                    ");";
```
Successivamente scriviamo query per la creazione della tabella "prodotti"

```
String sqlCreaTabellaProdotti = "CREATE TABLE IF NOT EXISTS prodotti (" +
                    "id INTEGER PRIMARY KEY," +
                    "nome TEXT NOT NULL," +
                    "quantita INTEGER NOT NULL," +
                    "prezzo REAL NOT NULL," +
                    "id_categoria INTEGER NOT NULL," +
                    "FOREIGN KEY(id_categoria) REFERENCES categorie(id)" +
                    ");";
```
Viene utilizzato IF NOT EXIST per evitare di creare dei duplicati se la tabella è già esistente.


Eseguiamo le istruzioni sql con un oggetto Statement (stmt) e stampiamo un messaggio di avvenuta creazione.
```
Statement stmt = conn.createStatement();
            stmt.execute(sqlCreaTabellaProdotti);
            stmt.execute(sqlCreaTabellaCategorie);

            System.out.println("Tabelle create con successo.");
```

Tramite la clausola catch gestiamo le eccezzioni e nel finally chiudiamo la connessione al database

```
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
```


Visualizza dati = replace in output evitando incomprensioni tra punto e virgola, guarda in condivisi REPLACE, metodo java per la gestione delle stringhe----> EMANUELE TIZIANO GIORGIO

Modifica dati e inserisci Manuale = verificare che funzioni con punto o con virgola----> DAVIDE E SIMONE

Controllare in tutti i file o prima o dopo, in Modifica dati ci interessa vederlo sia prima che dopo, quindi sia prima che dopo



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
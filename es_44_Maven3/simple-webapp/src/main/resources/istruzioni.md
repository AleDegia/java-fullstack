lancio il codice nella rotta della cartella mvn

(dopo aver installato maven, se non lo ho gia presente..):

mvn archetype:generate -DgroupId=com.example -DartifactId=simple-webapp -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

- aggiungere il nodo dependency nel codice del pom sotto dependencies

<dependency>
        <groupId>org.xerial</groupId>
        <artifactId>sqlite-jdbc</artifactId>
        <version>3.42.0.0</version>
    </dependency>



mvn compile   per compilare  (sulla rotta simple-webapp) (va fatto ogni volta che faccio un nuovo file, nella rotta simple-webapp, prima dell exec)


librerie da importare nel file java:

import java.sql.Connection  -> crea la connessione con il database
import java.sql.DriverManager;   //ci mette in connessione con il database
import java.sql.SQLException;    //come gestisce le eccezioni sqlite
import java.sql.Statement;      //serve pre creare la query


string sql : in maiuscolo le operazioni da eseguire

scaricare estensione sqlite viewer


(sempre nella rotta simple-webapp)

mvn exec:java -Dexec.mainClass="CreaDB"

mvn exec:java -Dexec.mainClass="AggiungiColonne"

mvn exec:java -Dexec.mainClass="InserisciDati"
...


+ " id integer PRIMARY KEY,\n"

//La specifica PRIMARY KEY indica che questa colonna sarà la chiave primaria della tabella, il che significa che conterrà un valore univoco per ogni riga e identificherà 
univocamente ogni riga nella tabella.(come fosse il suo codice fiscale..) Stiamo dicendo che l'attributo 'id'aavrà uno ed un solo valore. se hai l'id di una categoria, 
puoi facilmente recuperare le informazioni associate a quella categoria dal database utilizzando la chiave primaria.



+ " FOREIGN KEY(id_categoria) REFERENCES categorie(id)\n"

foreign key :  una "chiave esterna" (foreign key) è un vincolo che collega i dati in una tabella con i dati in un'altra tabella. 

FOREIGN KEY(id_categoria)
Questa parte indica che stiamo creando una chiave esterna nella colonna 'id_categoria' della tabella 'prodotti'. Questa colonna conterrà valori che fanno riferimento agli
 'id' presenti nella tabella 'categorie'.

REFERENCES categorie(id)
Indica che la colonna 'id_categoria' della tabella 'prodotti' fa riferimento alla colonna 'id' della tabella 'categorie'. In altre parole, i valori inseriti nella colonna
 'id_categoria' di 'prodotti' devono corrispondere a valori validi presenti nella colonna 'id' di 'categorie'.


L'utilità della chiave esterna sta nel creare relazioni tra le tabelle, consentendo di collegare dati correlati 


in ordine:

CreaDBCollegato
InserisciDatiCollegati   (nulla di che qua, solo inserito nelle due tabelle, nelle rispettive colonne, dei dati)
SelezionaDatiCollegati
SalvaCSV
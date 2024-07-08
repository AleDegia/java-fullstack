# Main.js

il file Main .js è l'entry point dell'applicazione che permette di selezionare le azioni possibili attraverso 2 menu collegati
inoltre questo files passa alle altre classi delle informazioni attravwerso il metodo main
il file main ha il compito di gestire le sessioni del database attraverso il blocco finally che gestisce la connessione  al database

Abbiamo utilizzato delle classi specifiche tipo ad esempio import java.util.Scanner; che ha dato il seguente problema:
nonostante che vengano creati più oggetti scanner con nomi diversi, comunque la chiusura di uno scanner influisce sulla chiusura di tutti gli altri quindi quando facciamo scanner.close da errore in quanto l'isruzione successiva trova l'oggetto già chiuso
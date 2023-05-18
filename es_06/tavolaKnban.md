# Tavola Kanban - 1 settimana

- Ho imparato che alcuni rudimenti valgono per indipendentemente dal linguaggio di programmazione utilizzato 
> Ad esempio in tutti i linguaggi esistono le variabili e le costanti  
Posso dichiarare una variabile specificando il tipo (ad esempio int) ed impostando un nome  
int a  
Posso anche assegnare un valore specifico ad una variabile così:  
int a = 1
- Ho imparato che ci sono diversi tipi di variabili ed alcune volte capita che java non capisca quale variabile voglio utilizzare  
> Ad esempio l'input dell'utente viene sempre interpretato come una stringa e quindi se voglioeffettuare delle operazioni devo specificare alcune cose aggiuntive tipo
.nextInt che si utilizza con variabili intere altrimenti genera un errore  
- Ho imparato che ogni linguaggio di programmazione ha la sua sintassi specifica  
> Ad esempio in java le istruzioni terminano con il segn ; oppure ad esempio il nome della classe in java deve corrispondere al nome del file .java tipo così:
public class calcolaPerimetroArea {  
}

- Ho imparato che i blocchi di codice sono raggruppati all'interno di parentesi graffe
> Ad esempio un programma java vuoto tipo il nostro layout ha comunque due parti fisse che sono la classe ed il metodo main 
C
- Ho imparato che è importantissimo gestire la formattazione del documento in modo che le parentesi graffe siano allineate verticalmente (apertura chiusura)
> Ad esempio 
public class calcolaPerimetroArea {  
    psvm
}

- Ho imparato che per inserire il codice in un documento md come questo è meglio includere il codice in una sezione che inizia e finisce con 3 backticks (ho imparato che si fanno con ALT+96)
> Ad esempio
 ` ` `
 public class CalcolaPerimetroArea{
    public static void main (String[] args)
 }
 ` ` `
 - Ho imparato che c'è un formato creato apposta per fare i files readme di documentazione del codice
 > Ad esempio è possibile formattare il testo impsotando alcuni attributi come il grassetto oppure il corsivo, così:
 **questo testo è in grassetto**
 _questo testo è italic_  
 ho consultato informazioni aggiuntive riguardanti il formato md qui:  
 ...  
 - Ho imparato che altri programmatori e sviluppatori più pratici di me hanno reso disponibile la loro esperienza lavorativa sul sito jetbrains.com  
 > Ad esempio su questo sito ho potuto confrontare i vari linguaggi più promettenti basandomi sul confronto con gli anni precedenti (**parte dal 2017**)
 - Ho imparato che i programmatori, i web designer o gli sviluppatori di contenuti in genere utilizano un sistema di versionamento del codice che permette di avere un
 ambiente di lavoro più sicuro in quanto posso sempre tornare indietro a delle modifiche effettuate in precedenza ed in più attraverso i branch (**che non ho ancora utilizzato**)
 che permettono di lavorare al codice in un ambiente condiviso tra più collaboratori.  
 > Ad esempio ho creato un nuovo repository e tramite una sequenza ben precisa di comandi ho caricato alcuni files che ho creato e li ho aggiunti ad un'area di versionamento
 (**staging area**)
 - Ho anche imparato che questi comandi devono essere riprodotti in un'ordine specifico 
 - Ad esempio i comandi per effettuare un aggiornamento di un contenuto sono:  
    - git add <nomefile>(aggiunge il contenuto alla staging area)
    - git commit -n "messaggio" (mi permette di fare un commit e cioè un salvataggio di questa versione specifica ed assegna un nome a questo commit specifico al fine di essere
    richiamato in un secondo tempo)
    - git push -u origin main (mi permette di caricare il contenuto che ho aggiunto in precedenza)  
- ci sono anche altri comandi che invece servono per verificare lo stato della nostra origine o del nostro repository remoto  
> Ad esempio i comandi
- git status 
- git log  

- Ho imparato che il codice java deve essere compilato per poter essere eseguito successivamente con questi due comandi
javac <nome files ed estensione>
java <nome file>  
- Ho imaprato che però non posso eseguire o compilare un codice o dei files che non sono nella stessa rotta del comando, cioè i comandi vanno eseguiti proprio nella rotta dove ho 
salvato il file che voglio eseguire o compilare
- Ho imparato che per poterlo fare ci sono alcuni comandi che mi permettono di muovermi tra le varie cartelle
> Ad esempio il comando cd <nome cartella> mi permette di creare nuove cartelle, ed il comando  code <nome cartella> mi permette di creare nuovi files 

Altri utili che ho utilizzato sono il comando **ls** che mi permette di vedere il contenuto della cartella nella quale mi trovo 

**IMPORTANTE** ho imparato che è più semplice utilizzare il comando cd e trascinare l'icona della cartella invece che scrivere la rotta del file 

- Ho imparato a configurare la mia area di lavoro è cioè ho installato le jdk (le librerie che sevono per poter utilizzare il linguaggio java) e l'IDE VisualStudio Code
> Ma ho subito scoperto che da solo non è in grado di gestire un linguaggio specifico come java, quindi ho dovuto installare anche altre estebsioni aggiuntive. A questo punto
anche se sembrava tutto apposto in realtà ci sono stati alcuni problemi di configurazione che hanno riguardato più che altro alcune differenze tra il mio computer e quello dei
miei colleghi
- Ho imparato a usare Git per poter savlare tutte le modifiche che apporto ai lavori in corso e per far si di poter tornare facilmente alle versioni precedenti 
- Ho imparato ad usare Github per poter visualizzare i miei file e quelli dei colleghi
- Ho imparato ad utilizzare gli operatori +, -, * e / per effettuare operazioni aritmetiche
- Ho imparato che il + può essere utilizzato anche per concatenare delle stringhe tra di loro, come anche stringhe e variabili 
- ho imparato ad usare le funzionalità || e &&, rispettivamente "or" e "and", per avere dei paletti in più in modo da poter effettuare operazioni più specifiche (che si chiamano pipe)
- Ho imparato ad usare il costrutto if per far si che venga effettuato un comando solo se la condizione tra () è vera o falsa
- Ho imparato che utilizzando ! davanti a ciò che dichiaro tra le () dell'if serve a dire che la condizione è falsa (poichè le condizioni tra parentesi sono intese come vere di default)
- Ho imparato che se la condizione tra le parentesi tonde dell'if non è vera, a meno che io non stia utilizzando un !, non verà eseguito ciò che c'è tra le parentesi graffe ed il programma passerà direttamente all'istruzione successiva
- Ho imparato che usando Else dopo aver utilizzato un costrutto if serve posso andare a prendere in considerazione tutte le altre condizioni che non rientrano nella casistica descritta dall'if
- Ho imparato che andando a selezionare il codice che ho scritto, premendo il tasto destro del mouse e selezionando format document, il tutto verrà indentato in maniera ordinata direttamente dal programma
- Ho imaprato a salvare velocemente un file tramite ctrl + s 
- Ho imparato che se sono bloccato nel terminale per uscire posso utilizzare ctrl + c
- Ho imparato che il punto è un operatore di accesso ad altri dati/membri
- Ho imparato la differenza tra array e liste : gli array sono elenchi di variabili di uno stesso tipo e di un numero predefinito che mi è già noto  string[] z = new string[3], mentre le liste sono molto simili ma si utilizzano con le parentesi tonde   list bb = new List()   e servono proprio quando non abbiamo già un numero predefinito di elementi o quando il numero delle variabili potrebbe cambiare nel tempo 
- Ho imparato che utilizzando il nome della lista più .add posso aggiungere un elemento all'arraylist
- Ho imparato che con Altgr + maiusc + { } posso creare delle parentesi graffe 
- Ho imparato che la U affianco ad un documento sta per Updated 
- Ho imparato per caso che con ctrl + Maiusc + "+" o "-" posso zoommare o rimpiccilire lo schermo su visual studio code
- con /n posso mandare la stringa a capo 
- git add --all aggiunge tutto, sennò anche git add (aggiungono tutto quello che c'è nella cartella in cui mi trovo)
(assicurarsi che la cartella che voglio caricare sia nella rotta dove abbiamo il .git, faccio git status per vedere se è in staged area o no)
**Non mi è ancora chiaro al 100% perchè non riesca ad aggiungere il mio file a github nonostante il primo di esercizio io sia riuscito ad aggiungerlo correttamente**
- se non metto l'estensione .java quando faccio code + nome mi creerà un file di testo di default 
- il nome della classe del mio file java deve essere uguale al file 



import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Corpo {

    public void esecuzione(){

    LeggiFile a = new LeggiFile();
    a.leggi();
    Scanner input = new Scanner(System.in);
    List<String> azioniScelte = new ArrayList<String>();
    //List<String> azioniDisponibili = new ArrayList<String>();

    String  csvFile= "C:/Users/Java/Documents/corso java/java_workspaces/esercitazioni/esBorsaAle/esBorsaClassi/azGxG.csv";
    String header = "Giorno, Nome, Prezzo\n";
    List<String> data = new ArrayList<String>();
    //List<String> giorniScelti = new ArrayList<String>();

    Amazon amazonObj = new Amazon("Amazon", 100);

        String amazon = "amazon"; //per usare l'equals
        String meta = "meta";
        String twitter = "twitter";
        String zoom = "zoom";
        String jj = "jj";
        String alibaba = "alibaba";

        String conferma = "fine";
        String azioneScelta = "b";

        while (!azioneScelta.equalsIgnoreCase("fine")) {
            System.out.println(
                    "quali azioni vuoi monitorare tra " + a.azioniDisponibili + " digita 'fine' per terminare la scelta");
            azioneScelta = input.next();

            if (azioneScelta.equals(conferma)) {
                break;
            } else {
                a.azioniDisponibili.remove(azioneScelta);
                azioniScelte.add(azioneScelta);
                //portafoglio.add(azioneScelta);
                System.out.println("le azioni scelte: " + azioniScelte);
            }
        }
        double prezzoInizialeAmazon = 100;
        double prezzoInizialeMeta = 149.33;
        double prezzoInizialeTwitter = 20.83;
        double prezzoInizialeZoom = 32;
        double prezzoInizialeJJ = 55.2;
        double prezzoInizialeAlibaba = 267.5;

        int[] giorni = { 1, 2, 3, 4, 5, 6, 7 };
        List<Integer> giorniScelti = new ArrayList<Integer>();
        Random rand = new Random();

        System.out.println(
                "per che giorni vuoi vedere i prezzi delle azioni scelte? (scrivi \"0\" per terminare l'inserimento)");
        int giorno = input.nextInt();

        while (giorno != 0) // creo un ciclo while che mi permette di inserire numeri finch� non scrivo 0
        {
            giorniScelti.add(giorno);
            giorno = input.nextInt();
        }

        double sommaVariazioniAmazon = 0;
        double prezzoVariatoAmazon = 0;
        double sommaVariazioniMeta = 0;
        double prezzoVariatoMeta = 0;

        for (int i = 1; i <= giorni.length; i++) {
            // if (giorniScelti.contains(i)) {
            double variazDaily = rand.nextDouble(-3, +3);
            double variazDailyAmazon = rand.nextDouble(-3, +3);
            double variazDailyMeta = rand.nextDouble(-3, +3); // assegno un valore casuale tra -3 e 3, e lo assegno per ogni azione
 
            variazDaily = rand.nextDouble(-3, +3);
            double prezzoVariatoTwitter = prezzoInizialeTwitter + variazDaily;
            variazDaily = rand.nextDouble(-3, +3);
            double prezzoVariatoZoom = prezzoInizialeZoom + variazDaily;
            variazDaily = rand.nextDouble(-3, +3);
            double prezzoVariatoJJ = prezzoInizialeJJ + variazDaily;
            variazDaily = rand.nextDouble(-3, +3);
            double prezzoVariatoAlibaba = prezzoInizialeAlibaba + variazDaily;

            
            sommaVariazioniAmazon = sommaVariazioniAmazon + variazDailyAmazon;
            sommaVariazioniMeta = sommaVariazioniMeta + variazDailyMeta;

            // if (giorniScelti.contains(i)) {
            if (azioniScelte.contains(amazon))
            {
                if (variazDailyAmazon > 0) {
                    prezzoVariatoAmazon = (((prezzoInizialeAmazon / 100) * variazDailyAmazon) + prezzoInizialeAmazon);
                    prezzoInizialeAmazon = prezzoVariatoAmazon;
                    if (giorniScelti.contains(i)) {
                        System.out.println("        GIORNO " + i);
                        System.out.println("prezzo di oggi: " + prezzoVariatoAmazon);
                        System.out.println("var daily: " + Math.round(variazDailyAmazon * 100.0) / 100.0 + "%");
                        System.out.println("la variazione percentuale al giorno " + i + " rispetto al giorno 0 è di "
                                + Math.round(sommaVariazioniAmazon * 100.0) / 100.0 + "%");
                        System.out.println();
                        data.add(String.valueOf(i+","+ amazonObj.getNome()+ "," + String.valueOf(prezzoVariatoAmazon)));
                    }
                } else if (variazDailyAmazon < 0) {
                    prezzoVariatoAmazon = (((prezzoInizialeAmazon / 100) * variazDailyAmazon) + prezzoInizialeAmazon);
                    prezzoInizialeAmazon = prezzoVariatoAmazon;
                    if (giorniScelti.contains(i)) {
                        System.out.println("        GIORNO " + i);
                        System.out.println("prezzo di amazon del giorno: " + prezzoVariatoAmazon);
                        System.out.println("var daily: " + Math.round(variazDailyAmazon * 100.0) / 100.0 + "%");
                        System.out.println("la variazione percentuale al giorno " + i + " rispetto al giorno 0 è di "
                                + Math.round(sommaVariazioniAmazon * 100.0) / 100.0 + "%");
                        System.out.println();
                        data.add(String.valueOf(i+","+ amazonObj.getNome()+ "," + String.valueOf(amazonObj.getPrezzoAzioneAmazon())));
                        
                       
                    }
                } 
                
            }
            if (azioniScelte.contains(meta)) {
                prezzoVariatoMeta = (((prezzoInizialeMeta / 100) * variazDailyMeta) + prezzoInizialeMeta);
                prezzoInizialeMeta = prezzoVariatoMeta;
                if (giorniScelti.contains(i)) {
                    System.out.println("il prezzo di meta nel giorno " + i + " è " + prezzoVariatoMeta);
                    System.out.println("la variazione percentuale di oggi è di "
                            + (Math.round(variazDailyMeta * 100.0) / 100.0 + "%"));
                    //double var = (((prezzoVariatoMeta - prezzoInizialeMeta) / prezzoInizialeMeta) * 100);
                    // double varGiorno= 0 + var;
                    System.out.println("la variazione percentuale rispetto al giorno 0 è di " + (Math.round(sommaVariazioniMeta * 100.0) / 100.0 + "%"));
                    System.out.println();
                }
            }
            if (azioniScelte.contains(twitter)) {
                System.out.println("il prezzo di twitter nel giorno" + i + " è " + prezzoVariatoTwitter);
                System.out.println("la variazione percentuale rispetto al giorno 0 è di "
                        + (((prezzoVariatoTwitter - prezzoInizialeTwitter) / prezzoInizialeTwitter) * 100) + "%");
            }
            if (azioniScelte.contains(zoom)) {
                System.out.println("il prezzo di zoom nel giorno " + i + " è " + prezzoVariatoZoom);
                System.out.println("la variazione percentuale rispetto al giorno 0 è di "
                        + (((prezzoVariatoZoom - prezzoInizialeZoom) / prezzoInizialeZoom) * 100) + "%");
            }
            if (azioniScelte.contains(jj)) {
                System.out.println("il prezzo di j&j nel giorno " + i + " è " + prezzoVariatoJJ);
                System.out.println("la variazione percentuale rispetto al giorno 0 è di "
                        + (((prezzoVariatoJJ - prezzoInizialeJJ) / prezzoInizialeJJ) * 100) + "%");
            }
            if (azioniScelte.contains(alibaba)) {
                System.out.println("il prezzo di alibaba nel giorno " + i + " è " + prezzoVariatoAlibaba);
                System.out.println("la variazione percentuale rispetto al giorno 0 è di "
                        + (((prezzoVariatoAlibaba - prezzoInizialeAlibaba) / prezzoInizialeAlibaba) * 100) + "%");
            }
        }
        /*for(String dati:data){
        System.out.print("Giorno " + dati);}*/

        FileWriter fileWriter = null;

    try{
        fileWriter = new FileWriter(csvFile);

        fileWriter.append(header);

        for(String line : data){
        fileWriter.append(line);
        fileWriter.append("\n");
    }

     System.out.println("File CSV creato con successo");
    
   
} catch(Exception e){
    System.out.println("errore in CsvfileWriter");
    e.printStackTrace();  //teniamo traccia dell'errore
} finally{
    try{
        fileWriter.flush();
        fileWriter.close();

    } catch (IOException e){
        System.out.println("errore durante il flush/close");
        e.printStackTrace();
    }
}
    }}


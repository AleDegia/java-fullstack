import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeggiFile {
    List<String> azioniDisponibili = new ArrayList<String>();

    public void leggi() {
        String csvFile = "C:/Users/Java/Documents/corso java/java_workspaces/esercitazioni/esBorsaAle/esBorsaClassi/azioni.csv";
        String line = "";
        String csvSplitBy = ",";  // specifico il divisore del csv
        
        //Set<String> dateUniche = new HashSet<>();  // creo una tabella che conterrà le date senza ripetizioni
        

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
            String[] campo = line.split(csvSplitBy);
                azioniDisponibili.add(campo[0]);
                azioniDisponibili.remove("Nome");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(azioniDisponibili);

        /*System.out.println("Date disponibili:");
        for (String data : dateUniche) {
            System.out.println(data);
        }*/
    }}

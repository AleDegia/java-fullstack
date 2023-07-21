//package java_workspaces.java-fullstack-assignment.es_30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) {
        String csvFile ="C:/Users/Java/Documents/corso java/java_workspaces/java-fullstack-assignment/es_30/prodotto.csv";
        String line = "";
        String csvSplitBy = ",";  //specifico il divisore del csv
        int contatoreFrutta=0;

        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){

            while ((line = br.readLine()) != null){
    
                //usa la virgola come separatore
                String [] prodotto = line.split(csvSplitBy);// il metodo split divide il csv al delimitatore

                if(prodotto[2].equalsIgnoreCase("Frutta")){
                    contatoreFrutta++;
                }
    
    }
}

catch(IOException e){
    e.printStackTrace();
}}}

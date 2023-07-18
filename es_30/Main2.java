//package java_workspaces.java-fullstack-assignment.es_30;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main2 {
    public static void main(String[] args) {
        String csvFile ="C:/Users/Java/Documents/corso java/java_workspaces/java-fullstack-assignment/es_30/prodotto.csv";
        String line = "";
        String csvSplitBy = ",";  //specifico il divisore del csv
        int comparatorefrutta=0;
    

    try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){

        while ((line = br.readLine()) != null){

            //usa la virgola come separatore
            String [] prodotto = line.split(csvSplitBy);// il metodo split divide il csv al delimitatore

            System.out.println("Prodotto[ID=" + prodotto[0]
            + ", Nome =" + prodotto[1]
            + ", Categoria =" + prodotto[2]
            + ", Prezzo =" + prodotto[3]
            + ", Quantita =" + prodotto[4]
            + ", DataVendita =" + prodotto[5] + "]");

        }

    }catch(IOException e){
        e.printStackTrace();
    }
}}

//package java_workspaces.java-fullstack-assignment.es_30;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main4 {
    public static void main(String[] args) {
        String csvFile ="C:/Users/Java/Documents/corso java/java_workspaces/java-fullstack-assignment/es_30/prodotto.csv";
        String line = "";
        String csvSplitBy = ",";  //specifico il divisore del csv
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci una data nel formato YYYY-MM_GG");
        String dataInserita= scanner.nextLine();
    

    try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){

        while ((line = br.readLine()) != null){

            String [] prodotto = line.split(csvSplitBy);

            if(prodotto[5].equals(dataInserita)){
                System.out.println("Prodotto [ID=" + prodotto[0]
                + ", Nome =" + prodotto[1]
                + ", Categoria =" + prodotto[2]
                + ", Prezzo =" + prodotto[3]
                + ", Quantita =" + prodotto[4]
                + ", DataVendita =" + prodotto[5] + "]");
            }

    }

}
catch (IOException e) {
    e.printStackTrace();
}
    }}
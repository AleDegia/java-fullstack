
//package java_workspaces.esercitazioni.es_indovina_numero;
import java.util.Scanner;

public class indovinaNumero {
    public static void main(String[] args) {
        // int [] array = new int [100];
        int numeroGiusto = 77;
        int numeroScelto = 0;
        int numerotentativi = 0;
        //int numeroTentativiMassimi = 10;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Inserisci un numero per indovinare il numero target");
            numeroScelto = input.nextInt();
            numerotentativi++;
        } 
        while ((numeroScelto != numeroGiusto) && numerotentativi<10); // eseguito soltanto se la condizione è soddisfatta
        if(numeroScelto != numeroGiusto){
            System.out.println("hai esaurito i tentativi");
        }
        else{
        System.out.println("il numero è giusto!");
        input.close();
    }
    }
}


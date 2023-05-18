//package java_workspaces.java-fullstack-assignment.es_16;
import java.util.Scanner;

public class doWhileLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;
        do{ //viene eseguito perciò almeno la prima volta
            System.out.println("Inserisci un numero (inserisci 0 per uscire): ");
            num = input.nextInt();
            System.out.println("Hai inserito: "+ num);
        }
        while (num !=0); //eseguito soltanto se la condizione è soddisfatta
        input.close();
    }
    
}

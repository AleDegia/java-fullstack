//package java_workspaces.esercitazioni.es_Random3;
import java.util.Random;
import java.util.Scanner;

public class esRandom3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int numeroDaIndovinare = rand.nextInt(100)+1;
        System.out.println(numeroDaIndovinare);
        int numeroDiTentativi = 0;
        Scanner input = new Scanner(System.in);
        int tentativo;
        boolean vincita = false;

        while (vincita == false){
            System.out.println("indovina un numero tra 1 e 100: ");
            tentativo = input.nextInt();
            numeroDiTentativi++;

            if (tentativo == numeroDaIndovinare){
                vincita = true;
            }
            else if (tentativo < numeroDaIndovinare){
                System.out.println("Troppo basso prova ancora!");
            }
            else if (tentativo > numeroDaIndovinare){
                System.out.println("troppo alto! Prova ancora!");
            }
        }
        System.out.println("bravo! Hai indovinato il numero dopo" + numeroDiTentativi + "tentativi");
    }
    
}

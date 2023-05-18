import java.util.Scanner;

public class InputType {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci un numero decimale: ");
        double num1 = input.nextDouble();
        System.out.print("Inserisci una stringa: ");
        String str = input.next(); // nextline legge anche il carattere di a capo dopo il numero decimale
        System.out.println("Inserisci un carattere: ");
        char c = input.next().charAt(0);
        System.out.println("Il numero decimale inserito è: " + num1);
        System.out.println("La stringa inserita è: " + str);
        System.out.println("Il carattere inserito è: " + c);
    }
}
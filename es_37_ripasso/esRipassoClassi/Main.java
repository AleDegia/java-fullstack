import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int numeroCasuale = rand.nextInt(100) + 1;
        Giocatore giocatore = new Giocatore("Pippo", 3);
        Gioco gioco = new Gioco(numeroCasuale, giocatore);

        gioco.gioca();
    }
}

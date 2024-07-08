import java.util.Scanner;

public class Gioco {
    private int numeroCasuale;
    Giocatore giocatore;

    public Gioco(int numeroCasuale, Giocatore giocatore) {
        this.numeroCasuale = numeroCasuale;
        this.giocatore = giocatore;
    }

    public void gioca() {
        Scanner input = new Scanner(System.in);

        System.out.println("Indovina il numero tra 1 e 100");
        System.out.println("Inserisci il tuo nome: ");

        String nome = input.nextLine();
        giocatore.setNome(nome);

        boolean indovinato = false;

        while (!indovinato/*indovinato==false */ && giocatore.getTentativi() < 5) { //!indovinato sta a dire false
            System.out.println("Inserisci il tuo tentativo");
            int tentativo = input.nextInt();
            giocatore.setTentativi(giocatore.getTentativi() + 1);

            if (tentativo == numeroCasuale) {
                System.out.println("Complimeti, " + giocatore.getNome() + "hai indovinato il numero in "
                        + giocatore.getTentativi() + " tentativi");
                indovinato = true;
            } else if (tentativo < numeroCasuale) {
                System.out.println("il numero inserito" + tentativo + "è minore del numero giusto");
            } else {
                System.out.println("il numero inserito" + tentativo + "è maggiore del numero giusto");
            }
        }
        if (!indovinato) {
            System.out.println("Mi dispiace, " + giocatore.getNome() + " hai esaurito i tentativi. Il numero era "
                    + numeroCasuale);
        }
        input.close();
    }

}

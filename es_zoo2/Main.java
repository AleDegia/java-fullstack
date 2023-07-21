public class Main {
    public static void main(String[] args) {
        Fattoria fattoria = new Fattoria();

        Animale mucca = new Mucca("Bianca");
        Animale gallina = new Gallina("Nera");

        fattoria.aggiungiAnimale(gallina);
        fattoria.aggiungiAnimale(mucca);

        fattoria.faRumore();
    }
}

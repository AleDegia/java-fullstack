public class Main {
    public static void main(String[] args) {
        //Amazon amazon = new Amazon("Amazon", 100);

        LeggiFile leggiFile = new LeggiFile();
        leggiFile.leggi();
        Corpo corpo = new Corpo();
        corpo.esecuzione();
    }
}

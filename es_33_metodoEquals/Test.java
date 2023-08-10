public class Test {
    public static void main(String[] args) {//vogliamo sapere le gli attributi degli oggetti sono uguali
        Impiegatoo i = new Impiegatoo();
        i.setCognome("Rossi");
        i.setNome("Mario");

        Impiegatoo t = new Impiegatoo();
        t.setCognome("Rossi");
        t.setNome("Mario");

        if(i.getCognome().equals(t.getCognome())&& i.getNome().equals(t.getNome()))
            System.out.println("le due istanze sono uguali");
        else
            System.out.println("sono diverse");
    }
}

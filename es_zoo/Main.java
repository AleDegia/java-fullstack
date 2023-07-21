    public class Main{
    public static void main(String[] args) {

        Leone leone = new Leone("Jack");
        Pitone pitone = new Pitone("Carl");
        
        leone.stampa(); //utilizo il metodo di stampa della superclasse Animale
        System.out.println(); //riga vuota
        pitone.stampa();
    }
}

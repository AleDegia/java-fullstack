public class Main {
    public static void main(String[] args) {
        PassaggioParametri p = new PassaggioParametri();

        //per valore
        int count = 15;
        p.hello(count);
        System.out.println(count);
        //risultato è 15 perchè vengono create due variabili: una è count a cui diamo il valore di 15, ed una è x che copia il valore di count, cioè 15.
    }
}

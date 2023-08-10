public class PassaggioParametri {
    public int hello(int x){ ///risultato è 15 perchè vengono create due variabili: una è count a cui diamo il valore di 15, ed una è x che copia il valore di count, cioè 15.
        x++; //qua x va a 16 ma noi nel main stampiamo count che è sempre 15
        return x;
    }
}

import java.util.List;
import java.util.ArrayList;

public class Main { //ad ogni identificativo paziente associo il numero di esami fatti dal paziente
    public static void main(String[] args) {
        Paziente paz1 = new Paziente(3, 113, "Mario", "Rossi");
        Paziente paz2 = new Paziente(2, 155, "Gino", "Rossi");
        Paziente paz3 = new Paziente(5, 12, "Luca", "Rossi");
        
        System.out.println(paz1.getNome());
        System.out.println(paz1.getCognome());
        System.out.println("Priorità: " + paz1.getPriorita());
        System.out.println("Identificativo: " + paz1.getIdentificativo());


        List<Paziente> pazienti = new ArrayList<Paziente>();
        pazienti.add(paz1);
        pazienti.add(paz2);
        pazienti.add(paz3);
        
        for(Paziente paz : pazienti){
            System.out.println("Priorità: " + paz.getNome() );
        }  
    }

        Esame cardiaco = new Esame (10, 155);
        Esame dentale = new Esame(22, 113)

        List<Esame> listaEsami = new Arraylist<Esame>();
        for


    
}

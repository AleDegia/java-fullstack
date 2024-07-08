//package java_workspaces.esercitazioni.es_Random;
//package java_workspaces.esercitazioni.es_indovina_numero3;

import java.util.Random;

public class esRandom {
    public static void main(String[] args) {
        Random rand = new Random();

        //generare un numero intero casuale
        int randomInt = rand.nextInt(80); //genera un numero intero casuale tra 0(incluso) e 100(escluso)(prende la generazione casuale in input)
        System.out.println("numero intero casuale: "+ randomInt);
        
        //generare un numero double casuale
        double randomDouble = rand.nextDouble();//genera un numero double casuale tra 0.0 e 1 escluso
        System.out.println("Numero double casuale: "+ randomDouble);

        //generare un valore booleano casuale
        boolean RandomBoolean = rand.nextBoolean();// genera un valore booleano casuale
        System.out.println("Valore booleano casuale: "+ RandomBoolean);

        if(randomInt<60 && RandomBoolean==true){
            System.out.println("hai vinto!");
        }
        else{
            System.out.println("hai perso");
        }
    }
    
}

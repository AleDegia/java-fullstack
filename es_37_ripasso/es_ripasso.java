import java.util.Scanner;



public class es_ripasso {
    public static void main(String[] args) {
        int numeroWin = 8;
        Scanner input = new Scanner(System.in);

        System.out.print("inserisci un numero da 0 a 10 ");
        int numeroInserito = input.nextInt();

        if(numeroWin!=numeroInserito){
            
            System.out.println("ritenta con altro numero");
            while(numeroInserito<numeroWin){
                System.out.println("il numero inserito" + numeroInserito + "è minore del numero giusto");
                numeroInserito = input.nextInt();
            } while (numeroInserito>numeroWin){
                System.out.println("il numero inserito" + numeroInserito + "è maggiore del numero giusto");
                numeroInserito = input.nextInt();
            };}

            if(numeroInserito==numeroWin){
                System.out.println("hai indovinato!");
                
            }
        
    }}


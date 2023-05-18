//package java_workspaces.java-fullstack-assignment.es_17;

public class breakLoop {
    public static void main(String[] args) {
        for(int i = 1; i<=10; i++)//il ciclo si verifica per 10 volte
        {
            if (i == 5) //ma se i è = a 5 esce dal loop
            {
                break; //esce dal loop
                
            }
            System.out.println(i);
        }
    }
    
}

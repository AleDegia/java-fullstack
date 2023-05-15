//package java_workspaces.esercitazioni.es_09;

public class forEach {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5 };
        for (int num : numbers) {
            //System.out.println(num);
            int dim= numbers.length;
            System.out.println("numero " + num + " di " + dim +" elementi ");
        }
    }

}

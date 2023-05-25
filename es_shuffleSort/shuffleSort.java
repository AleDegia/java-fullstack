import java.util.ArrayList;
import java.util.Collections;

public class shuffleSort {
    public static void main(String[] args) {
        ArrayList<String> list =  new ArrayList<String>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Grapes");
        list.add("Strawberry");

        //sort the list
        //Collections.sort(list);  

        //reverse the list
        Collections.reverse(list);


        Collections.replaceAll(list, "Banana", "Gatto");


        System.out.println("sorted list: " + list);
    }
}

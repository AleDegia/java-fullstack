//package java_workspaces.esercitazioni.es_shuffle;

import java.util.ArrayList;
import java.util.Collections;

public class esShuffle {
    public static void main(String[] args) {
        ArrayList<String> list =  new ArrayList<String>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Grapes");
        list.add("Strawberry");

        Collections.shuffle(list);  //va a riordinare in maniera casuale usando la libreria collections

        System.out.println("shuffled lsit: " + list);
    }
}

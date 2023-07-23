import java.util.List;

import basics.ArrayList;
import basics.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("ArrayList!");
        ArrayList<String> al = new ArrayList<String>();
        al.add("Arjun");
        al.add("Ridhi");
        al.add("Tanya");
        al.add("Chiku");
        al.addAll(List.of("Slvia", "Ronald"));
        al.remove("Tanya");
        System.out.println(al);


        System.out.println("LinkedList!");
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Arjun");
        ll.add("Ridhi");
        ll.add("Tanya");
        ll.add("Chiku");
        ll.addAll(List.of("Slvia", "Ronald"));
        ll.remove("Tanya");
        System.out.println(ll);


    }
}

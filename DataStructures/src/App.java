import java.util.List;

import basics.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        LinkedList<String> s = new LinkedList<>();
        s.add("Arjun");
        s.add("Ridhi");
        s.add("Tanya");
        s.add("Chiku");
        s.addAll(List.of("Slvia", "Ronald"));
        s.remove("Tanya");
        System.out.println(s);
    }
}

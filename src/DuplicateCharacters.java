// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/411

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateCharacters{

    class Pair {
        char character;
        int count;

        Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }

        public String toString(){
            return "["+this.character+", "+this.count+"]";
        }
    }

    public List<Pair> getDuplicateList(String s){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        List<Pair> pairs= new ArrayList<>();
        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }


        for(Character key: map.keySet()) {
            if(map.get(key) > 1) {
                pairs.add(new Pair(key, map.get(key)));
            }
        }
        return pairs;
    }

    public static void main(String args[]){
        DuplicateCharacters dc = new DuplicateCharacters();
        System.out.println(dc.getDuplicateList("Geek"));
    }

}
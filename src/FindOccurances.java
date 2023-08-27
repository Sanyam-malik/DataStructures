// Problem statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/47

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindOccurances {
    public ArrayList<Integer> findOccurances(int arr[]) {
        int N = arr.length/3;
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int no: arr) {
            map.put(no, map.getOrDefault(no, 0)+1);
        }

        for(Integer key: map.keySet()) {
            if(map.get(key).intValue() >= N) {
                al.add(key);
            }
        }
        return al;
    }

    public static void main(String args[]) {
        int arr[] = {7, 7, 7, 3, 4, 4, 4, 5};
        FindOccurances tm = new FindOccurances();
        System.out.println(tm.findOccurances(arr));
    }
}

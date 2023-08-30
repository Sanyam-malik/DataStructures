//Problem Statment: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/440

import java.util.* ;
import java.io.*; 
public class SmallestNo {
    
    public String smallestNumber(Integer n, Integer k) {
        List<Integer> list = new ArrayList<>();
        int start = (int) Math.pow(10.0, n-1);
        int end = (int) Math.pow(10.0, n)-1;
        start = 17;

        while(start <= end) {
            int temp = start;
            int sum = 0;
            // Reverse a no logic with diff that sum is not multiplied by 10;
            while(temp > 0){
                sum+=temp%10;
                temp = temp/10;
            }
            
            if(sum == k) {
                list.add(start);
            }

            start++;
        }
        Collections.sort(list);
        return Integer.toString(list.get(0));
    }

    public static void main(String a[]) {
        SmallestNo s = new SmallestNo();
        System.out.println(s.smallestNumber(2, 8));
    }

}
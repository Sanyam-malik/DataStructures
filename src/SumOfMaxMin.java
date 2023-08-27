// Problem statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/72

import java.util.Arrays;

public class SumOfMaxMin {

    public int SumOfMaxMinElement(int arr[]) {
        Arrays.sort(arr);
        return arr[arr.length-1] + arr[0];
    }

    public static void main(String args[]) {
        int arr[] = {1, 3, 6, 11, 12, 17, 22, 26, 30, 33, 38};
        SumOfMaxMin tm = new SumOfMaxMin();
        System.out.println(tm.SumOfMaxMinElement(arr));
    }

}
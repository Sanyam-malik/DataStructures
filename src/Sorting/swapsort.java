/*
<metadata>
<name>SwapSort</name>
<url>https://codeforces.com/problemset/problem/489/A</url>
<status>Completed</status>
<remarks>add desp</remarks>
<date>2026-07-21</date>
<level>Easy</level>
</metadata>
*/
import java.io.*;
import java.util.*;

public class Main {

    static List<int[]> swapSort(int[] arr) {
        List<int[]> swaps = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

                swaps.add(new int[]{i, minIndex});
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<int[]> swaps = swapSort(arr);

        System.out.println(swaps.size());

        for (int[] swap : swaps) {
            System.out.println(swap[0] + " " + swap[1]);
        }
    }
}
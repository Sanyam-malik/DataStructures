/*
<metadata>
<name>SwapSort</name>
<description>In this problem your goal is to sort an array consisting of n integers in at most n swaps. For the given array find the sequence of swaps that makes the 
array sorted in the non-descending order. Swaps are performed 
consecutively, one after another.Note that in this problem you do
 not have to minimize the number of swaps — your task is to find any 
sequence that is no longer than n.

Examples:

Input:
5
5 2 5 1 4

Output:
2
0 3
4 2</description>
<url>https://codeforces.com/problemset/problem/489/A</url>
<status>Completed</status>
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
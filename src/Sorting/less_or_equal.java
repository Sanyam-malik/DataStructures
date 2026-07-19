/*
<metadata>
<name>Less or Equal</name>
<description>You are given a sequence of integers of length n and integer number k. You should print any integer number x in the range of [1;109] (i.e. 1≤x≤109) such that exactly k elements of given sequence are less than or equal to x.Note that the sequence can contain equal elements.If there is no such x, print "-1" (without quotes).

Examples

Input:
7 4
3 7 5 1 10 3 20
Output:
6

Input:
7 2
3 7 5 1 10 3 20
Output:
-1
</description>
<url>https://codeforces.com/contest/977/problem/C</url>
<status>Completed</status>
<date>2026-07-19</date>
<level>Easy</level>
</metadata>
*/
import java.io.*;
import java.util.*;

public class Main {

    static int findX(int[] arr, int k) {
        int n = arr.length;

        Arrays.sort(arr);

        // Need exactly 0 elements <= x
        if (k == 0) {
            if (arr[0] > 1) {
                return 1;
            }
            return -1;
        }

        // Need all n elements <= x
        if (k == n) {
            return arr[n - 1];
        }

        // Need exactly k elements <= x
        if (arr[k - 1] < arr[k]) {
            return arr[k - 1];
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findX(arr, k));
    }
}
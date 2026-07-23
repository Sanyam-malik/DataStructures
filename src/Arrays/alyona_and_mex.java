/*
<metadata>
<name>Alyona and Mex</name>
<description>Someone gave Alyona an array containing n positive integers a1, a2, ..., an.
 In one operation, Alyona can choose any element of the array and 
decrease it, i.e. replace with any positive integer that is smaller than
 the current one. Alyona can repeat this operation as many times as she 
wants. In particular, she may not apply any operation to the array at 
all.

Formally, after applying some operations Alyona will get an array of n positive integers b1, b2, ..., bn such that 1 ≤ bi ≤ ai for every 1 ≤ i ≤ n. Your task is to determine the maximum possible value of mex of this array.

Mex of an array in this problem is the minimum positive integer that doesn't appear in this array. For example, mex of the array containing 1, 3 and 4 is equal to 2, while mex of the array containing 2, 3 and 2 is equal to 1.

Examples:

Input:
5
1 3 3 3 6

Output:
5
</description>
<url>https://codeforces.com/problemset/problem/682/B</url>
<status>Completed</status>
<date>2026-07-23</date>
<level>Easy</level>
</metadata>
*/
import java.util.*;

public class Main {

    static int maxMex(int[] a) {
        Arrays.sort(a);

        int need = 1;

        for (int x : a) {
            if (x >= need) {
                need++;
            }
        }

        return need;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(maxMex(a));
    }
}
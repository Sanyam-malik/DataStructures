/*
<metadata>
<name>Good Pairs</name>
<description>You are given an array a1,a2,…,an of positive integers. A good pair is a pair of indices (i,j) with 1≤i,j≤n such that, for all 1≤k≤n, the following equality holds:

|ai−ak|+|ak−aj|=|ai−aj|, where |x| denotes the absolute value of x.

Find a good pair. Note that i can be equal to j.

Input:
3 (no of cases)
3
5 2 7
5
1 4 2 2 3
1
2

Output:
2 3
1 2
1 1

</description>
<url>https://codeforces.com/problemset/problem/1656/A</url>
<status>Completed</status>
<date>2026-06-09</date>
<level>Easy</level>
<notes>Why it works:

For any three values x, y, z,|x - y| + |y - z| = |x - z|

iff y lies between x and z.

Therefore, for the given condition to hold for every k,a[k] must lie between a[i] and a[j].

Choosing a[i] as the minimum element and a[j] as the maximumelement guarantees that every array element lies between them.Hence, the indices of the minimum and maximum elements alwaysform a valid answer.</notes>
</metadata>
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int minIdx = 1, maxIdx = 1;
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;

            for (int i = 1; i <= n; i++) {
                int x = Integer.parseInt(st.nextToken());

                if (x < minVal) {
                    minVal = x;
                    minIdx = i;
                }

                if (x > maxVal) {
                    maxVal = x;
                    maxIdx = i;
                }
            }

            System.out.println(minIdx + " " + maxIdx);
        }
    }
}
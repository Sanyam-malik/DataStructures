/*
<metadata>
<name>Lecture Sleep</name>
<description>Your friend Mishka and you attend a calculus lecture. Lecture lasts n minutes. Lecturer tells ai theorems during the i-th minute.

Mishka is really interested in calculus, though it is so hard to stay awake for all the time of lecture. You are given an array t of Mishka's behavior. If Mishka is asleep during the i-th minute of the lecture then ti will be equal to 0, otherwise it will be equal to 1. When Mishka is awake he writes down all the theorems he is being told — ai during the i-th minute. Otherwise he writes nothing.

You task is to calculate the maximum number of theorems Mishka will be able to write down if you use your technique only once to wake him up.

Input:
6 3
1 3 5 2 5 4
1 1 0 1 0 0

Output:
16

</description>
<url>https://codeforces.com/problemset/problem/961/B</url>
<status>Completed</status>
<date>2026-06-18</date>
<level>Easy</level>
</metadata>
*/
import java.io.*;
import java.util.*;

public class Main {

    static long solve(int[] a, int[] t, int n, int k) {
        long base = 0;

        // Theorems already written while awake
        for (int i = 0; i < n; i++) {
            if (t[i] == 1) {
                base += a[i];
            }
        }

        // Extra theorems in the first window
        long extra = 0;
        for (int i = 0; i < k; i++) {
            if (t[i] == 0) {
                extra += a[i];
            }
        }

        long best = extra;

        // Sliding window
        for (int i = k; i < n; i++) {
            if (t[i] == 0) {
                extra += a[i];
            }
            if (t[i - k] == 0) {
                extra -= a[i - k];
            }
            best = Math.max(best, extra);
        }

        return base + best;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] t = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(a, t, n, k));
    }
}
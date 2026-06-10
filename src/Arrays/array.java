/*
<metadata>
<name>Array</name>
<description>Vitaly has an array of n distinct integers. Vitaly wants to divide this array into three non-empty sets so as the following conditions hold:  

1. The product of all numbers in the first set is less than zero ( < 0).  
2. The product of all numbers in the second set is greater than zero ( > 0).  
3. The product of all numbers in the third set is equal to zero.  

Each number from the initial array must occur in exactly one set. Help Vitaly. Divide the given array.

Input:
3
-1 2 0

Output:
1 -1
1 2
1 0

Input:
4
-1 -2 -3 0

Output:
1 -1
2 -3 -2
1 0

</description>
<url>https://codeforces.com/problemset/problem/300/A</url>
<status>Completed</status>
<date>2026-06-10</date>
<level>Easy</level>
</metadata>
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (x < 0) {
                neg.add(x);
            } else if (x > 0) {
                pos.add(x);
            } else {
                zero.add(x);
            }
        }

        List<Integer> A = new ArrayList<>(); // negative product
        List<Integer> B = new ArrayList<>(); // positive product
        List<Integer> C = new ArrayList<>(); // zero product

        // Put one negative into A
        A.add(neg.remove(neg.size() - 1));

        // If remaining negatives count is odd,
        // move one more negative to C so that B gets an even count.
        if (neg.size() % 2 == 1) {
            C.add(neg.remove(neg.size() - 1));
        }

        // All positives go to B
        B.addAll(pos);

        // Remaining negatives (even count) go to B
        B.addAll(neg);

        // All zeros go to C
        C.addAll(zero);

        printSet(A);
        printSet(B);
        printSet(C);
    }

    private static void printSet(List<Integer> set) {
        StringBuilder sb = new StringBuilder();
        sb.append(set.size());

        for (int x : set) {
            sb.append(' ').append(x);
        }

        System.out.println(sb);
    }
}
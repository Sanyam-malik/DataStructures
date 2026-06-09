/*
<metadata>
<name>Perfect Permutation</name>
<description>You are given a positive integer n.The weight of a permutation p1,p2,…,pn is the number of indices 1≤i≤n such that i divides pi. Find a permutation p1,p2,…,pn with the minimum possible weight (among all permutations of length n).

A permutation is an array consisting of n distinct integers from 1 to n in arbitrary order. For example, [2,3,1,5,4] is a permutation, but [1,2,2] is not a permutation (2 appears twice in the array) and [1,3,4] is also not a permutation (n=3 but there is 4 in the array).

Input:
2 (no of cases)
1
4

Output:
1
2 1 4 3</description>
<url>https://codeforces.com/problemset/problem/1711/A</url>
<status>Completed</status>
<date>2026-06-09</date>
<level>Easy</level>
<notes>Why does the cyclic shift (2, 3, 4, ..., n, 1) work?

We need to minimize the number of indices i such that:

    i divides p[i]

Observation:
- For every permutation, position 1 always contributes to the weight,
  because 1 divides every number.
- Therefore, the minimum possible weight is at least 1.

Construction:
    p = [2, 3, 4, ..., n, 1]

For every index i > 1:
- If i < n, then p[i] = i + 1.
- Since i does not divide i + 1, these positions do not contribute.
- For i = n, p[n] = 1.
- Since n > 1, n does not divide 1.

Thus:
- Only position 1 satisfies i | p[i].
- All other positions do not.

Weight = 1, which is the minimum possible weight.

Hence the cyclic shift:
    2 3 4 ... n 1
is always a valid optimal answer.</notes>
</metadata>
*/
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 2; i <= n; i++) {
                ans.append(i).append(" ");
            }
            ans.append(1).append("\n");
        }

        System.out.print(ans);
    }
}
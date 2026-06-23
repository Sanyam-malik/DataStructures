/*
<metadata>
<name>Odd Swap Sort</name>
<description>You are given an array a1,a2,…,an. You can perform operations on the array. 

In each operation you can choose an integer i (1≤i<n), and swap elements ai and ai+1 of the array, if ai+ai+1 is odd.Determine whether it can be sorted in non-decreasing order using this operation any number of times.

Inputs:

4 (no of testcases)
4 (length of array)
1 6 31 14
2 (length of array)
4 2
5 (length of array)
2 9 6 7 10
3 (length of array)
6 6 6

Outputs:

5
1
9
50
210


</description>
<url>https://codeforces.com/problemset/problem/1638/B</url>
<status>Completed</status>
<date>2026-06-23</date>
<level>Easy</level>
<notes>Key Observation
You can swap two adjacent elements only if their sum is odd.

Odd + Even = Odd ✅ (swap allowed)

Odd + Odd = Even ❌

Even + Even = Even ❌

So, only an odd and an even number can be swapped. 
Important Invariant
Since two odd numbers can never be swapped directly, the relative order of all odd numbers never changes.
Similarly, the relative order of all even numbers never changes. 
Therefore:

Extract all odd numbers from the array.

They must already be in non-decreasing order.

Extract all even numbers.

They must also already be in non-decreasing order.

If either sequence is not sorted, the answer is NO.
Otherwise, the answer is YES because we can use adjacent odd-even swaps (similar to bubble sort) to place the numbers correctly while preserving the order within odd and even numbers.</notes>
</metadata>
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int lastOdd = Integer.MIN_VALUE;
            int lastEven = Integer.MIN_VALUE;
            boolean ok = true;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();

                if (x % 2 != 0) {
                    if (x < lastOdd) {
                        ok = false;
                    }
                    lastOdd = x;
                } else {
                    if (x < lastEven) {
                        ok = false;
                    }
                    lastEven = x;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }

        sc.close();
    }
}
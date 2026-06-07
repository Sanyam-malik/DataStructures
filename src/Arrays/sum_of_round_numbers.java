/*
<metadata>
<name>Sum of Round Numbers</name>
<description>A positive (strictly greater than zero) integer is called round if it is of the form d00...0.
 In other words, a positive integer is round if all its digits except 
the leftmost (most significant) are equal to zero. In particular, all 
numbers from 1 to 9 (inclusive) are round.

For example, the following numbers are round: 4000, 1, 9, 800, 90. The following numbers are not round: 110, 707, 222, 1001.

You are given a positive integer n (1≤n≤104). Represent the number n
 as a sum of round numbers using the minimum number of summands 
(addends). In other words, you need to represent the given number n as a sum of the least number of terms, each of which is a round number.

Input:
5
5009
7
9876
10000
10

Output:
2
5000 9
1
7 
4
800 70 6 9000 
1
10000 
1
10</description>
<url>https://codeforces.com/contest/1352/problem/A</url>
<status>Completed</status>
<date>2026-06-07</date>
<level>Easy</level>
</metadata>
*/
import java.io.*;
import java.util.*;

public class Main {

    public static List<Integer> output(int num) {
        List<Integer> arr = new ArrayList<>();
        int power = 1;

        while (num > 0) {
            int digit = num % 10;

            if (digit != 0) {
                arr.add(digit * power);
            }

            num /= 10;
            power *= 10;
        }

        return arr;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            List<Integer> result = output(n);

            System.out.println(result.size());

            for (int x : result) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
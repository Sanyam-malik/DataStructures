/*
<metadata>
<name>GCD vs LCM</name>
<description>You are given a positive integer n. You have to find 4 positive integers a,b,c,d such that

-> a+b+c+d=n
-> gcd(a,b)=lcm(c,d).

If there are several possible answers you can output any of them. It is possible to show that the answer always exists.In this problem gcd(a,b) denotes the greatest common divisor of a and b, and lcm(c,d) denotes the least common multiple of c and d.

Input:
5 (no of test cases)
4
7
8
9
10

Output:
1 1 1 1
2 2 2 1
2 2 2 2
2 4 2 1
3 5 1 1

</description>
<url>https://codeforces.com/problemset/problem/1665/A</url>
<status>Completed</status>
<date>2026-06-09</date>
<level>Easy</level>
</metadata>
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            sb.append(n - 3).append(" 1 1 1\n");
        }

        System.out.print(sb);
    }
}
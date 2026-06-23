/*
<metadata>
<name>The Deadly Sin</name>
<description>Meliodas and Ban are fighting over chocolates. Meliodas has XX chocolates, while Ban has YY.

Whoever has lesser number of chocolates eats as many chocolates as he 
has from the other's collection. This eatfest war continues till either 
they have the same number of chocolates, or atleast one of them is left with no chocolates.
Can you help Elizabeth predict the total no of chocolates they'll be left with at the end of their war?

Input Format
First line will contain TT, number of testcases. Then the testcases follow.Each testcase contains of a single line of input, which contains two integers X,YX,Y, the no of chocolates Meliodas and Ban have, respectively.

Output Format
For each testcase, output in a single line the no of chocolates that remain after Ban and Meliodas stop fighting.

Constraints

1≤T≤100000
1≤T≤1000000≤X,Y≤1090≤X,Y≤109</description>
<url>https://www.codechef.com/problems/SINS</url>
<status>Completed</status>
<date>2026-06-24</date>
<level>Easy</level>
</metadata>
*/
import java.io.*;
import java.util.*;

class Codechef {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            while (true) {
                if (x == y || x == 0 || y == 0)
                    break;
                else if (x > y) {
                    if (x % y == 0)
                        x = y;
                    else
                        x %= y;
                } else {
                    if (y % x == 0)
                        y = x;
                    else
                        y %= x;
                }
            }

            sb.append(x + y).append('\n');
        }

        System.out.print(sb);
    }
}
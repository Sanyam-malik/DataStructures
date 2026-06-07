/*
<metadata>
<name>Odd One Out</name>
<description>You are given three digits a, b, c. Two of them are equal, but the third one is different from the other two. Find the value that occurs exactly once.

Input:
10
1 2 2
4 3 4
5 5 6
7 8 8
9 0 9
3 6 3
2 8 2
5 7 7
7 7 5
5 7 5

Output:
1
3
6
7
0
6
8
5
5
7

</description>
<url>https://codeforces.com/contest/1915/problem/A</url>
<status>Completed</status>
<date>2026-06-07</date>
<level>Easy</level>
</metadata>
*/
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (a == b) {
                System.out.println(c);
            } else if (a == c) {
                System.out.println(b);
            } else {
                System.out.println(a);
            }
        }
    }
}
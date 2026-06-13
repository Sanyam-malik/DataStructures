/*
<metadata>
<name>Petya and Strings</name>
<description>Little Petya loves presents. His mum bought him two strings of the same size for his birthday. The strings consist of uppercase and lowercase Latin letters. Now Petya wants to compare those two strings lexicographically.

The letter's case does not matter, that is an uppercase letter is considered equivalent to the corresponding lowercase letter. Help Petya perform the comparison.

Input:
aaaa
aaaA

Output:
0

Input:
abs
Abz

Output:
-1

Input:
abcdefg
AbCdEfF

Output:
1</description>
<url>https://codeforces.com/problemset/problem/112/A</url>
<status>Completed</status>
<date>2026-06-13</date>
<level>Easy</level>
</metadata>
*/
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine().toLowerCase();
        String s2 = br.readLine().toLowerCase();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                System.out.println(-1);
                return;
            }

            if (s1.charAt(i) > s2.charAt(i)) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}
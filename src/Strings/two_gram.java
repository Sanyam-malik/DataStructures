/*
<metadata>
<name>Two-gram</name>
<description>Two-gram is an ordered pair (i.e. string of length two) of capital Latin letters. For example, "AZ", "AA", "ZA" — three distinct two-grams.You are given a string s consisting of n capital Latin letters. Your task is to find any two-gram contained in the given string as a substring (i.e. two consecutive characters of the string) maximal number of times. For example, for string s = "BBAABBBA" the answer is two-gram "BB", which contained in s three times. In other words, find any most frequent two-gram.Note that occurrences of the two-gram can overlap with each other.

Input:
7 (length of string)
ABACABA

Output:
AB

Input:
5 (length of string)
ZZZAA

Output:
ZZ


</description>
<url>https://codeforces.com/problemset/problem/977/B</url>
<status>Completed</status>
<date>2026-06-13</date>
<level>Easy</level>
</metadata>
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        Map<String, Integer> freq = new HashMap<>();

        String ans = "";
        int maxFreq = 0;

        for (int i = 0; i < n - 1; i++) {
            String twoGram = s.substring(i, i + 2);

            int count = freq.getOrDefault(twoGram, 0) + 1;
            freq.put(twoGram, count);

            if (count > maxFreq) {
                maxFreq = count;
                ans = twoGram;
            }
        }

        System.out.println(ans);
    }
}
/*
<metadata>
<name>Buggy Sorting</name>
<description>Little boy Valera studies an algorithm of sorting an integer array. 
After studying the theory, he went on to the practical tasks. As a 
result, he wrote a program that sorts an array of n integers a1, a2, ..., an
 in the non-decreasing order. The pseudocode of the program, written by 
Valera, is given below. The input of the program gets number n and array a.


loop integer variable i from 1 to n - 1    
  loop integer variable j from i to n - 1
    if (aj > aj + 1), then swap the values of elements aj and aj + 1


But Valera could have made a mistake, because he hasn't yet fully 
learned the sorting algorithm. If Valera made a mistake in his program, 
you need to give a counter-example that makes his program work 
improperly (that is, the example that makes the program sort the array 
not in the non-decreasing order). If such example for the given value of
 n doesn't exist, print -1.
</description>
<url>https://codeforces.com/problemset/problem/246/A</url>
<status>Completed</status>
<date>2026-07-19</date>
<level>Easy</level>
</metadata>
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n > 2) {
            for (int i = 2; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.println(1);
        } else {
            System.out.println(-1);
        }
    }
}
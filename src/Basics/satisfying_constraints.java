/*
<metadata>
<name>Satisfying Constraints</name>
<description>Alex is solving a problem. He has n constraints on what the integer k can be. There are three types of constraints:

1. k must be greater than or equal to some integer x;
2. k must be less than or equal to some integer x;
3. k must be not equal to some integer x. 

Inputs: 
6 (no of cases)
4
1 3 (contraint, x)
2 10
3 1
3 5

2
1 5
2 4

10
3 6
3 7
1 2
1 7
3 100
3 44
2 100
2 98
1 3
3 99

6
1 5
2 10
1 9
2 2
3 2
3 9

5
1 1
2 2
3 1
3 2
3 3

6
1 10000
2 900000000
3 500000000
1 100000000
3 10000
3 900000001

Outputs:
7
0
90
0
0
800000000

</description>
<url>https://codeforces.com/contest/1920/problem/A</url>
<status>Completed</status>
<date>2026-06-14</date>
<level>Easy</level>
</metadata>
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int left = 1;
            int right = 1000000000;

            List<Integer> forbidden = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                if (a == 1) {
                    left = Math.max(left, x);
                } else if (a == 2) {
                    right = Math.min(right, x);
                } else {
                    forbidden.add(x);
                }
            }

            if (left > right) {
                System.out.println(0);
                continue;
            }

            int ans = right - left + 1;

            for (int x : forbidden) {
                if (x >= left && x <= right) {
                    ans--;
                }
            }

            System.out.println(ans);
        }
    }
}
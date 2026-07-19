/*
<metadata>
<name>Vanya and Lanterns</name>
<description>Vanya walks late at night along a straight street of length l, lit by n lanterns. Consider the coordinate system with the beginning of the street corresponding to the point 0, and its end corresponding to the point l. Then the i-th lantern is at the point ai. The lantern lights all points of the street that are at the distance of at most d from it, where d is some positive number, common for all lanterns. Vanya wonders: what is the minimum light radius d should the lanterns have to light the whole street?

Examples:

Input:
7 15
15 5 3 7 9 14 0

Output:
2.5000000000


Input:
2 5
2 5

Output:
2.0000000000
</description>
<url>https://codeforces.com/contest/492/problem/B</url>
<status>Completed</status>
<date>2026-07-19</date>
<level>Easy</level>
</metadata>
*/
import java.util.*;

public class Main {

    static double solve(int[] arr, int l) {

        // Sort lantern positions so we can check
        // the gaps between consecutive lanterns
        Arrays.sort(arr);

        int n = arr.length;

        // Check the two edges of the street:
        // 1. Distance from 0 to the first lantern
        // 2. Distance from the last lantern to l
        //
        // Edge gaps are NOT divided by 2 because
        // only one lantern covers these areas.
        double ans = Math.max(
            arr[0],
            l - arr[n - 1]
        );

        // Check gaps between consecutive lanterns
        for (int i = 1; i < n; i++) {

            // Two lanterns cover this gap from both sides,
            // so each lantern needs to cover half of the gap.
            double gap = (arr[i] - arr[i - 1]) / 2.0;

            // The radius must be large enough to cover
            // the largest required distance.
            ans = Math.max(ans, gap);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of lanterns
        int n = sc.nextInt();

        // Length of the street: [0, l]
        int l = sc.nextInt();

        // Positions of the lanterns
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find and print the minimum required radius
        System.out.println(solve(arr, l));
    }
}
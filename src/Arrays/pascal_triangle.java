/*
<metadata>
<name>Pascal Triangle</name>
<description>Given a positive integer n, return the nth row of pascal's triangle.Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.

Examples:
Input: n = 4
Output: [1, 3, 3, 1]
Explanation: 4th row of pascal's triangle is [1, 3, 3, 1].
Input: n = 5
Output: [1, 4, 6, 4, 1]
Explanation: 5th row of pascal's triangle is [1, 4, 6, 4, 1].
Input: n = 1
Output: [1]
Explanation: 1st row of pascal's triangle is [1].
Constraints:1 ≤ n ≤ 30
</description>
<url>https://www.geeksforgeeks.org/problems/pascal-triangle0652/1</url>
<status>Completed</status>
<date>2026-06-25</date>
<level>Medium</level>
</metadata>
*/
class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        long val = 1;
        ans.add(1);

        for (int i = 1; i < n; i++) {
            val = val * (n - i);
            val = val / i;
            ans.add((int) val);
        }

        return ans;
    }
}
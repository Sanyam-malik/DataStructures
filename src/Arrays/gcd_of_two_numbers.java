/*
<metadata>
    <name>GCD of two numbers</name>
    <url>https://www.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1</url>
    <description>Given two positive integers a and b, find GCD of a and b.

Note: Don't use the inbuilt gcd function

Examples:

Input: a = 20, b = 28
Output: 4
Explanation: GCD of 20 and 28 is 4

Input: a = 60, b = 36
Output: 12
Explanation: GCD of 60 and 36 is 12

Constraints:
1 ≤ a, b ≤ 109</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-10</date>
</metadata>
*/

class Solution {
    public static int gcd(int a, int b) {
        // code here
        if(a == 0) {
            return b;
        }
        int x = Math.min(a, b);
        int y = Math.max(a, b);
        return gcd(y%x, x);
    }
}
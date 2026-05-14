/*
<metadata>
    <name>Power of Two</name>
    <url>https://leetcode.com/problems/power-of-two/</url>
    <description>Given an integer n, return true if it is a power of two. Otherwise, return false.





An integer n is a power of two, if there exists an integer x such that n == 2x.





 




Example 1:




Input: n = 1
Output: true
Explanation: 20 = 1





Example 2:




Input: n = 16
Output: true
Explanation: 24 = 16





Example 3:




Input: n = 3
Output: false





 




Constraints:




-231 <= n <= 231 - 1</description>
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
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
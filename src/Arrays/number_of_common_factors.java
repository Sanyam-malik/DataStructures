/*
<metadata>
    <name>Number of Common factors</name>
    <url>https://leetcode.com/problems/number-of-common-factors/</url>
    <description>Given two positive integers a and b, return the number of common factors of a and b.





An integer x is a common factor of a and b if x divides both a and b.





 




Example 1:




Input: a = 12, b = 6
Output: 4
Explanation: The common factors of 12 and 6 are 1, 2, 3, 6.





Example 2:




Input: a = 25, b = 30
Output: 2
Explanation: The common factors of 25 and 30 are 1, 5.





 




Constraints:




1 <= a, b <= 1000


 </description>
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
    public int commonFactors(int a, int b) {
        int min = Math.min(a, b);
        int count = 1; // Because of 1 as our first common factor
        for(int i = 2; i<= min; i++) {
            if(a%i == 0 && b%i == 0) count++;
        }
        return count;
    }
}
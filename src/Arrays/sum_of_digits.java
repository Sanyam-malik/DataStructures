/*
<metadata>
    <name>Sum of digits</name>
    <url>https://www.geeksforgeeks.org/problems/sum-of-digits1742/1</url>
    <description>Given a positive number n. Find the sum of all the digits of n.




Examples:



Input: n = 687
Output: 21
Explanation: Sum of 687's digits: 6 + 8 + 7 = 21


Input: n = 12
Output 3
Explanation: Sum of 12's digits: 1 + 2 = 3




Constraints:
1 <= n <= 105


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
    static int sumOfDigits(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n%10;
            n /= 10;
        }
        
        return sum;
        
    }
}
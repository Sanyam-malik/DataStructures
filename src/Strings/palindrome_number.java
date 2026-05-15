/*
<metadata>
    <name>Palindrome Number</name>
    <url>https://leetcode.com/problems/palindrome-number/description/</url>
    <description>Given an integer x, return true if x is a , and false otherwise.





 




Example 1:




Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.





Example 2:




Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.





Example 3:




Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.





 




Constraints:




-231 <= x <= 231 - 1</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-15</date>
</metadata>
*/

class Solution {
    public boolean isPalindrome(int n) {
        if(n < 0) {
            return false;
        }


        int backup = n;
        int reversed = 0;
        while(n > 0) {
            reversed = reversed * 10 + n%10;
            n = n/10;
        }


        return backup == reversed;
    }
}
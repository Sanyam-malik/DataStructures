/*
<metadata>
<name>Palindrome Digit Sum</name>
<description>Given a number n. Return true if the digit sum(or sum of digits) of n is a Palindrome number otherwise false.A Palindrome number is a number that stays the same when reversed

Examples:

Input: n = 56
Output: true
Explanation: The digit sum of 56 is 5+6 = 11. Since, 11 is a palindrome number.Thus, answer is true.
Input: n = 98
Output: false
Explanation: The digit sum of 98 is 9+8 = 17. Since 17 is not a palindrome,thus, answer is false.</description>
<url>https://www.geeksforgeeks.org/problems/sum-of-digit-is-pallindrome-or-not2751/1</url>
<status>Completed</status>
<date>2026-06-24</date>
<level>Easy</level>
</metadata>
*/
class Solution {
    boolean isDigitSumPalindrome(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        
        String s = Integer.toString(sum); // FIX: use sum, not n
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false; // FIX: charAt
            start++;
            end--;
        }
        return true;
    }
}
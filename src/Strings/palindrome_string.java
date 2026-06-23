/*
<metadata>
<name>Palindrome String</name>
<description>Given a string s, return true if the string is a palindrome. Otherwise, return false. 
A string is considered a palindrome if it reads the same forwards and backwards.

Examples :

Input: s = "abba"
Output: true
Explanation: "abba" reads the same forwards and backwards, so it is a palindrome.
Input: s = "abc" 
Output: false
Explanation: "abc" does not read the same forwards and backwards, so it is not a palindrome.</description>
<url>https://www.geeksforgeeks.org/problems/palindrome-string0817/1</url>
<status>Completed</status>
<date>2026-06-24</date>
<level>Easy</level>
</metadata>
*/
class Solution {
    boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            sb.append(c);
        }
        sb.reverse();
        return s.equals(sb.toString());
    }
}
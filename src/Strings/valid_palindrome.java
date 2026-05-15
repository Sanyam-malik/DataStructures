/*
<metadata>
    <name>Valid Palindrome</name>
    <url>https://leetcode.com/problems/valid-palindrome/description/</url>
    <description>A phrase is a palindrome if, after converting all 
uppercase letters into lowercase letters and removing all 
non-alphanumeric characters, it reads the same forward and backward. 
Alphanumeric characters include letters and numbers.





Given a string s, return true if it is a palindrome, or false otherwise.





 




Example 1:




Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.





Example 2:




Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.





Example 3:




Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.





 




Constraints:




1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.</description>
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
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();


        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }


        String original = sb.toString();
        String reversed = new StringBuilder(original).reverse().toString();


        return original.equals(reversed);
    }
}
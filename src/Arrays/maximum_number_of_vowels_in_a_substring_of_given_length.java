/*
<metadata>
    <name>Maximum Number of Vowels in a Substring of Given Length</name>
    <url>https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/2009275870/</url>
    <description>Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 
Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.


Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.


Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

 
Constraints:

1 <= s.length <= 105s consists of lowercase English letters.1 <= k <= s.length</description>
    <notes></notes>
    <status>Completed</status>
    <level>Medium</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-21</date>
</metadata>
*/

class Solution {

    public int maxVowels(String s, int k) {

        int count = 0;
        int max = 0;

        // First window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        max = count;

        // Sliding window
        for (int i = k; i < s.length(); i++) {

            // Add incoming character
            if (isVowel(s.charAt(i))) {
                count++;
            }

            // Remove outgoing character
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i'
                || c == 'o' || c == 'u';
    }
}
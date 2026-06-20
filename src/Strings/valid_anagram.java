/*
<metadata>
<name>Valid Anagram</name>
<description>Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

Constraints:

1 <= s.length, t.length <= 5  104
s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?</description>
<url>https://leetcode.com/problems/valid-anagram/description/</url>
<status>Completed</status>
<date>2026-05-18</date>
<level>Easy</level>
<companies>Apple:Amazon:Google:Spotify:Facebook:Bloomberg:Microsoft:Morgan Stanley</companies>
</metadata>
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < t.length(); i++) {
            if (count[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            count[t.charAt(i) - 'a'] -= 1;
        }

        return true;        
    }
}
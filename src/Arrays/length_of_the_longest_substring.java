/*
<metadata>
    <name>Length of the longest substring</name>
    <url>https://www.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1</url>
    <description>Given a string s, find the length of the longest substring without repeating characters. Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: Longest substring is "eksforg".

Input: s = "abdefgabef"
Output: 6
Explanation: Longest substring are "abdefg" , "bdefga" and "defgab".

Input: s = "aaaaa"
Output: 1
Explanation: Longest substring is "a".

Constraints:1 ≤ s.size() ≤ 105

It is guaranteed that all characters of the String s will be lowercase letters from 'a' to 'z'</description>
    <notes></notes>
    <status>Completed</status>
    <level>Medium</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-21</date>
</metadata>
*/

import java.util.HashMap;

class Solution {
    int longestUniqueSubstring(String str) {
        HashMap<Character, Integer> lastSeen = new HashMap<>();

        int maxLen = 0;
        int start = 0;

        for (int end = 0; end < str.length(); end++) {
            char ch = str.charAt(end);

            // Move start if character already exists in current window
            if (lastSeen.containsKey(ch) && lastSeen.get(ch) >= start) {
                start = lastSeen.get(ch) + 1;
            }

            lastSeen.put(ch, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
/*
<metadata>
    <name>Count Vowel Strings in Ranges</name>
    <url>https://leetcode.com/problems/count-vowel-strings-in-ranges/description/</url>
    <description>You are given a 0-indexed array of strings words and a 2D array of integers queries.

Each query queries[i] = [li, ri] asks us to find the number of strings present at the indices ranging from li to ri (both inclusive) of words that start and end with a vowel.

Return an array ans of size queries.length, where ans[i] is the answer to the ith query.

Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2,3,0]
Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
The answer to the query [0,2] is 2 (strings "aba" and "ece").
to query [1,4] is 3 (strings "ece", "aa", "e").
to query [1,1] is 0.
We return [2,3,0].

Example 2:

Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
Output: [3,2,1]
Explanation: Every string satisfies the conditions, so we return [3,2,1].

Constraints:

1 <= words.length <= 1051 <= words[i].length <= 40words[i] consists only of lowercase English letters.sum(words[i].length) <= 3  1051 <= queries.length <= 1050 <= li <= ri < words.length</description>
    <notes></notes>
    <status>Completed</status>
    <level>Medium</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-24</date>
</metadata>
*/

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n];

        for (int i = 0; i < n; i++) {
            String word = words[i];

            // carry forward previous prefix
            prefix[i] = (i > 0 ? prefix[i - 1] : 0);

            if (isVowel(word.charAt(0)) &&
                isVowel(word.charAt(word.length() - 1))) {
                prefix[i]++;
            }
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            result[i] = prefix[r] - (l > 0 ? prefix[l - 1] : 0);
        }

        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || 
               c == 'o' || c == 'u';
    }
}
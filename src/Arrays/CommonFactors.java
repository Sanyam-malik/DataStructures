/*
<metadata>
  <name>Number of Common factors</name>
  <url>https://leetcode.com/problems/number-of-common-factors/</url>
  <status>Completed</status>
  <level>Easy</level>
  <date>2026-05-11</date>
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
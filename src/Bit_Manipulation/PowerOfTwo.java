/*
<metadata>
  <name>Power of Two</name>
  <url>https://leetcode.com/problems/power-of-two/</url>
  <status>Completed</status>
  <level>Easy</level>
  <date>2026-05-11</date>
</metadata>
*/
class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
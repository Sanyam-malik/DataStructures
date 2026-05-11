/*
<metadata>
  <name>Ugly Number</name>
  <ur>https://leetcode.com/problems/ugly-number/</url>
  <status>Completed</status>
  <level>Easy</level>
  <date>2026-05-11</date>
</metadata>
  */
class Solution {
    public boolean isUgly(int n) {
        
        if(n <= 0) return false;

        while(n % 2 == 0) {
            n /= 2;
        }

        while(n % 3 == 0) {
            n /= 3;
        }

        while(n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }
}
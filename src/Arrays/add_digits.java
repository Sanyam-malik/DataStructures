/*
<metadata>
<name>Add Digits</name>
<description><p>Given an integer num, repeatedly add all its digits until the result has only one digit, and return it. </p><p><br></p><p>Example 1: </p><p>Input: num = 38 </p><p>Output: 2 </p><p>Explanation: The process is 38 --&gt; 3 + 8 --&gt; 11 11 --&gt; 1 + 1 --&gt; 2 Since 2 has only one digit, return it. </p><p><br></p><p>Example 2: </p><p>Input: num = 0 </p><p>Output: 0 </p><p><br></p><p>Follow up: Could you do it without any loop/recursion in O(1) runtime?</p></description>
<url>https://leetcode.com/problems/add-digits</url>
<status>Completed</status>
<date>2026-05-10</date>
<level>Easy</level>
<notes><p><strong><span class="ql-cursor">﻿</span></strong></p></notes>
<companies>Bloomberg</companies>
</metadata>
*/
class Solution {
    public int addDigits(int num) {
        int ans=0;
        if(num == 0){
            return 0;
        }
        while (ans == 0 || ans >=10){
            ans = 0;
            while(num > 0){
                ans += num%10;
                num = num/10;
            }
            num = ans;
            
        }
        return ans;
    }
}
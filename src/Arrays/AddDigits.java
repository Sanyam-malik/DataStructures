/*
<metadata>
  <name>Add Digits</name>
  <url>https://leetcode.com/problems/add-digits</url>
  <status>Completed</status>
  <level>Easy</level>
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
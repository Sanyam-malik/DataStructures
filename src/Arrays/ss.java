/*
<metadata>
    <name>ss</name>
    <url>https://forgejo.proxcloud.in/Data-Structures/codebase-flask/actions</url>
    <description></description>
    <notes></notes>
    <status>In Progress</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-11</date>
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


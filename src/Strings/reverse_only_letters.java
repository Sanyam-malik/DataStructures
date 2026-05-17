/*
<metadata>
    <name>Reverse Only Letters</name>
    <url>https://leetcode.com/problems/reverse-only-letters/description/</url>
    <description>Given a string s, reverse the string according to the following rules:




All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.




Return s after reversing it.





 




Example 1:



Input: s = "ab-cd"
Output: "dc-ba"


Example 2:



Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"


Example 3:



Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"




 




Constraints:




1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-17</date>
</metadata>
*/

class Solution {
    public String reverseOnlyLetters(String s) {
        
        char[] ch = s.toCharArray();
        int i=0,j=s.length()-1;


        while(i < j){
            if(!Character.isLetter(ch[i])) i++;
            if(!Character.isLetter(ch[j])) j--;


         if(Character.isLetter(ch[i]) && Character.isLetter(ch[j])){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
         }
        }
        return new String(ch);
    }
}
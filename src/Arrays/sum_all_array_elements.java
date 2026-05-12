/*
<metadata>
    <name>Sum All Array Elements</name>
    <url>https://www.geeksforgeeks.org/problems/sum-all-array-elements/1</url>
    <description>You are given an array that contains integers. You need to return the sum of all array elements.




Examples:



Input: arr[] = [54, 43, 2, 1, 5]
Output: 105
Explanation: Just sum it 54+43+2+1+5=105.


Input: arr[] = [324, 5, 2, 2]
Output: 333
Explanation: Just sum it 324+5+2+2=333.</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-12</date>
</metadata>
*/

class Solution {
    public static int arraySum(int[] arr) {
        // code here
        int sum = 0;
        for(int a: arr) {
            sum += a;
        }
        
        return sum;
    }
}

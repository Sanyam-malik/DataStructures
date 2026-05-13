/*
<metadata>
    <name>Replace Elements with Greatest Element on Right Side</name>
    <url>https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/</url>
    <description>Given an array arr, replace every element in that array 
with the greatest element among the elements to its right, and replace 
the last element with -1.





After doing so, return the array.





 




Example 1:




Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation: 
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.





Example 2:




Input: arr = [400]
Output: [-1]
Explanation: There are no elements to the right of index 0.
</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-13</date>
</metadata>
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int index = arr.length- 1;
        int[] temp = new int[arr.length];
        temp[index] = -1;
        int max = -1;
        for(int i=arr.length-1; i>=0;i--) {
            if(max < arr[i]) {
                temp[index--] = max;
                max = arr[i];
            } else {
                temp[index--] = max;
            }
        }
        return temp;
    }
}

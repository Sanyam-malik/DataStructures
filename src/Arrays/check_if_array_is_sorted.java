/*
<metadata>
    <name>Check if array is sorted</name>
    <url>https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1</url>
    <description>Given an array arr[], check whether it is sorted in non-decreasing order. Return true if it is sorted otherwise false.

Examples:

Input: arr[] = [10, 20, 30, 40, 50]
Output: true
Explanation: The given array is sorted.

Input: arr[] = [90, 80, 100, 70, 40, 30]
Output: false
Explanation: The given array is not sorted.


Constraints:
1 ≤ arr.size ≤ 106
- 109 ≤ arr[i] ≤ 109</description>
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
    public boolean isSorted(int[] arr) {
        // code here
        for(int i=1; i<arr.length;i++) {
            if(arr[i-1] > arr[i]) return false;
        }
        return true;
    }
}

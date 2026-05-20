/*
<metadata>
    <name>Rotate Array by One</name>
    <url>https://www.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1</url>
    <description>Given an array arr, rotate the array by one position in clockwise direction.

Examples:

Input: arr[] = [1, 2, 3, 4, 5]
Output: [5, 1, 2, 3, 4]
Explanation: If we rotate arr by one position in clockwise 5 come to the front and remaining those are shifted to the end.

Input: arr[] = [9, 8, 7, 6, 4, 2, 1, 3]
Output: [3, 9, 8, 7, 6, 4, 2, 1]
Explanation: After rotating clock-wise 3 comes in first position.

Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 105</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-20</date>
</metadata>
*/

class Solution {
    public void rotate(int[] arr) {
        int[] result = rotateArray(arr, 1);
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }
    
    public int[] rotateArray(int[] arr, int rotateNo) {
        int n = arr.length;
        int[] result = new int[n];
        
        int index = 0;

        // last 'rotateNo' elements
        for (int i = n - rotateNo; i < n; i++) {
            result[index++] = arr[i];
        }

        // remaining elements
        for (int i = 0; i < n - rotateNo; i++) {
            result[index++] = arr[i];
        }
        
        return result;
    }
}
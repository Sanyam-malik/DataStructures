/*
<metadata>
<name>Min and Max in Array</name>
<description>Given an array arr[]. Your task is to find the minimum and maximum elements in the array.

Examples:

Input: arr[] = [1, 4, 3, 5, 8, 6]
Output: [1, 8]
Explanation: minimum and maximum elements of array are 1 and 8.

Input: arr[] = [12, 3, 15, 7, 9]
Output: [3, 15]
Explanation: minimum and maximum element of array are 3 and 15.

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 109</description>
<url>https://www.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1</url>
<status>Completed</status>
<date>2026-05-12</date>
<level>Easy</level>
</metadata>
*/
class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        // code Here
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int a: arr) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        
        return new ArrayList<>(List.of(min, max));
    }
}
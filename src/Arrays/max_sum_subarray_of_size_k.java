/*
<metadata>
    <name>Max Sum Subarray of size K</name>
    <url>https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1</url>
    <description>Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
Note: A subarray is a contiguous part of any given array.

Examples:
Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 + arr3 = 700, which is maximum.

Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
Output: 39
Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.

Input: arr[] = [100, 200, 300, 400], k = 1
Output: 400
Explanation: arr3 = 400, which is maximum.

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106
1 ≤ k ≤ arr.size()</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-26</date>
</metadata>
*/

class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int maxSum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int runningSum = maxSum;

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            runningSum = runningSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, runningSum);
        }

        return maxSum;
    }
}
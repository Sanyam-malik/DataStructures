/*
<metadata>
<name>K-Concatenation Maximum Sum</name>
<description>Given an integer array arr and an integer k, modify the array by repeating it k times.

For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].

Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.

As the answer can be very large, return the answer modulo 109 + 7.

 
Example 1:

Input: arr = [1,2], k = 3
Output: 9


Example 2:

Input: arr = [1,-2,1], k = 5
Output: 2


Example 3:

Input: arr = [-1,-2], k = 7
Output: 0


Constraints:

1 <= arr.length <= 105
1 <= k <= 105
-104 <= arr[i] <= 104
</description>
<url>https://leetcode.com/problems/k-concatenation-maximum-sum/description/</url>
<status>Completed</status>
<date>2026-06-23</date>
<level>Medium</level>
</metadata>
*/
class Solution {
    int MOD = 1_000_000_007;

    public int kConcatenationMaxSum(int[] arr, int k) {

        // Case 1: Only one array
        if (k == 1) {
            return kadane(arr);
        }

        // Find total sum of the original array
        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Create an array with two copies of arr
        int[] twice = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            twice[i] = arr[i];
            twice[i + arr.length] = arr[i];
        }

        // Maximum subarray sum in two concatenated arrays
        long maxSum = kadane(twice);

        // If total sum is positive, every extra array adds its full sum
        if (totalSum > 0) {
            maxSum += (long) (k - 2) * totalSum;
        }

        return (int) (maxSum % MOD);
    }

    // Kadane's Algorithm
    private int kadane(int[] arr) {
        long currSum = 0;
        long maxSum = 0;

        for (int num : arr) {
            currSum = Math.max(0, currSum + num);
            maxSum = Math.max(maxSum, currSum);
        }

        return (int) maxSum;
    }
}
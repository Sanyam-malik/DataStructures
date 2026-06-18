/*
<metadata>
<name>Minimize the Heights II</name>
<description>Given an array arr[] denoting heights of n towers and a positive integer k. 

For each tower, you must perform exactly one of the following operations exactly once.
Increase the height of the tower by k, Decrease the height of the tower by k

Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

You can find a slight modification of the problem here.

Note: It is compulsory to increase or decrease the height by k for each tower. After the operation, the resultant array should not contain any negative integers.

Examples :
Input: k = 2, arr[] = [1, 5, 8, 10]
Output: 5
Explanation: The array can be modified as [1+k, 5-k, 8-k, 10-k] = [3, 3, 6, 8]. The difference between the largest and the smallest is 8-3 = 5.

Input: k = 3, arr[] = [3, 9, 12, 16, 20]
Output: 11
Explanation: The array can be modified as [3+k, 9+k, 12-k, 16-k, 20-k] = [6, 12, 9, 13, 17]. The difference between the largest and the smallest is 17-6 = 11. 
</description>
<url>https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1</url>
<status>Completed</status>
<date>2026-06-19</date>
<level>Easy</level>
<notes>One-line intuition

Sort the array, then imagine a divider. Everything on the left is increased by k, everything on the right is decreased by k. Try every divider and choose the smallest resulting range.</notes>
</metadata>
*/
class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;

        if (n == 1) return 0;

        Arrays.sort(arr);

        // Initial range (no modifications)
        int ans = arr[n - 1] - arr[0];

        // Smallest possible left value
        int smallest = arr[0] + k;

        // Largest possible right value
        int largest = arr[n - 1] - k;

        // Try every partition
        for (int i = 0; i < n - 1; i++) {

            // Smallest value after modification
            int minVal = Math.min(smallest, arr[i + 1] - k);

            // Largest value after modification
            int maxVal = Math.max(largest, arr[i] + k);

            // Heights cannot be negative
            if (minVal < 0) continue;

            // Update minimum range
            ans = Math.min(ans, maxVal - minVal);
        }

        return ans;
    }
}
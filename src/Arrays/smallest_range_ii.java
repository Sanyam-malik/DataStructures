/*
<metadata>
<name>Smallest Range II</name>
<description>You are given an integer array nums and an integer k.

For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.

The score of nums is the difference between the maximum and minimum elements in nums.

Return the minimum score of nums after changing the values at each index.

 
Example 1:

Input: nums = [1], k = 0
Output: 0
Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.


Example 2:

Input: nums = [0,10], k = 2
Output: 6
Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.


Example 3:

Input: nums = [1,3,6], k = 3
Output: 3
Explanation: Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6 - 3 = 3.
</description>
<url>https://leetcode.com/problems/smallest-range-ii/description/</url>
<status>Completed</status>
<date>2026-07-19</date>
<level>Medium</level>
<companies>Adobe:Amazon</companies>
</metadata>
*/
import java.util.Arrays;

class Solution {

    public int smallestRangeII(int[] nums, int k) {

        int n = nums.length;

        // If there is only one element, max and min are the same,
        // so the difference is always 0.
        if (n == 1) {
            return 0;
        }

        // Sort the array so that we can divide it into two parts:
        // Left part  -> add k
        // Right part -> subtract k
        Arrays.sort(nums);

        // Initially, consider the array without changing any values.
        // This is the original difference between maximum and minimum.
        int res = nums[n - 1] - nums[0];

        // Try every possible partition:
        //
        // [nums[0] ... nums[i]]       -> add k
        // [nums[i+1] ... nums[n-1]]   -> subtract k
        //
        // Example:
        // [1, 3, 6, 10]
        //       i
        //
        // Left  = [1, 3]  -> +k
        // Right = [6, 10] -> -k
        for (int i = 0; i < n - 1; i++) {

            // Possible maximum after modifications:
            //
            // nums[n - 1] - k -> largest element from right part
            // nums[i] + k     -> largest element from left part
            int maxi = Math.max(
                nums[n - 1] - k,
                nums[i] + k
            );

            // Possible minimum after modifications:
            //
            // nums[0] + k     -> smallest element from left part
            // nums[i + 1] - k -> smallest element from right part
            int mini = Math.min(
                nums[0] + k,
                nums[i + 1] - k
            );

            // Update the smallest possible difference
            // between maximum and minimum.
            res = Math.min(res, maxi - mini);
        }

        return res;
    }
}
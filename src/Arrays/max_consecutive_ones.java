/*
<metadata>
    <name>Max Consecutive Ones</name>
    <url>https://leetcode.com/problems/max-consecutive-ones/description/</url>
    <description>Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 
Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-25</date>
</metadata>
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int runningSumOfOnes = 0;
        for(int num : nums) {
            if(num == 0) {
                runningSumOfOnes = 0;
            } else { 
                runningSumOfOnes++;
            }
            maxOnes = Math.max(maxOnes, runningSumOfOnes);
        }
        return maxOnes;
    }
}
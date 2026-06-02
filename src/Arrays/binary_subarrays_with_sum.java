/*
<metadata>
<name>Binary Subarrays With Sum</name>
<description>Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 
Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]


Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15


 
Constraints:

1 <= nums.length <= 3 * 104nums[i] is either 0 or 1.0 <= goal <= nums.length</description>
<url>https://leetcode.com/problems/binary-subarrays-with-sum/description/</url>
<status>Completed</status>
<remarks>Atmost Approach</remarks>
<date>2026-06-02</date>
<level>Medium</level>
<notes>Solution:
https://leetcode.com/problems/binary-subarrays-with-sum/solutions/4873917/why-usual-sliding-window-fails-approach-dfwpm/
</notes>
</metadata>
*/
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left++];
            }

            count += right - left + 1;
        }

        return count;
    }
}
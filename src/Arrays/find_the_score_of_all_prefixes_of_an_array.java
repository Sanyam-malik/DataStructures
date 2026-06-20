/*
<metadata>
<name>Find the Score of All Prefixes of an Array</name>
<description>We define the conversion array conver of an array arr as follows:

conver[i] = arr[i] + max(arr[0..i]) where max(arr[0..i]) is the maximum value of arr[j] over 0 <= j <= i.

We also define the score of an array arr as the sum of the values of the conversion array of arr.

Given a 0-indexed integer array nums of length n, return an array ans of length n where ans[i] is the score of the prefix nums[0..i].

 
Example 1:

Input: nums = [2,3,7,5,10]
Output: [4,10,24,36,56]
Explanation: 
For the prefix [2], the conversion array is [4] hence the score is 4
For the prefix [2, 3], the conversion array is [4, 6] hence the score is 10
For the prefix [2, 3, 7], the conversion array is [4, 6, 14] hence the score is 24
For the prefix [2, 3, 7, 5], the conversion array is [4, 6, 14, 12] hence the score is 36
For the prefix [2, 3, 7, 5, 10], the conversion array is [4, 6, 14, 12, 20] hence the score is 56

Example 2:

Input: nums = [1,1,2,4,8,16]
Output: [2,4,8,16,32,64]
Explanation: 
For the prefix [1], the conversion array is [2] hence the score is 2
For the prefix [1, 1], the conversion array is [2, 2] hence the score is 4
For the prefix [1, 1, 2], the conversion array is [2, 2, 4] hence the score is 8
For the prefix [1, 1, 2, 4], the conversion array is [2, 2, 4, 8] hence the score is 16
For the prefix [1, 1, 2, 4, 8], the conversion array is [2, 2, 4, 8, 16] hence the score is 32
For the prefix [1, 1, 2, 4, 8, 16], the conversion array is [2, 2, 4, 8, 16, 32] hence the score is 64

 
Constraints:

1 <= nums.length <= 1051 <= nums[i] <= 109</description>
<url>https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/description/</url>
<status>Completed</status>
<date>2026-05-24</date>
<level>Medium</level>
<companies>Tiktok</companies>
</metadata>
*/
class Solution {
    public long[] findPrefixScore(int[] nums) {
        if(nums.length == 1) {
            return new long[]{nums[0]};
        }
        int[] maxPrefix = new int[nums.length];
        maxPrefix[0] = nums[0];
        for(int i=1; i<nums.length;i++) {
            maxPrefix[i] = Math.max(maxPrefix[i-1], nums[i]);
        }

        long[] result = new long[nums.length];
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i] + maxPrefix[i];

            result[i] = sum;

        }

        return result;
    }
}
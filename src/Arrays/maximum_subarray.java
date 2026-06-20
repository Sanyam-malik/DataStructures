/*
<metadata>
<name>Maximum Subarray</name>
<description>Given an integer array nums, find the subarray with the largest sum, and return its sum. 

Example 1:Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104</description>
<url>https://leetcode.com/problems/maximum-subarray/description/</url>
<status>Completed</status>
<date>2026-05-26</date>
<level>Medium</level>
<companies>Uber:Apple:Adobe:Cisco:Paytm:Amazon:Google:Shopee:Vmware:Oracle:Samsung:Infosys:Linkedin:Facebook:JPMorgan:Docusign:Microsoft:Bloomberg:ByteDance:Salesforce:Service Now:Goldman Sachs:Walmart</companies>
</metadata>
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int runningSum = 0;

        for(int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            max = Math.max(runningSum, max);
            if(runningSum < 0) {
                runningSum = 0;
            }
        }
        return max;       
    }
}
/*
<metadata>
    <name>Number of Good Pairs</name>
    <url>https://leetcode.com/problems/number-of-good-pairs/description/</url>
    <description>Given an array of integers nums, return the number of good pairs.





A pair (i, j) is called good if nums[i] == nums[j] and i < j.





 




Example 1:




Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.





Example 2:




Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.





Example 3:




Input: nums = [1,2,3]
Output: 0





 




Constraints:




1 <= nums.length <= 100
1 <= nums[i] <= 100</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-12</date>
</metadata>
*/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int max = -1;
        for(int num: nums) {
            max = Math.max(max, num);
        }


        int[] temp = new int[max+1];
        for(int num: nums) {
            temp[num] +=1;
        }


        int pairs = 0;
        for(int occurance: temp) {
            if(occurance >= 2) {
                pairs += ((occurance)*(occurance-1)/2);
            }
        }
        return pairs;


    }
}

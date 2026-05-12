/*
<metadata>
    <name>Count Elements With Maximum Frequency</name>
    <url>https://leetcode.com/problems/count-elements-with-maximum-frequency/description/</url>
    <description>You are given an array nums consisting of positive integers.





Return the total frequencies of elements in nums such that those elements all have the maximum frequency.





The frequency of an element is the number of occurrences of that element in the array.





 




Example 1:




Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.





Example 2:




Input: nums = [1,2,3,4,5]
Output: 5
Explanation: All elements of the array have a frequency of 1 which is the maximum.
So the number of elements in the array with maximum frequency is 5.





 




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
    public int maxFrequencyElements(int[] nums) {
        int max = -1;
        for(int num: nums) {
            max = Math.max(num, max);
        }


        int[] temp = new int[max+1];
        for(int num:nums) {
            temp[num] += 1;
        }


        max = -1;
        for(int t: temp) {
            max = Math.max(max, t);
        }


        int count = 0;
        for(int t: temp) {
            if(max == t) count+=t;
        }
        return count;
    }
}

/*
<metadata>
    <name>Rearrange Array Elements by Sign</name>
    <url>https://leetcode.com/problems/rearrange-array-elements-by-sign/description/</url>
    <description>You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.You should return the array of nums such that the array follows the given conditions:Every consecutive pair of integers have opposite signs.For all integers with the same sign, the order in which they were present in nums is preserved.The rearranged array begins with a positive integer.Return the modified array after rearranging the elements to satisfy the aforementioned conditions.</description>
    <notes></notes>
    <status>Completed</status>
    <level>Medium</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-24</date>
</metadata>
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];

        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;
    }
}
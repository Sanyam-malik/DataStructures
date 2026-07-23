/*
<metadata>
<name>Find First and Last Position of Element in Sorted Array</name>
<description>Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 
Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:
Input: nums = [], target = 0
Output: [-1,-1]</description>
<url>https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/</url>
<status>Completed</status>
<date>2026-07-24</date>
<level>Medium</level>
<companies>Uber:Adobe:Wipro:Amazon:Google:Oracle:VMWare:Airtel:Qualys:Meta:LinkedIn:Bloomberg:Verifone:ByteDance:Microsoft:Goldman Sachs</companies>
</metadata>
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);

        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = findBound(nums, target, false);

        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, boolean first) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;

                if (first) {
                    end = mid - 1;      // keep searching left
                } else {
                    start = mid + 1;    // keep searching right
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
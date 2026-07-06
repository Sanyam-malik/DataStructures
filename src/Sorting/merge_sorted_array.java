/*
<metadata>
<name>Merge Sorted Array</name>
<description>You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 
Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.</description>
<url>https://leetcode.com/problems/merge-sorted-array/description/</url>
<status>Completed</status>
<date>2026-07-06</date>
<level>Easy</level>
<companies>Uber:Apple:Amazon:Shopee:Indeed:Oracle:Meta:Linkedin:Microsoft:Bloomberg</companies>
</metadata>
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = m - 1;          // Last valid element in nums1
        int nums2Index = n - 1;          // Last element in nums2
        int mergeIndex = m + n - 1;      // Position to fill in nums1

        while (nums1Index >= 0 && nums2Index >= 0) {
            if (nums1[nums1Index] > nums2[nums2Index]) {
                nums1[mergeIndex] = nums1[nums1Index];
                nums1Index--;
            } else {
                nums1[mergeIndex] = nums2[nums2Index];
                nums2Index--;
            }
            mergeIndex--;
        }

        // Copy any remaining elements from nums2
        while (nums2Index >= 0) {
            nums1[mergeIndex] = nums2[nums2Index];
            nums2Index--;
            mergeIndex--;
        }
    }
}
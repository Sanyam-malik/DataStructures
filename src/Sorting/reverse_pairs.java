/*
<metadata>
<name>Reverse Pairs</name>
<description>Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length andnums[i] > 2  nums[j].

 
Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2  1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2  1

Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2  1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2  1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2  1

 
Constraints:

1 <= nums.length <= 5  104-231 <= nums[i] <= 231 - 1</description>
<url>https://leetcode.com/problems/reverse-pairs/description/</url>
<status>Completed</status>
<remarks>See How Merge Sort can be leveraged</remarks>
<date>2026-07-16</date>
<level>Hard</level>
<companies>Amazon</companies>
</metadata>
*/
import java.util.*;

class Solution {
   public int reversePairs(int[] nums) {
       return mergeSort(nums, 0, nums.length - 1);
   }
   
   private static void merge(int[] nums, int low, int mid, int high) {
       ArrayList<Integer> temp = new ArrayList<>();
       int left = low;
       int right = mid + 1;
       
       while (left <= mid && right <= high) {
           if (nums[left] <= nums[right]) {
               temp.add(nums[left++]);
           } else {
               temp.add(nums[right++]);
           }
       }
       while (left <= mid) temp.add(nums[left++]);
       while (right <= high) temp.add(nums[right++]);
       
       for (int i = low; i <= high; i++) {
           nums[i] = temp.get(i - low);
       }
   }
   
   private static int CountPairs(int[] nums, int low, int mid, int high) {
       int cnt = 0;
       int right = mid + 1;
       for (int i = low; i <= mid; i++) {
           while (right <= high && (long) nums[i] > 2L * nums[right]) {
               right++;
           }
           cnt += (right - (mid + 1));
       }
       return cnt;
   }
   
   private static int mergeSort(int[] nums, int low, int high) {
       if (low >= high) return 0;
       int mid = (low + high) / 2;
       int cnt = mergeSort(nums, low, mid);
       cnt += mergeSort(nums, mid + 1, high);
       cnt += CountPairs(nums, low, mid, high);
       merge(nums, low, mid, high);
       return cnt;
   }
}
/*
<metadata>
<name>Find Pivot Index</name>
<description>Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

 
Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11


Example 2:

Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.

Example 3:

Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0
</description>
<url>https://leetcode.com/problems/find-pivot-index/description/</url>
<status>Completed</status>
<date>2026-06-07</date>
<level>Easy</level>
<notes>Why the two-pointer prefix/suffix approach does not guarantee a solution:

A pivot index i requires:

    sum(0..i-1) == sum(i+1..n-1)

The two-pointer approach only compares:

    prefixSum accumulated from the left
    suffixSum accumulated from the right

while moving both pointers inward simultaneously.

Problems:
1. Equal prefixSum and suffixSum does NOT imply that the current
   index is a pivot.
2. Many candidate pivot indices are never checked.
3. When left == right, the pivot element itself must be excluded
   from both sums, but the two-pointer method does not naturally
   maintain this condition.

Example:
    nums = [1, 7, 3, 6, 5, 6]

Pivot = 3 because:
    1 + 7 + 3 = 5 + 6 = 11

A two-pointer scan does not explicitly verify:
    leftSum(i) == rightSum(i)

for every index i, so it can miss valid pivots or return incorrect ones.

Therefore, the correct approach is to iterate each index and check:

    leftSum == totalSum - leftSum - nums[i]</notes>
</metadata>
*/
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int preFixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int sufFixSum = totalSum - preFixSum - nums[i];

            if (preFixSum == sufFixSum) {
                return i;
            }

            preFixSum += nums[i];
        }

        return -1;
    }
}
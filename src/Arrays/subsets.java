/*
<metadata>
<name>Subsets</name>
<description>Given an integer array nums of unique elements, return all possible  (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
 
Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]


Example 2:

Input: nums = [0]
Output: [[],[0]]

 
Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.</description>
<url>https://leetcode.com/problems/subsets/description/</url>
<status>Completed</status>
<date>2026-06-30</date>
<level>Medium</level>
</metadata>
*/
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}
/*
<metadata>
<name>Minimum Swaps to Sort</name>
<description>Given an array arr[] of distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.

Examples:
Input: arr[] = [2, 8, 5, 4]
Output: 1
Explanation: Swap 8 with 4 to get the sorted array.

Input: arr[] = [10, 19, 6, 3, 5]
Output: 2
Explanation: Swap 10 with 3 and 19 with 5 to get the sorted array.

Input: arr[] = [1, 3, 4, 5, 6]
Output: 0
Explanation: Input array is already sorted.</description>
<url>https://www.geeksforgeeks.org/problems/minimum-swaps/1</url>
<status>Completed</status>
<date>2026-07-19</date>
<level>Medium</level>
<companies>Microsoft</companies>
</metadata>
*/
import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // value -> current index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // nums[i] is not the element that should be here
            if (nums[i] != sorted[i]) {

                swaps++;

                // Find where the correct element currently exists
                int correctIndex = map.get(sorted[i]);

                // Update position of nums[i]
                map.put(nums[i], correctIndex);

                // Put correct element at index i
                nums[correctIndex] = nums[i];
                nums[i] = sorted[i];

                // Update position of correct element
                map.put(sorted[i], i);
            }
        }

        return swaps;
    }
}
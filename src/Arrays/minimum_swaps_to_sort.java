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
</metadata>
*/
class Solution {
    public int minSwaps(int nums[]) {
        int n = nums.length;

        // Store value and original index
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort according to values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // Already visited or already at correct position
            if (visited[i] || arr[i][1] == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][1];
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }
}
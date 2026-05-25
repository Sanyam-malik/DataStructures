/*
<metadata>
    <name>Count Number of Nice Subarrays</name>
    <url>https://leetcode.com/problems/count-number-of-nice-subarrays/description/</url>
    <description>Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 
Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].


Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.


Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16


 
Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
</description>
    <notes></notes>
    <status>Completed</status>
    <level>Medium</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-25</date>
</metadata>
*/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int oddCount = 0;
        int validStarts = 0;

        for (int right = 0; right < nums.length; right++) {

            // Include current element
            if ((nums[right] & 1) == 1) {
                oddCount++;
                validStarts = 0;
            }

            // Count valid subarrays when window has exactly k odds
            while (oddCount == k) {
                validStarts++;

                if ((nums[left] & 1) == 1) {
                    oddCount--;
                }

                left++;
            }

            result += validStarts;
        }

        return result;
    }
  
    /*
    public int numberOfSubarrays(int[] A, int k) {
        return atMost(A, k) - atMost(A, k - 1);
    }

    public int atMost(int[] A, int k) {
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            k -= A[j] % 2;
            while (k < 0)
                k += A[i++] % 2;
            res += j - i + 1;
        }
        return res;
    }
  */
}
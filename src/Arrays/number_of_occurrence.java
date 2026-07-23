/*
<metadata>
<name>Number of Occurrence</name>
<description>Given a sorted array arr[] and a number target, find the number of occurrences of target in given array. 

Examples:

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.

Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.</description>
<url>https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1</url>
<status>Completed</status>
<date>2026-07-24</date>
<level>Easy</level>
<companies>Zoho:Amazon:MakeMyTrip</companies>
</metadata>
*/
class Solution {
    
    int findBound(int[] nums, int target, boolean first) {
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
    
    int countFreq(int[] arr, int target) {
        // code here
        int first = findBound(arr, target, true);
        if(first == -1) {
            return 0;
        }
        
        int last = findBound(arr, target, false);
        
        return last - first + 1;
    }

}
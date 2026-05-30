/*
<metadata>
    <name>Two Sum - Pair with Given Sum</name>
    <url>https://www.geeksforgeeks.org/problems/key-pair5616/1</url>
    <description>Given an array arr[] of integers and another integer target. Determine if there exist two distinct indices such that the sum of their elements is equal to the target.

Examples:

Input: arr[] = [0, -1, 2, -3, 1], target = -2
Output: true
Explanation: arr[3] + arr[4] = -3 + 1 = -2

Input: arr[] = [1, -2, 1, 0, 5], target = 0
Output: false
Explanation: None of the pair makes a sum of 0

Input: arr[] = [11], target = 11
Output: false
Explanation: No pair is possible as only one element is present in arr[]

Constraints:
1 ≤ arr.size ≤ 105
-105 ≤ arr[i] ≤ 105
-2*105 ≤ target ≤ 2*105</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-30</date>
</metadata>
*/

class Solution {
    boolean twoSum(int arr[], int target) {
        HashSet<Integer> s = new HashSet<>();
        for (int num : arr) {
            if (s.contains(target - num)) {
                return true;
            }
            s.add(num);
        }
        return false;
    }
}
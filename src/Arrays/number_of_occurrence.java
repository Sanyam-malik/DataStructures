/*
<metadata>
    <name>Number of occurrence</name>
    <url>https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1</url>
    <description>Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 




Examples :



Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.


Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.



Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.



Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
1 ≤ target ≤ 106</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-12</date>
</metadata>
*/

class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int max = -1;

        for (int a : arr) {
            max = Math.max(max, a);
        }

        int[] temp = new int[max + 1];

        for (int a : arr) {
            temp[a] += 1;
        }

        if (target >= temp.length) return 0;

        return temp[target];
    }
}

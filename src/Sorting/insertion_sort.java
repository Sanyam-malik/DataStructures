/*
<metadata>
<name>Insertion Sort</name>
<description>Given an array arr[] of positive integers.The task is to complete the insertsort() function which is used to implement Insertion Sort. 


Examples:
Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: The sorted array will be [1, 3, 4, 7, 9].

Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Explanation: The sorted array will be [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].

Input: arr[] = [4, 1, 9]
Output: [1, 4, 9]
Explanation: The sorted array will be [1, 4, 9].</description>
<url>https://www.geeksforgeeks.org/problems/insertion-sort/1</url>
<status>Completed</status>
<date>2026-07-06</date>
<level>Easy</level>
</metadata>
*/
class Solution {
    // Please change the array in-place
    public void insertionSort(int input[]) {
        // code here
        for (int j = 1; j < input.length; j++) {
            int key = input[j];
            int i = j - 1;

            while (i >= 0 && input[i] > key) {
                input[i + 1] = input[i];
                i--;
            }

            input[i + 1] = key;
        }
    }

}
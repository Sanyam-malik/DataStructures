/*
<metadata>
<name>Selection Sort</name>
<description>Given an array arr, use selection sort to sort arr[] in increasing order.

Examples :

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: Maintain sorted (in bold) and unsorted subarrays. Select 1. Array becomes 1 4 3 9 7. Select 3. Array becomes 1 3 4 9 7. Select 4. Array becomes 1 3 4 9 7. Select 7. Array becomes 1 3 4 7 9. Select 9. Array becomes 1 3 4 7 9.

Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Input: arr[] = [38, 31, 20, 14, 30]
Output: [14, 20, 30, 31, 38]</description>
<url>https://www.geeksforgeeks.org/problems/selection-sort/1</url>
<status>Completed</status>
<date>2026-07-06</date>
<level>Easy</level>
<companies>Microsoft</companies>
</metadata>
*/
class Solution {
    void selectionSort(int[] input) {
        // code here
        for(int i=0; i< input.length;i++) {
            int minElemIndex = i;
            int minElem = input[minElemIndex];
            for(int j=i+1; j< input.length;j++) {
                if(input[j] < minElem) {
                    minElem = input[j];
                    minElemIndex = j;
                }
            }

            if(minElem < input[i]) {
                swap(i, minElemIndex, input);
            }
        }
    }
    
    void swap(int i, int j, int[] input){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
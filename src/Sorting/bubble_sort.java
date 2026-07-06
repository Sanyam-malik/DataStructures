/*
<metadata>
<name>Bubble Sort</name>
<description>Given an array, arr[]. Sort the array using bubble sort algorithm.

Examples :

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]Explanation: After Sorting the array in ascending order of their values is [1, 3, 4, 7, 9].
Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Explanation: Sort the array in ascending order of their values.

Input: arr[] = [1, 2, 3, 4, 5]
Output: [1, 2, 3, 4, 5]
Explanation: An array that is already sorted should remain unchanged after applying bubble sort.</description>
<url>https://www.geeksforgeeks.org/problems/bubble-sort/1</url>
<status>Completed</status>
<date>2026-07-06</date>
<level>Easy</level>
<companies>Microsoft:Wipro:Sap Labs:Cisco:Nagarro:RedBus:Accenture:Huawei</companies>
</metadata>
*/
class Solution {
    public void bubbleSort(int[] input) {
        for(int i=0; i< input.length;i++) {
            for(int j=i+1; j< input.length;j++) {
                if(input[i] > input[j]) {
                    swap(i, j, input);
                }
            }
        }
        
    }
    
    void swap(int i, int j, int[] input){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
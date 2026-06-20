/*
<metadata>
<name>First and Second Smallests</name>
<description>Given an array, arr[] of integers, your task is to return the smallest and second smallest element in the array. If the smallest and second smallest do not exist, return -1.

Examples:

Input: arr[] = [2, 4, 3, 5, 6]
Output: [2, 3] 
Explanation: 2 and 3 are respectively the smallest and second smallest elements in the array.

Input: arr[] = [1, 1, 1]
Output: [-1]
Explanation: Only element is 1 which is smallest, so there is no second smallest element.

Constraints:
1 ≤ arr.size ≤105
1 ≤ arr[i] ≤ 105</description>
<url>https://www.geeksforgeeks.org/problems/find-the-smallest-and-second-smallest-element-in-an-array3226/1</url>
<status>Completed</status>
<date>2026-05-12</date>
<level>Easy</level>
<companies>Amazon:Goldman Sachs:NPCI</companies>
</metadata>
*/
class Solution {
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        // code here
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for(int a: arr) {
            if(a < min) {
                secMin = min;
                min = a;
            }
            
            if(a > min && a < secMin) {
                secMin = a;
            }
        }
        
        if(secMin == Integer.MAX_VALUE) {
            return new ArrayList<>(List.of(-1));
        }
        return new ArrayList<>(List.of(min, secMin));
    }
}
/*
<metadata>
<name>Alternate Positive Negative</name>
<description>Given an unsorted array arr containing both positive and negative
 numbers. Your task is to rearrange the array and convert it into an 
array of alternate positive and negative numbers without changing the 
relative order.

Note: 
- Resulting array should start with a positive integer (0 will also be considered as a positive integer). 
-
 If any of the positive or negative integers are exhausted, then add the
 remaining integers in the answer as it is by maintaining the relative 
order.
- The array may or may not have the equal number of positive and negative integers.

Examples:

Input: arr[] = [9, 4, -2, -1, 5, 0, -5, -3, 2]
Output: [9, -2, 4, -1, 5, -5, 0, -3, 2]
Explanation: The positive numbers are [9, 4, 5, 0, 2] and the negative integers are [-2, -1, -5, -3]. Since, we need to start with the positive integer first and then negative integer and so on (by maintaining the relative order as well), hence we will take 9 from the positive set of elements and then -2 after that 4 and then -1 and so on.

Input: arr[] = [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8]
Output: [5, -5, 2, -2, 4, -8, 7, 1, 8, 0]
Explanation : The positive numbers are [5, 2, 4, 7, 1, 8, 0] and the negative integers are [-5,-2,-8]. According to the given conditions we will start from the positive integer 5 and then -5 and so on. After reaching -8 there are no negative elements left, so according to the given rule, we will add the remaining elements (in this case positive elements are remaining) as it in by maintaining the relative order.

Input: arr[] = [9, 5, -2, -1, 5, 0, -5, -3, 2]
Output: [9, -2, 5, -1, 5, -5, 0, -3, 2]
Explanation: The positive numbers are [9, 5, 5, 0, 2] and the negative integers are [-2, -1, -5, -3]. Since, we need to start with the positive integer first and then negative integer and so on (by maintaining the relative order as well), hence we will take 9 from the positive set of elements and then -2 after that 5 and then -1 and so on.

Constraints:
1 ≤ arr.size() ≤ 106
-106 ≤ arr[i] ≤ 106</description>
<url>https://www.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1</url>
<status>Completed</status>
<date>2026-05-19</date>
<level>Easy</level>
<companies>VMware:Amazon:Microsoft:Intuit:Paytm</companies>
</metadata>
*/
class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        List<Integer> posNo = new ArrayList<>();
        List<Integer> negNo = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(Integer a: arr) {
            if(a >= 0) {
                posNo.add(a);
            } else {
                negNo.add(a);
            }
        }
        
        
        int posIndex = 0;
        int negIndex = 0;
        int posSize = posNo.size();
        int negSize = negNo.size();
        
        while(posIndex < posSize && negIndex < negSize) {
            if((result.size())%2 == 0) {
                result.add(posNo.get(posIndex++));
            } else {
                result.add(negNo.get(negIndex++));
            }
        }
        
        while(posIndex < posSize) {
            result.add(posNo.get(posIndex++));
        }
        
        while(negIndex < negSize) {
            result.add(negNo.get(negIndex++));
        }
        
        for(int i=0; i<result.size();i++) {
            arr.set(i, result.get(i));
        }
    }
}
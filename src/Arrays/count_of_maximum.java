/*
<metadata>
    <name>Count of Maximum</name>
    <url>https://www.codechef.com/problems/MAXCOUNT</url>
    <description>Given an array AA of length NN, your task is to find the element which repeats in AA maximum number of times as well as the corresponding count. In case of ties, choose the smallest element.





Input Format





The first line contains a single integer TT— the number of test cases.






Each test case consists of two lines:



The first line contains an integer NN, the length of the array AA.
The second line contains NN space-separated integers representing the elements of AA.






Output Format



For each test case, output two space separated integers VV & CC. VV is the value which occurs maximum number of times and CC is its count.





Constraints




1≤T≤1001≤T≤100
1≤N≤1001≤N≤100
For all i in [1..N] : 1≤A[i]≤100001≤A[i]≤10000




Sample 1:


Input
Output
2
5
1 2 3 2 5
6
1 2 2 1 1 2
2 2
1 3


Explanation:





In first case 2 occurs twice whereas all other elements occur only once.
In second case, both 1 and 2 occur 3 times but 1 is smaller than 2.


</description>
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
    public int[] mostFrequent(int[] arr) {
        // write your code here 
        int max = -1;
        for(int a: arr) {
            max = Math.max(max, a);
        }
        
        int[] temp = new int[max+1];
        for(int a: arr) {
            temp[a] += 1;
        }
        
        int maxElem = -1;
        max = -1;
        for(int i=0; i<temp.length;i++) {
            if(temp[i] > max) {
                max = temp[i];
                maxElem = i;
            }
        }
        return new int[]{maxElem, max};
    }
}

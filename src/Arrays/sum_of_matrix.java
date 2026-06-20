/*
<metadata>
<name>Sum of Matrix</name>
<description>Given a non-null integer matrix mat[][] of size n × m, compute the sum of all its elements.

Examples:

Input: mat[][] = [[1, 0, 1],
                [-8, 9, -2]]
Output: 1
Explanation:
The sum of all elements of the matrix is (1 + 0 + 1 - 8 + 9 - 2) = 1.

Input: mat[][] = [[1, 0, 1, 0, 1],
                [0, 1, 0, 1, 0],
               [-1, -1, -1, -1, -1]]
Output: 0
Explanation:
The sum of all elements of the matrix is:
(1 + 0 + 1 + 0 + 1 + 0 + 1 + 0 + 1 + 0 - 1 - 1 - 1 - 1 - 1) = 0.

Constraints:
1 ≤ n, m ≤ 103
-103 ≤ mat[i][j] ≤ 103</description>
<url>https://www.geeksforgeeks.org/problems/sum-of-elements-in-a-matrix2000/1</url>
<status>Completed</status>
<date>2026-05-14</date>
<level>Easy</level>
<companies>Zoho</companies>
</metadata>
*/
class Solution {
    public int sumOfMatrix(int[][] mat) {
        // code here
        
        int sum = 0;
        for(int i=0;i<mat.length;i++) {
            for(int j=0; j<mat[0].length;j++) {
                sum += mat[i][j];
            }
        }
        
        return sum;
    }
}
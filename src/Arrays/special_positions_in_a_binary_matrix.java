/*
<metadata>
    <name>Special Positions in a Binary Matrix</name>
    <url>https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/</url>
    <description>Given an m x n binary matrix mat, return the number of special positions in mat.





A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).





 




Example 1:




Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
Output: 1
Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.





Example 2:




Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Explanation: (0, 0), (1, 1) and (2, 2) are special positions.





 




Constraints:




m == mat.length
n == mat[i].length
1 <= m, n <= 100
mat[i][j] is either 0 or 1.</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-14</date>
</metadata>
*/

class Solution {
    public int numSpecial(int[][] mat) {


        int rows = mat.length;
        int cols = mat[0].length;


        int[] rowSum = new int[rows];
        int[] colSum = new int[cols];


        // Calculate row sums
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rowSum[i] += mat[i][j];
            }
        }


        // Calculate column sums
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                colSum[j] += mat[i][j];
            }
        }


        int count = 0;


        // Count special positions
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {


                if (mat[i][j] == 1 &&
                    rowSum[i] == 1 &&
                    colSum[j] == 1) {


                    count++;
                }
            }
        }


        return count;
    }
}

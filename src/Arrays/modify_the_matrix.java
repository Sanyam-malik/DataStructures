/*
<metadata>
<name>Modify the Matrix</name>
<description>Given a 0-indexed m x n integer matrix matrix, create a new 0-indexed matrix called answer. Make answer equal to matrix, then replace each element with the value -1 with the maximum element in its respective column.

Return the matrix answer.

Input: matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
Output: [[1,2,9],[4,8,6],[7,8,9]]
Explanation: The diagram above shows the elements that are changed (in blue).
- We replace the value in the cell [1][1] with the maximum value in the column 1, that is 8.
- We replace the value in the cell [0][2] with the maximum value in the column 2, that is 9.

Input: matrix = [[3,-1],[5,2]]
Output: [[3,2],[5,2]]
Explanation: The diagram above shows the elements that are changed (in blue).

Constraints:

m == matrix.length
n == matrix[i].length
2 <= m, n <= 50
-1 <= matrix[i][j] <= 100

The input is generated such that each column contains at least one non-negative integer.

</description>
<url>https://leetcode.com/problems/modify-the-matrix/description/</url>
<status>Completed</status>
<date>2026-06-17</date>
<level>Easy</level>
</metadata>
*/
class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = getColMax(matrix, j);
                }   
            }
        }
        return matrix;
    }
    public int getColMax(int[][]matrix, int col){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][col] > max) max = matrix[i][col];
        }
        return max;
    }
}
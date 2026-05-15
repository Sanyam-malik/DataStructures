/*
<metadata>
    <name>Transpose Matrix</name>
    <url>https://leetcode.com/problems/transpose-matrix/description/</url>
    <description>Given a 2D integer array matrix, return the transpose of matrix.





The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.









 




Example 1:




Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]





Example 2:




Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-15</date>
</metadata>
*/

class Solution {
    public int[][] transpose(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;


        int[][] result = new int[M][N];


        for(int i=0; i< N;i++) {
            for(int j=0;j<M;j++) {
                result[j][i] = matrix[i][j];
            }
        }


        return result;
    }
}
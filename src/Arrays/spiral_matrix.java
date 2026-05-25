/*
<metadata>
    <name>Spiral Matrix</name>
    <url>https://leetcode.com/problems/spiral-matrix/description/</url>
    <description>Given an m x n matrix, return all elements of the matrix in spiral order.
 
Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
</description>
    <notes></notes>
    <status>Completed</status>
    <level>Medium</level>
    <companies></companies>
    <remarks>Revise Again</remarks>
    <concepts></concepts>
    <date>2026-05-25</date>
</metadata>
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> arr = new ArrayList<>();

        while (left <= right && up <= down) {

            // left -> right
            for (int j = left; j <= right; j++) {
                arr.add(matrix[up][j]);
            }
            up++;

            // top -> bottom
            for (int i = up; i <= down; i++) {
                arr.add(matrix[i][right]);
            }
            right--;

            // right -> left
            if (up <= down) {
                for (int j = right; j >= left; j--) {
                    arr.add(matrix[down][j]);
                }
                down--;
            }

            // bottom -> top
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    arr.add(matrix[i][left]);
                }
                left++;
            }
        }

        return arr;
    }
}
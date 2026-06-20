/*
<metadata>
<name>Matrix Zig Zag Diagonal Traversal</name>
<description>Given a square matrix mat[][], find its diagonal pattern, where the elements are arranged linearly by traversing the matrix diagonally, as illustrated in the examples below.

Examples:

Input: mat[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]

Output: [1, 2, 4, 7, 5, 3, 6, 8, 9]

Explanation: 
Start from 1. 
Then from upward to downward diagonally i.e. 2 and 4.
Then from downward to upward diagonally i.e 7, 5, 3.
Then from up to down diagonally i.e 6, 8.
Then down to up i.e. end at 9. 

Input: mat[][]=[[1, 2, 3, 10],[4, 5, 6, 11],[7, 8, 9, 12],[13, 14, 15, 16]]

Output: [1, 2, 4, 7, 5, 3, 10, 6, 8, 13, 14, 9, 11, 12, 15, 16]

Explanation: 
Start from 1.
Then from upward to downward diagonally i.e. 2 and 4.
Then from downward to upward diagonally i.e 7, 5, 3.
Then from upward to downward diagonally i.e. 10 6 8 13.
Then from downward to upward diagonally i.e 14 9 11.
Then from upward to downward diagonally i.e. 12 15 then end at 16.               

Constraints:
1 ≤  |mat| ≤  103
-100  ≤  elements of matrix ≤  100</description>
<url>https://www.geeksforgeeks.org/problems/print-matrix-in-diagonal-pattern/1</url>
<status>Completed</status>
<date>2026-06-13</date>
<level>Medium</level>
<companies>Amazon</companies>
</metadata>
*/
class Solution {
    public List<Integer> matrixDiagonally(int[][] mat) {
        List<Integer> result = new ArrayList<>();

        if (mat == null || mat.length == 0) {
            return result;
        }

        int n = mat.length;
        int m = mat[0].length;

        int row = 0, col = 0;
        int direction = 1; // 1 = up-right, 0 = down-left

        for (int i = 0; i < n * m; i++) {
            result.add(mat[row][col]);

            if (direction == 1) { // moving up-right
                if (col == m - 1) {
                    row++;
                    direction = 0;
                } else if (row == 0) {
                    col++;
                    direction = 0;
                } else {
                    row--;
                    col++;
                }
            } else { // moving down-left
                if (row == n - 1) {
                    col++;
                    direction = 1;
                } else if (col == 0) {
                    row++;
                    direction = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}
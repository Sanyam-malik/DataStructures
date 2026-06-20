/*
<metadata>
<name>Toeplitz Matrix</name>
<description>Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

Examples

Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.

Input: matrix = [[1,2],[2,2]]
Output: false
Explanation:
The diagonal "[1, 2]" has different elements.

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 20
0 <= matrix[i][j] <= 99

Follow up:

What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once? What if the matrix is so large that you can only load up a partial row into the memory at once?</description>
<url>https://leetcode.com/problems/toeplitz-matrix/description/</url>
<status>Completed</status>
<date>2026-06-10</date>
<level>Easy</level>
<companies>Facebook:Bloomberg</companies>
</metadata>
*/
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {

                if(matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }

            }
        }

        return true;
    }
}
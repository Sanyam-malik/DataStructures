/*
<metadata>
    <name>Lucky Numbers in a Matrix</name>
    <url>https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/</url>
    <description>Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.

Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.

All elements in the matrix are distinct.</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks>Revise Again</remarks>
    <concepts></concepts>
    <date>2026-05-20</date>
</metadata>
*/

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;


        int row_maximum_of_minimums = 0;
        for (int[] row : matrix) {

            int row_minimum = Arrays.stream(row).min().getAsInt();
            row_maximum_of_minimums = Math.max(row_maximum_of_minimums, row_minimum);
        }


        int col_minimum_of_maximums = Integer.MAX_VALUE;
        for (int col_ind = 0; col_ind < cols; ++col_ind) {
            int col_maximum = 0;
            for (int row_ind = 0; row_ind < rows; ++row_ind) {
                col_maximum = Math.max(col_maximum, matrix[row_ind][col_ind]);
            }
            col_minimum_of_maximums = Math.min(col_minimum_of_maximums, col_maximum);
        }


        return row_maximum_of_minimums == col_minimum_of_maximums ? Collections.singletonList(col_minimum_of_maximums) : Collections.emptyList();
    }
}
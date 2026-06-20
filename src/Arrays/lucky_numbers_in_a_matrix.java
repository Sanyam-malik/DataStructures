/*
<metadata>
<name>Lucky Numbers in a Matrix</name>
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
1 <= matrix[i][j] <= 105

All elements in the matrix are distinct.</description>
<url>https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/</url>
<status>Completed</status>
<date>2026-05-26</date>
<level>Easy</level>
<companies>Apple</companies>
</metadata>
*/
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxAmongRowMins = Integer.MIN_VALUE;

        // Find the largest value among all row minimums
        for (int row = 0; row < rows; row++) {
            int rowMin = Integer.MAX_VALUE;

            for (int col = 0; col < cols; col++) {
                rowMin = Math.min(rowMin, matrix[row][col]);
            }

            maxAmongRowMins = Math.max(maxAmongRowMins, rowMin);
        }

        int minAmongColMaxes = Integer.MAX_VALUE;

        // Find the smallest value among all column maximums
        for (int col = 0; col < cols; col++) {
            int colMax = Integer.MIN_VALUE;

            for (int row = 0; row < rows; row++) {
                colMax = Math.max(colMax, matrix[row][col]);
            }

            minAmongColMaxes = Math.min(minAmongColMaxes, colMax);
        }

        // A lucky number must satisfy both conditions
        if (maxAmongRowMins == minAmongColMaxes) {
            return Collections.singletonList(maxAmongRowMins);
        }

        return Collections.emptyList();
    }
}
/*
<metadata>
<name>Spiral Matrix</name>
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
-100 <= matrix[i][j] <= 100</description>
<url>https://leetcode.com/problems/spiral-matrix/description/</url>
<status>Completed</status>
<remarks>Revise Again</remarks>
<date>2026-05-26</date>
<level>Medium</level>
<companies>Jio:OYO:Zoho:Uber:Apple:Adobe:Wipro:Paytm:Cisco:Amazon:Google:Zillow:Oracle:Facebook:LiveRamp:JPMorgan:SAP Labs:Microsoft:Accenture:Cognizant:Salesforce:Browserstack</companies>
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
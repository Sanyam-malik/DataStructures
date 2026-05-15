/*
<metadata>
    <name>Print Matrix in snake Pattern</name>
    <url>https://www.geeksforgeeks.org/problems/print-matrix-in-snake-pattern-1587115621/1</url>
    <description>Given a matrix mat[][] of size n x n. Print the elements of the matrix in the snake like pattern depicted below.






Examples :



Input: n = 3, mat[][] = [[45, 48, 54], [21, 89, 87], [70, 78, 15]]
Output: [45, 48, 54, 87, 89, 21, 70, 78, 15] 
Explanation: Printing it in snake pattern will lead to the output as [45, 48, 54, 87, 89, 21, 70, 78, 15] 
.


Input: n = 2, mat[][] = [[1, 2], [3, 4]]
Output: [1, 2, 4, 3] 
Explanation: Printing it in snake pattern will give output as [1, 2, 4, 3]..



Constraints:
1 <= n <= 103
1 <= mat[i][j] <= 109</description>
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
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for(int i=0; i<matrix.length;i++) {
            
            boolean isEven = i%2 == 0;
            
            if(isEven) {
                for(int j=0; j<matrix[0].length;j++) {
                    arrList.add(matrix[i][j]);
                }   
            } else {
                for(int j=matrix[0].length-1;j>=0;j--) {
                    arrList.add(matrix[i][j]);
                }
            }
        }
        
        return arrList;
        
    }
}
package questions;

public class SurroundOnes {
    
    public int checkForSurrounds(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int overallCount = 0;
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < m; column++) {
                if (matrix[row][column] == 1) {
                    int countZero = 0;
                    int up = row - 1;
                    int down = row + 1;
                    int left = column - 1;
                    int right = column + 1;
                    
                    if (up >= 0)
                        countZero += matrix[up][column] == 0 ? 1 : 0;
                    if (down < n)
                        countZero += matrix[down][column] == 0 ? 1 : 0;
                    if (left >= 0)
                        countZero += matrix[row][left] == 0 ? 1 : 0;
                    if (right < m)
                        countZero += matrix[row][right] == 0 ? 1 : 0;
                    if (up >= 0 && left >= 0)
                        countZero += matrix[up][left] == 0 ? 1 : 0;
                    if (up >= 0 && right < m)
                        countZero += matrix[up][right] == 0 ? 1 : 0;
                    if (down < n && left >= 0)
                        countZero += matrix[down][left] == 0 ? 1 : 0;
                    if (down < n && right < m)
                        countZero += matrix[down][right] == 0 ? 1 : 0;
                    if ((countZero & 1) == 0 && countZero != 0)
                        overallCount++;
                }
            }
        }
        return overallCount;
    }


    public static void main(String args[]) {
        SurroundOnes ob = new SurroundOnes();
        int[][] matrix = {
            {1, 0, 0},
            {1, 1, 0},
            {0, 1, 0}
        };
        System.out.println(ob.checkForSurrounds(matrix));
    }
}

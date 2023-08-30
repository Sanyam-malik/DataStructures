// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/100

public class MaximumOfOnes {

    public int maximumOfOnes(int[][] matrix) {
        // Constructing a new array which stores count row wise
        int n = matrix.length;
        int m = matrix[0].length;
        int counts[] = new int[n];
        for (int row = 0; row < n; row++) {
            int count = 0;
            for (int column = 0; column < m; column++) {
                if (matrix[row][column] == 1) {
                    count++;
                }
            }
            counts[row] = count;
        }


        // Finding Row with greator count
        int maxIndex = 0;
        for(int i=0;i<counts.length;i++){
            if(counts[maxIndex] < counts[i]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }


    public static void main(String args[]) {
        MaximumOfOnes ob = new MaximumOfOnes();
        int[][] matrix = {
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        System.out.println(ob.maximumOfOnes(matrix));
    }

}
// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/467

public class RotateMatrix {
    public void transpose(int arr[][], int n){
        int temparr[][] = new int[n][n];
        for(int i=0; i< n; i++) {
            for(int j=0; j< n; j++){
                // Rotate 90 degress (clockwise)
                int elem = arr[n-1-i][j];
                temparr[j][i] = elem;
            }
        }
        
        // Reassigning value back to original
        for(int i=0; i< n; i++) {
            for(int j=0; j< n; j++){
                int elem = temparr[i][j];
                arr[i][j] = elem;
            }
        }
    }

    public void printMatrix(int arr[][], int N){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
    }

    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3},{4,5,6},{7,8,9}};
        int N = arr.length;
        RotateMatrix tm = new RotateMatrix();
        tm.transpose(arr, N);
        tm.printMatrix(arr, N);
    }
}
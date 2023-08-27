// Problem statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/64

public class TransposeMatrix {
    
    public void transpose(int arr[][], int n){
        int temparr[][] = new int[n][n];
        for(int i=0; i< n; i++) {
            for(int j=0; j< n; j++){
                int elem = arr[i][j];
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
        int arr[][] = {{1, 1, 1, 1},{2, 2, 2, 2},{3, 3, 3, 3},{4, 4, 4, 4}};
        int N = arr.length;
        TransposeMatrix tm = new TransposeMatrix();
        tm.transpose(arr, N);
        tm.printMatrix(arr, N);
    }
}

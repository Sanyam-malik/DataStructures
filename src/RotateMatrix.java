// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/467

public class RotateMatrix {
    public void rotate90Clockwise(int arr[][], int n){
        int temparr[][] = new int[n][n];
        for(int i=0; i< n; i++) {
            for(int j=0; j< n; j++){
                // Rotate 90 degress (clockwise)
                int elem = arr[n-1-i][j];
                // Transpose logic
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

    public void rotate90AntiClockwise(int arr[][], int n){
        int temparr[][] = new int[n][n];
        for(int i=0; i< n; i++) {
            for(int j=0; j< n; j++){
                // Rotate 90 degress (anticlockwise)
                int elem = arr[i][n-1-j];
                // Transpose logic
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

    public void rotate180(int arr[][], int n){
        int temparr[][] = new int[n][n];
        for(int i=0; i< n; i++) {
            for(int j=0; j< n; j++){
                // Rotate 180 degrees
                int elem = arr[n-1-i][n-1-j];
                // Direct logic
                temparr[i][j] = elem;
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
        int arr1[][] = {{1, 2, 3},{4,5,6},{7,8,9}};
        int arr2[][] = {{1, 2, 3},{4,5,6},{7,8,9}};
        int arr3[][] = {{1, 2, 3},{4,5,6},{7,8,9}};
        int arr4[][] = {{1, 2, 3},{4,5,6},{7,8,9}};
        int N = arr1.length;
        RotateMatrix tm = new RotateMatrix();
        
        System.out.println();
        System.out.println("Top View \n");
        tm.rotate180(arr1, N);
        tm.printMatrix(arr1, N);
        System.out.println();

        System.out.println("Bottom View (Original) \n");
        tm.printMatrix(arr2, N);
        System.out.println();

        System.out.println("Right View \n");
        tm.rotate90Clockwise(arr3, N);
        tm.printMatrix(arr3, N);
        System.out.println();

        System.out.println("Left View \n");
        tm.rotate90AntiClockwise(arr4, N);
        tm.printMatrix(arr4, N);
        System.out.println();
    }
}
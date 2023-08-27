// Problem statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/76

public class RotateArray{

    public void rotate(int arr[], int k){
        int temparr[] = new int[arr.length];
        int index = -1;

        for(int i=k; i<=arr.length-1;i++) {
            temparr[++index] = arr[i];
        }

        for(int i=0; i<k;i++) {
            temparr[++index] = arr[i];
        }

        this.printArray(temparr, temparr.length);
    }

    public void printArray(int arr[], int N){
        for(int i=0;i<N;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 3, 6, 11, 12, 17, 22, 26, 30, 33, 38};
        int k = 7;
        RotateArray tm = new RotateArray();
        tm.rotate(arr, k);
    }
}
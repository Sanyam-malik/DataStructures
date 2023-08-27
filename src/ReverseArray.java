// Problem statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/71

public class ReverseArray{

    public void reverse(int arr[], int k){
        int temparr[] = new int[arr.length];
        int index = -1;

        for(int i=0; i<=k;i++) {
            temparr[++index] = arr[i];
        }

        for(int i=arr.length-1; i>k; i--) {
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
        int arr[] = {1, 4, 5, 6, 6, 7, 7 };
        int k = 3;
        ReverseArray tm = new ReverseArray();
        tm.reverse(arr, k);
    }
}
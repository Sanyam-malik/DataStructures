// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/74

public class Sort012 {

    public int arr[];

    public void quicksort(int start, int end) {
        if(start < end) {
            int pivot = partition(start, end);
            quicksort(start, pivot-1);
            quicksort(pivot+1, end);
        }
    }



    private int partition(int start, int end) {
        int pivot = end;
        int idx = start - 1;
        int index = start;

        while(index < pivot) {
            if(arr[index] < arr[pivot]){
                int temp = arr[++idx];
                arr[idx] = arr[index];
                arr[index] = temp;
            }
            index = index+1;
        }

        int temp = arr[++idx];
        arr[idx] = arr[end];
        arr[end] = temp; 
        return idx;
    }

    public void printArray(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = {0, 1, 2, 2, 1, 0};
        Sort012 o1 = new Sort012();
        o1.arr = arr;
        o1.quicksort(0, arr.length-1);
        o1.printArray();
    }
}

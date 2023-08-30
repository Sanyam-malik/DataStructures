// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/112

public class MinimumSwaps {
    public int arr[];
    public int count = 0;

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
                count++;
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
        int arr[] = {1,5, 4, 3, 2};
        MinimumSwaps o1 = new MinimumSwaps();
        o1.arr = arr;
        o1.quicksort(0, arr.length-1);
        o1.printArray();
        System.out.println("Minimum Swaps: ");
        System.out.println(o1.count);
    }
}

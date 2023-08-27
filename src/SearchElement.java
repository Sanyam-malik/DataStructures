// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/58

// Here we will use the Linear search because to use binary search we will have to sort the elements which will change index of element causing test cases to fail
import java.util.Arrays;

public class SearchElement {
    
    //Method 1 Linear Search 
    public int linearSearch(int array[], int elemToFind) {
        int index = -1;
        for(int i=0; i< array.length; i++) {
            if(elemToFind == array[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    //Method 2 Binary Search 
    public int binarySearch(int array[], int elemToFind) {
        Arrays.sort(array);
        int start = 0;
        int end = array.length-1;
        while(start <= end) {
            int mid = (end-start/2);
            if(array[mid] == elemToFind) {
                return mid;
            }
            else if(array[mid] < elemToFind) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String args[]) {
        SearchElement ob = new SearchElement();
        int array[] = {1,2,3,4};
        System.out.println(ob.linearSearch(array, 5));
        System.out.println(ob.binarySearch(array, 5));
    }
}
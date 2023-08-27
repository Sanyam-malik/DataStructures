// Problem statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/57
public class MissingNo {

    public int findMissingNo(int arr[]){
        int sum = 0;
        int naturalSum = 0;
        int N = arr.length + 1;

        // Iterative Way of finding natural sum 
        for(int index = 1; index <= N ; index++) {
            naturalSum+=index;
        }

        // Short hand way of natural sum;
        naturalSum = (N*(N+1))/2;
        
        for(int index = 0; index < arr.length; index++) {
            sum+=arr[index];
        }

        return naturalSum-sum;
    }

    public static void main(String args[]) {
        int arr[] = {1,2,3,5};
        MissingNo m = new MissingNo();
        System.out.println(m.findMissingNo(arr));
    }
}

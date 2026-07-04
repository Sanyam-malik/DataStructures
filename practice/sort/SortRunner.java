import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortRunner {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the length of array");
        int n = Integer.parseInt(br.readLine());

        System.out.println("Enter the elements of the array");
        int[] input = new int[n];
        while(n--> 0) {
            input[n] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter Sort Type \n1. Bubble\n2. Selection\n3. Insertion\n4.Merge\n5.Quick");
        int type = Integer.parseInt(br.readLine());
        SortType sortType = switch (type) {
            case 1 -> SortType.BUBBLE;
            case 2 -> SortType.SELECTION;
            case 3 -> SortType.INSERTION;
            case 4 -> SortType.MERGE;
            case 5 -> SortType.QUICK;
            default -> SortType.UNKNOWN;
        };

        Sort sort = SortFactory.getSortInstance(sortType);
        System.out.println("Before sorting: ");
        System.out.println(Arrays.toString(input));
        System.out.println("After sorting: ");
        System.out.println(Arrays.toString(sort.sort(input)));

    }
}

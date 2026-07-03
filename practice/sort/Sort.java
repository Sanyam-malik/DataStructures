public interface Sort {

    int[] sort(int[] input);

    SortType sortType();

    default void swap(int i, int j, int[] input){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}

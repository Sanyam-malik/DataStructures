public class BubbleSort implements Sort {

    @Override
    public int[] sort(int[] input) {
        for(int i=0; i< input.length;i++) {
            for(int j=i+1; j< input.length;j++) {
                if(input[i] > input[j]) {
                    swap(i, j, input);
                }
            }
        }
        return input;
    }

    @Override
    public SortType sortType() {
        return SortType.BUBBLE;
    }
}

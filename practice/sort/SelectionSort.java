public class SelectionSort implements Sort {

    @Override
    public int[] sort(int[] input) {
        for(int i=0; i< input.length;i++) {
            int minElemIndex = i;
            int minElem = input[minElemIndex];
            for(int j=i+1; j< input.length;j++) {
                if(input[j] < minElem) {
                    minElem = input[j];
                    minElemIndex = j;
                }
            }

            if(minElem < input[i]) {
                swap(i, minElemIndex, input);
            }
        }
        System.out.println("Hii");
        return input;
    }

    @Override
    public SortType sortType() {
        return SortType.SELECTION;
    }
}

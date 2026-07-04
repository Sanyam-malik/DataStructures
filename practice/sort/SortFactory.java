public class SortFactory {

    private SortFactory() {}

    public static Sort getSortInstance(SortType sortType) {
        if(SortType.BUBBLE == sortType) {
            return new BubbleSort();
        } else if(SortType.SELECTION == sortType) {
            return new SelectionSort();
        } else if(SortType.INSERTION == sortType) {
            return new InsertionSort();
        } else if(SortType.MERGE == sortType) {
            return new MergeSort();
        } else if(SortType.QUICK == sortType) {
            return new QuickSort();
        } else {
            throw new RuntimeException("Unknown Sort Type....");
        }
    }
}

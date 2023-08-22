package basics;

public class BinarySearch<T extends Number> {

    Collections<T> list;
    String type;
    String sort = SORT_QUICK;

    public static final String SORT_BUBBLE = "bubble";

    public static final String SORT_INSERTION = "insertion";

    public static final String SORT_SELECTION = "selection";

    public static final String SORT_QUICK = "quick";

    public static final String SORT_MERGE = "merge";

    public BinarySearch(Collections<T> list, String type) {
        this.list = list;
        this.type = type;
    }

    public BinarySearch(Collections<T> list, String sort, String type) {
        this.list = list;
        this.type = type;
        this.sort = sort;
    }

    public boolean contains(T data) {
        if(sort.equalsIgnoreCase(SORT_BUBBLE)) {
            BubbleSort<T> bubbleSort = new BubbleSort<>(list, type);
            bubbleSort.sort();
            this.list = bubbleSort.list;
        }
        if(sort.equalsIgnoreCase(SORT_SELECTION)) {
            SelectionSort<T> selectSort = new SelectionSort<>(list, type);
            selectSort.sort();
            this.list = selectSort.list;
        }
        if(sort.equalsIgnoreCase(SORT_INSERTION)) {
            InsertionSort<T> insertSort = new InsertionSort<>(list, type);
            insertSort.sort();
            this.list = insertSort.list;
        }
        if(sort.equalsIgnoreCase(SORT_MERGE)) {
            
        }
        if(sort.equalsIgnoreCase(SORT_QUICK)) {
            
        }
        return binarySearch(0, list.size()-1, data);
    }

    public boolean binarySearch(int start, int end, T data) {
        while(start< end){
            int mid = (end-start/2)+1;

            if(list.get(mid).doubleValue() == data.doubleValue()) {
                return true;
            }
            else if(list.get(mid).doubleValue() > data.doubleValue()) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
    
}

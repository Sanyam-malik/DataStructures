package basics;
public class QuickSort<E extends Number> {
    public static final String TYPE_ASCENDING = "ASCENDING";

    public static final String TYPE_DESCENDING = "DESCENDING";

    Collections<E> list;
    String type;

    public QuickSort(Collections<E> list){
        this.list = list;
        this.type = TYPE_ASCENDING;
    }

    
    public QuickSort(Collections<E> list, String type){
        this.list = list;
        this.type = type;
    }

    public void sort(){
        int start = 0;
        int end = list.size() - 1;
        quicksort(start, end);
    }


    private void quicksort(int start, int end) {
        if(start < end) {
            int pvtIdx = partition(start, end);
            quicksort(start, pvtIdx-1);
            quicksort(pvtIdx+1, end);
        }
    }

    private int partition(int start, int end){
        int pivot = end;
        int idx = start-1;
        for(int index = start; index < end; index++) {
            if(this.type.equalsIgnoreCase(TYPE_ASCENDING)) {
                if(list.get(index).doubleValue() < list.get(pivot).doubleValue()) {
                    E data = list.get(++idx);
                    list.set(idx, list.get(index));
                    list.set(index, data);
                }
            } else {
                if(list.get(index).doubleValue() > list.get(pivot).doubleValue()) {
                    E data = list.get(++idx);
                    list.set(idx, list.get(index));
                    list.set(index, data);
                }
            }
        }

        E data = list.get(++idx);
        list.set(idx, list.get(end));
        list.set(end, data);
        return idx; 
    }
}

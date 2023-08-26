package basics;

import java.util.Iterator;

public class QuickSort<T extends Number> {
public Collections<T> list;

    public static final String TYPE_LINKEDLIST = "linkedlist";

    public static final String TYPE_ARRAYLIST = "arraylist";

    public QuickSort(Collections<T> list, String type) {
        if(type.equalsIgnoreCase(TYPE_ARRAYLIST)) {
            list = new ArrayList<>();
        } else {
            list = new LinkedList<>();
        }
        Iterator<T> it  = list.iterator();
        while(it.hasNext()) {
            T elem = it.next();
            this.list.add(elem);
        }
    }

    public void sort() {
        quicksort(0, this.list.size()-1);
    }

    public void quicksort(int start, int end) {
        int idx = partition(start, end);
        quicksort(start, idx-1);
        quicksort(idx+1, end);
    }

    private int partition(int start, int end) {
        int pivot = end;
        int idx = start-1;
        for(int index = start; index < end; index++) {
            if(list.get(index).doubleValue() < list.get(pivot).doubleValue()) {
                T temp = list.get(++idx);
                list.set(idx, list.get(index));
                list.set(index, temp);
            }
        }

        T temp = list.get(++idx);
        list.set(idx, list.get(pivot));
        list.set(pivot, temp);
        return idx;
    }


}

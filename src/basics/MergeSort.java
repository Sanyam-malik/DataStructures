package basics;

import java.util.Iterator;

public class MergeSort<T extends Number> {

    public Collections<T> list;

    public static final String TYPE_LINKEDLIST = "linkedlist";

    public static final String TYPE_ARRAYLIST = "arraylist";

    public MergeSort(Collections<T> list, String type) {
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
        divide(0, this.list.size()-1);
    }

    public void divide(int start, int end) {
        if(start >= end) return;
        int mid = end-start/2;
        divide(start, mid);
        divide(mid+1, end);
        conquer(start, mid, end);
    }

    private void conquer(int start, int mid, int end) {
        ArrayList<T> newlist = createArrayList(start, end);
        int index = -1;

        int idx1 = start;
        int idx2 = mid+1;
        while(idx1 <= mid && idx2 <= end) {
            if(this.list.get(idx2).doubleValue() < this.list.get(idx1).doubleValue()) {
                newlist.set(++index, newlist.get(idx2++));
            } else {
                newlist.set(++index, newlist.get(idx1++));
            }
        }

        while(idx1<=mid) {
            newlist.set(++index, newlist.get(idx1++));
        }

        while(idx2<=end) {
            newlist.set(++index, newlist.get(idx2++));
        }

        for(int virtualIndex = 0, realIndex=start; virtualIndex < newlist.size; virtualIndex++, realIndex++) {
            this.list.set(realIndex, newlist.get(virtualIndex));
        }
    }

    public ArrayList<T> createArrayList(int start, int end) {
        ArrayList<T> list = new ArrayList<>();
        int size = (end-start)+1;
        for(int index = 0; index < size; index++) {
            list.add(null);
        }
        return list;
    }
}

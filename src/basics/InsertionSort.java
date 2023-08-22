package basics;

import java.util.Iterator;

public class InsertionSort<T extends Number> {
    Collections<T> list;

    public static final String TYPE_LINKEDLIST = "linkedlist";

    public static final String TYPE_ARRAYLIST = "arraylist";

    public InsertionSort(Collections<T> list, String type) {
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
        int separationIndex = 0;
        for(int outIndex=1; outIndex< list.size(); outIndex++) {
            T elem = list.get(outIndex);
            while(separationIndex >= 0 &&  elem.doubleValue() < list.get(separationIndex).doubleValue()) {
                list.set(separationIndex+1, list.get(separationIndex));
                separationIndex--;
            }
            list.set(separationIndex, elem);
        }
    }
}

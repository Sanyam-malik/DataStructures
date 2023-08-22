package basics;

import java.util.Iterator;

public class SelectionSort<T extends Number> {
    public Collections<T> list;

    public static final String TYPE_LINKEDLIST = "linkedlist";

    public static final String TYPE_ARRAYLIST = "arraylist";

    public SelectionSort(Collections<T> list, String type) {
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
        for(int outIndex=0; outIndex< list.size(); outIndex++) {
            int smallIndex = outIndex;
            for(int inIndex=outIndex+1; inIndex< list.size(); inIndex++) {
                if(list.get(inIndex).doubleValue() < list.get(smallIndex).doubleValue()) {
                    smallIndex = inIndex;
                }
            }

            if(smallIndex != outIndex) {
                T temp = list.get(outIndex);
                list.set(outIndex, list.get(smallIndex));
                list.set(smallIndex, temp);
            }
        }
    }
}

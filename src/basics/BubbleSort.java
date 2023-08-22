package basics;

import java.util.Iterator;

public class BubbleSort<T extends Number> {
    Collections<T> list;

    public static final String TYPE_LINKEDLIST = "linkedlist";

    public static final String TYPE_ARRAYLIST = "arraylist";

    public BubbleSort(Collections<T> list, String type) {
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
            for(int inIndex=outIndex+1; inIndex< list.size(); inIndex++) {
                if(list.get(inIndex).doubleValue() > list.get(outIndex).doubleValue()) {
                    T temp = list.get(outIndex);
                    list.set(outIndex, list.get(inIndex));
                    list.set(inIndex, temp);
                }
            }
        }
    }
}
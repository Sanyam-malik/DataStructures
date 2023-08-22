package basics;

import java.util.Iterator;

public class LinearSearch<T extends Number> {
    
    Collections<T> list;

    public LinearSearch(Collections<T> list) {
        this.list = list;
    }

    public boolean contains(T data) {
        Iterator<T> it  = list.iterator();
        while(it.hasNext()) {
            T elem = it.next();
            if(elem.doubleValue() == data.doubleValue()) {
                return true;
            }
        }
        return false;
    }


}

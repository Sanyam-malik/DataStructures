package basics;
public class SelectionSort<E extends Number> {
    
    public static final String TYPE_ASCENDING = "ASCENDING";

    public static final String TYPE_DESCENDING = "DESCENDING";

    Collections<E> list;
    String type;

    public SelectionSort(Collections<E> list){
        this.list = list;
        this.type = TYPE_ASCENDING;
    }

    
    public SelectionSort(Collections<E> list, String type){
        this.list = list;
        this.type = type;
    }

    public void sort(){
        int lastIndex = list.size();
        for(int current=0 ; current < lastIndex; current++) {
            int index = current;
            
            for(int future=current+1 ; future < lastIndex; future++) {
                if(this.type.equalsIgnoreCase(TYPE_ASCENDING) && list.get(index).doubleValue() > list.get(future).doubleValue()) {
                    index = future;
                }
                if(this.type.equalsIgnoreCase(TYPE_DESCENDING) && list.get(index).doubleValue() < list.get(future).doubleValue()) {
                    index = future;
                }
            }
            
            if(index != current) {
                E temp = list.get(current);
                list.set(current, list.get(index));
                list.set(index, temp);
            }
        }
    }
}

package basics;


public class BubbleSort<E extends Number> {

    public static final String TYPE_ASCENDING = "ASCENDING";

    public static final String TYPE_DESCENDING = "DESCENDING";

    Collections<E> list;
    String type;

    public BubbleSort(Collections<E> list){
        this.list = list;
        this.type = TYPE_ASCENDING;
    }

    
    public BubbleSort(Collections<E> list, String type){
        this.list = list;
        this.type = type;
    }

    public void sort(){
        int lastIndex = list.size();
        for(int current=0 ; current < lastIndex; current++) {
            for(int future=current+1 ; future < lastIndex; future++) {
                if(this.type.equalsIgnoreCase(TYPE_ASCENDING) && list.get(current).doubleValue() > list.get(future).doubleValue()) {
                    E temp = list.get(current);
                    list.set(current, list.get(future));
                    list.set(future, temp);
                }

                if(this.type.equalsIgnoreCase(TYPE_DESCENDING) && list.get(current).doubleValue() < list.get(future).doubleValue()) {
                    E temp = list.get(current);
                    list.set(current, list.get(future));
                    list.set(future, temp);
                }
            }
        }
    }    
}

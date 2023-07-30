package basics;
public class InsertionSort<E extends Number> {
    public static final String TYPE_ASCENDING = "ASCENDING";

    public static final String TYPE_DESCENDING = "DESCENDING";

    Collections<E> list;
    String type;

    public InsertionSort(Collections<E> list){
        this.list = list;
        this.type = TYPE_ASCENDING;
    }

    
    public InsertionSort(Collections<E> list, String type){
        this.list = list;
        this.type = type;
    }

    public void sort(){
        int lastIndex = list.size();
        for(int current=1 ; current < lastIndex; current++) {
            int prev = current - 1;
            E currData = list.get(current);
            E prevData = list.get(prev);

            if(this.type.equalsIgnoreCase(TYPE_ASCENDING)){
                while(prev >=0 && currData.doubleValue() < prevData.doubleValue()){
                    list.set(prev+1, list.get(prev));
                    prevData = prev-1 >=0 ? list.get(prev-1) : null;
                    prev--;
                }
                list.set(prev+1, currData);
            } else {
                while(prev >=0 && currData.doubleValue() > prevData.doubleValue()){
                    list.set(prev+1, list.get(prev));
                    prevData = prev-1 >=0 ? list.get(prev-1) : null;
                    prev--;
                }
                list.set(prev+1, currData);
            }
        }
    }
}

package basics;
public class MergeSort<E extends Number> {
    public static final String TYPE_ASCENDING = "ASCENDING";

    public static final String TYPE_DESCENDING = "DESCENDING";

    Collections<E> list;
    String type;

    public MergeSort(Collections<E> list){
        this.list = list;
        this.type = TYPE_ASCENDING;
    }

    
    public MergeSort(Collections<E> list, String type){
        this.list = list;
        this.type = type;
    }

    public void sort(){
        int start = 0;
        int end = list.size() - 1;
        divide(start, end);
    }

    public void divide(int start, int end){
        if(start>=end){
            return;
        }
        int mid = start + (end - start)/2;
        divide(start, mid);
        divide(mid+1, end);
        conquer(start, mid, end);
    }

    public void conquer(int start, int middle, int end){
        Collections<E> newList = this.fill(start, end);

        int idx1 = start;
        int idx2 = middle + 1;
        int index = 0;

        /* Compare from both lists */
        while(idx1 <= middle && idx2 <= end) {
            if(this.type.equalsIgnoreCase(TYPE_ASCENDING)) {
                if(list.get(idx1).doubleValue() < list.get(idx2).doubleValue()) {
                    newList.set(index++, list.get(idx1++));
                } else {
                    newList.set(index++, list.get(idx2++));
                }
            } else {
                if(list.get(idx1).doubleValue() > list.get(idx2).doubleValue()) {
                    newList.set(index++, list.get(idx1++));
                } else {
                    newList.set(index++, list.get(idx2++));
                }
            }
        }

        /* Push remaining elements of 1st division */
        while(idx1 <= middle) {
            newList.set(index++, list.get(idx1++));
        }

        /* Push remaining elements of 2nd division */
        while(idx2 <= end) {
            newList.set(index++, list.get(idx2++));
        }

        for(int i=0, j=start; i<newList.size(); i++, j++){
            list.set(j, newList.get(i));
        }
    }

    /* 
     * to fill the new list initially
     */
    public Collections<E> fill(int start, int end) {
        Collections<E> newList = new ArrayList<>();
        int size = (end - start) + 1;
        int index = 0;
        while(index < size){
            newList.add(null);
            index = index + 1;
        }
        return newList;
    } 

}

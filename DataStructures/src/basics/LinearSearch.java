package basics;
public class LinearSearch<T extends Number> {
    Collections<? extends Number> collection;
    String type;

    public LinearSearch(Collections<? extends Number> collection) {
        this.collection = collection;
    }

    public int contains(T data) {
        int lastIndex = this.collection.size();
        for(int current=0 ; current < lastIndex; current++) {
            if(this.collection.get(current) == data){
                return current;
            }
        }
        return -1;
    }
}

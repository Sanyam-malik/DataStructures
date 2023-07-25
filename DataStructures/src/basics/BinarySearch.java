package basics;

public class BinarySearch<T extends Number> {

    Collections<? extends Number> collection;

    public BinarySearch(Collections<? extends Number> collection) {
        this.collection = collection;
    }

    public int contains(T data) {
        return binarySearch(0, collection.size() - 1, data.doubleValue());
    }

    private int binarySearch(int startIndex, int endIndex, double data){
        while(startIndex < endIndex){
            int mid = (startIndex + endIndex)/2 + 1;

            if(collection.get(mid).doubleValue() == data) {
                return mid;
            }

            if(collection.get(mid).doubleValue() < data) {
                endIndex = mid;
                startIndex++;
            }
            else {
                startIndex = mid;
                endIndex--;
            }
        }
        return -1;
    }
    
}

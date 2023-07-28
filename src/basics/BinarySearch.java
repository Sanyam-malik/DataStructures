package basics;

public class BinarySearch<T extends Number> {

    public static final String TYPE_ASCENDING = "ASCENDING";

    public static final String TYPE_DESCENDING = "DESCENDING";

    Collections<? extends Number> collection;
    String type;

    public BinarySearch(Collections<? extends Number> collection) {
        this.collection = collection;
        this.type = TYPE_ASCENDING;
    }

    public BinarySearch(Collections<? extends Number> collection, String type) {
        this.collection = collection;
        this.type = type;
    }

    public int contains(T data) {
        return type.equalsIgnoreCase(TYPE_ASCENDING) 
        ? binarySearch(0, collection.size() - 1, data.doubleValue()) 
        : reverseBinarySearch(0, collection.size() - 1, data.doubleValue());
    }

    private int binarySearch(int startIndex, int endIndex, double data){
        while(startIndex <= endIndex){
            int mid = (startIndex + endIndex)/2;

            if(collection.get(mid).doubleValue() == data) {
                return mid;
            }

            if(collection.get(mid).doubleValue() < data) {
                startIndex = mid + 1;
                System.out.println(startIndex);
            }
            else {
                endIndex = mid - 1;
                System.out.println(endIndex);
            }
        }
        return -1;
    }

    private int reverseBinarySearch(int startIndex, int endIndex, double data){
        while(startIndex <= endIndex){
            int mid = (startIndex + endIndex)/2;

            if(collection.get(mid).doubleValue() == data) {
                return mid;
            }

            if(collection.get(mid).doubleValue() < data) {
                endIndex = mid - 1;
            }
            else {
                startIndex = mid + 1;
            }
        }
        return -1;
    }
    
}

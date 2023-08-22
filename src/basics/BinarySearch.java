package basics;

public class BinarySearch<T extends Number> {

    Collections<T> list;

    public BinarySearch(Collections<T> list) {
        this.list = list;
    }

    public boolean contains(T data) {
        return binarySearch(0, list.size()-1, data);
    }

    public boolean binarySearch(int start, int end, T data) {
        while(start< end){
            int mid = (end-start/2)+1;

            if(list.get(mid).doubleValue() == data.doubleValue()) {
                return true;
            }
            else if(list.get(mid).doubleValue() > data.doubleValue()) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
    
}

package basics;
public class Queue<T> {

    public static final String IMPLEMENT_ARRAY="array";

    public static final String IMPLEMENT_LINKEDLIST="linkedList";

    public static final String TYPE_SINGLE="single";

    public static final String TYPE_DOUBLE="double";

    String implementation;
    String type;
    int frontIndex, rearIndex = -1;
    ArrayList<T> array = new ArrayList<>();
    LinkedList<T> linkedList = new LinkedList<>();

    public Queue(){
        this.implementation = IMPLEMENT_ARRAY;
    }

    public Queue(String implementation){
        this.implementation = implementation;
    }

    public Queue(String implementation, String type){
        this.implementation = implementation;
        this.type = type;
    }

    public void offer(T data) {
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST)){
            linkedList.add(data);
            changeIndex(0);
        } else {
            array.add(data);
            changeIndex(0);
        }
    }

    private void changeIndex(int operation){
        // 0 = add, 1 = remove;
        if(operation == 0){
            if(this.type.equalsIgnoreCase(TYPE_DOUBLE)){
                if(frontIndex < 0){
                    frontIndex++;
                    rearIndex=frontIndex;
                } else {
                    rearIndex++;    
                }
            }
            else {
                rearIndex++;
            }
        }
        if(operation == 1 && !this.isEmpty()){
            if(this.type.equalsIgnoreCase(TYPE_DOUBLE)){
                if(frontIndex < rearIndex){
                    frontIndex++;
                }
            }
            else {
                if(rearIndex > -1){
                    rearIndex--;
                }
            }
        }
    }

    public T poll() {
        if(!this.isEmpty()) {
            if(this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST)){
                if(this.type.equalsIgnoreCase(TYPE_DOUBLE)){
                    T data = linkedList.get(frontIndex);
                    changeIndex(1);
                    return data;
                }
                else {
                    T data = linkedList.get(0);
                    linkedList.remove(0);
                    changeIndex(1);
                    return data;
                }
            } else {
                if(this.type.equalsIgnoreCase(TYPE_DOUBLE)){
                    T data = array.get(frontIndex);
                    changeIndex(1);
                    return data;
                }
                else {
                    T data = array.get(0);
                    array.remove(0);
                    changeIndex(1);
                    return data;
                }
            }
        }
        return null;
    }

    public T peek() {
        if(!this.isEmpty()) {
            if(this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST)){
                return linkedList.get(frontIndex);
            } else {
                return array.get(0);
            }
        }
        return null;
    }

    public T peekFirst() {
        return this.peek();
    }

    public T peekLast() {
        if(!this.isEmpty()) {
            if(this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST)){
                return linkedList.get(rearIndex);
            } else {
                return array.get(rearIndex);
            }
        }
        return null;
    }

    public boolean isEmpty() {
        int size = this.size();
        return size == 0 ? true : false;  
    }

    public int size() {
        int size = this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST) ? linkedList.size() : array.size();
        //For determining the actual size because elements are not deleted actually in double or circular queue
        if((this.type.equalsIgnoreCase(TYPE_DOUBLE) || this.type.equalsIgnoreCase(TYPE_CIRCULAR)) && frontIndex > 0){
            size = size - frontIndex;
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int startIndex = this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST) ? frontIndex : 0; 
        int size = this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST) ? linkedList.size() : array.size();
        for(int index = startIndex; index < size; index++) {
            T elemT = this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST) ? this.linkedList.get(index) : this.array.get(index);
            sb.append(elemT.toString());
            if(index != size && index < size-1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
}

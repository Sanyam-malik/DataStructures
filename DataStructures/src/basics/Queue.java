package basics;
public class Queue<T> {

    public static final String IMPLEMENT_ARRAY="array";

    public static final String IMPLEMENT_LINKEDLIST="linkedList";

    public static final String TYPE_SINGLE="single";

    public static final String TYPE_DOUBLE="double";

    public static final String TYPE_CIRCULAR="circular";

    String implementation;
    String type;
    int frontIndex = -1;
    int rearIndex = -1;
    ArrayList<T> array = new ArrayList<>();
    LinkedList<T> linkedList = new LinkedList<>();

    Queue(){
        this.implementation = IMPLEMENT_ARRAY;
    }

    Queue(String implementation){
        this.implementation = implementation;
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
            if(this.type.equalsIgnoreCase(TYPE_CIRCULAR)){

            }
            else if(this.type.equalsIgnoreCase(TYPE_DOUBLE)){
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
        if(operation == 1){
            if(this.type.equalsIgnoreCase(TYPE_CIRCULAR)){

            }
            else if(this.type.equalsIgnoreCase(TYPE_DOUBLE)){
                if(frontIndex > -1){
                    frontIndex--;
                }
            }
            else {
                rearIndex--;
            }
        }
    }

    public T poll() {
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST)){
            
            T data = linkedList.get();
            //linkedList.remove(peekIndex);
            //peekIndex--;
            //return data;
        } else {
            //T data = array.get(peekIndex);
            //array.remove(peekIndex);
            //peekIndex--;
            //return data;
        }
    }

    public T peek() {
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST)){
            //return linkedList.get(peekIndex);
        } else {
            //return array.get(peekIndex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST) ? linkedList.size() : array.size();
        for(int index = 0; index < size; index++) {
            T elemT = this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST) ? this.linkedList.get(index) : this.array.get(index);
            sb.append(elemT.toString());
            if(index != size && index < size-1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
}

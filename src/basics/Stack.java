package basics;

public class Stack<T> {

    public static final String IMPLEMENT_ARRAY="array";

    public static final String IMPLEMENT_LINKEDLIST="linkedList";

    String implementation;
    int peekIndex = -1;
    ArrayList<T> array = new ArrayList<>();
    LinkedList<T> linkedList = new LinkedList<>();

    public Stack(){
        this.implementation = IMPLEMENT_ARRAY;
    }

    public Stack(String implementation){
        this.implementation = implementation;
    }

    public void push(T data) {
        if(this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST)){
            linkedList.add(data);
            peekIndex++;
        } else {
            array.add(data);
            peekIndex++;
        }
    }

    public T pop() {
        if(!this.isEmpty()) {
            if(this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST)){
                T data = linkedList.get(peekIndex);
                linkedList.remove(peekIndex);
                peekIndex--;
                return data;
            } else {
                T data = array.get(peekIndex);
                array.remove(peekIndex);
                peekIndex--;
                return data;
            }
        }
        return null;
    }

    public T peek() {
        if(!this.isEmpty()) {
            if(this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST)){
                return linkedList.get(peekIndex);
            } else {
                return array.get(peekIndex);
            }
        }
        return null;
    }

    public boolean isEmpty() {
        int size = this.implementation.equalsIgnoreCase(IMPLEMENT_LINKEDLIST) ? linkedList.size() : array.size();
        return size == 0 ? true : false;  
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

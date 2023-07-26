package basics;

import java.util.List;

public class ArrayList<T> implements Collections<T> {
    
    private T array[];
    private int size;

    public ArrayList() {
        array = (T[])new Object[10];
    }

    public void add(T data){
        if(size == array.length) {
            int newSize = (array.length + (array.length/2)) + 1;
            createNewArray(newSize);
            array[size] = data;
            size = size + 1;
        } else {
            array[size] = data;
            size = size + 1;
        }
    }

    private void createNewArray(int size){
        T newArray[] = (T[])new Object[size];
        for(int index = 0 ; index <= array.length - 1 ; index++){
            newArray[index] = array[index];
        }
        array = newArray;
    }

    public void addAll(List<T> dataList){
        for(T data: dataList){
            this.add(data);
        }
    }

    public void remove(T data){
        int index = contains(data);
        if(index > -1){
            this.remove(index);
        }
    }

    public void remove(int index){
        if(index < size){
            for(int ei = index; ei < size; ei++){
                array[ei] = array[ei+1];
            }
            size--;
        }
    }

    public T get(int index){
        if(index < size){
            return array[index];
        } else {
            return null;
        }
    }

    public void set(int index, T value){
        if(index < size){
            array[index] = value;
        }
    }

    public int contains(T data){
        for(int index = 0; index < size; index++) {
            if(data == array[index]) {
                return index;
            }
        }
        return -1;
    }

    public void clear(){
        array = (T[])new Object[10];
        size = 0;
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int index = 0; index < size; index++) {
            sb.append(array[index].toString());
            if(index != size && index < size-1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0 ? true : false;
    }
}

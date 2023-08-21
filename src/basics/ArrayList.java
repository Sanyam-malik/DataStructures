package basics;

public class ArrayList<T> {
    private T[] arr;
    public int size;

    public ArrayList(){
        this.arr = (T[]) new Object[2];
        this.size = 0;
    }


    public void add(T elem){
        if(size+1 >= arr.length) {
            int newArrSize = arr.length + (arr.length/2) + 1;
            T[] newArr = (T[])new Object[newArrSize];
            for(int index=0;index < arr.length; index++) {
                newArr[index] = arr[index];   
            }
            newArr[size] = elem;
            arr = newArr;
            size++;
        } else {
            arr[size] = elem;
            size++;
        }
    }


    public T get(int index) {
        if(index > size - 1) {
            return null;
        } else {
            return arr[index];
        }
    }


    public T set(int index, T elem) {
        if(index > size - 1) {
            return null;
        } else {
            arr[index] = elem;
            return arr[index];
        }
    }


    public T remove(int index) {
        if(index > size - 1) {
            return null;
        } else {
            T temp = arr[index];
            int currIndex = index;
            while(currIndex < size) {
                arr[currIndex] = arr[currIndex+1];
                currIndex++;
            }
            arr[currIndex] = null;
            size--;
            return temp;
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int index = 0; index < size; index++) {
            sb.append(index+1 < size ? arr[index].toString()+", " : arr[index].toString());
        }
        return sb.toString();
    }

    public static void main(String args[]){
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(10);
        arrList.add(40);
        arrList.add(80);
        arrList.add(20);
        arrList.set(1, 45);
        arrList.remove(0);
        System.out.println(arrList);
    }


}
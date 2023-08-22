package basics;

public class Stack<T> {

    ArrayList<T> arrList = new ArrayList<>();

    public T peek(){
        return arrList.get(arrList.size-1);
    }

    public void push(T data) {
        arrList.add(data);
    }

    public T pop(){
        return arrList.remove(arrList.size -1);
    }

    public String toString(){
        return arrList.toString();
    }

    public static void main(String args[]){
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(40);
        stack.push(80);
        stack.push(20);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

}

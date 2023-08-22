package basics;
public class Queue<T> {

    LinkedList<T> linkedList = new LinkedList<>();

    public T peek(){
        return linkedList.get(0);
    }

    public void push(T data) {
        linkedList.add(data);
    }

    public T pop(){
        return linkedList.remove(0);
    }

    public String toString(){
        return linkedList.toString();
    }

    public static void main(String args[]){
        Queue<Integer> linkList = new Queue<>();
        linkList.push(10);
        linkList.push(40);
        linkList.push(80);
        linkList.push(20);
        linkList.push(60);
        System.out.println(linkList);
        System.out.println(linkList.peek());
        System.out.println(linkList.pop());
        System.out.println(linkList);
    }
    
}

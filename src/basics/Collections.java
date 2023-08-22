package basics;

import java.util.Iterator;

public interface Collections<T> {
    
    public void add(T data);

    public T remove(int index);

    public T get(int index);

    public T set(int index, T value);

    public boolean isEmpty();

    public int size();

    public Iterator<T> iterator();
}

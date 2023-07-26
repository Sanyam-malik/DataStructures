package basics;

import java.util.List;

public interface Collections<T> {
    
    public void add(T data);

    public void addAll(List<T> dataList);

    public void remove(T data);

    public void remove(int index);

    public T get(int index);

    public int contains(T data);

    public int size();

    public boolean isEmpty();
}

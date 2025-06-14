package fourth;

public interface Array<T> {

    // Commands

    void add(T value);

    void remove(int index);

    void insert(int index, T value);


    // Requests

    T get(int index);

    int size();
}

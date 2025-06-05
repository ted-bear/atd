package first;

public class BoundedStack<T> implements Stack<T> {

    private static final int DEFAULT_CAPACITY = 32;

    private final T[] storage;
    private int size;
    private Status peekStatus;
    private Status popStatus;
    private Status pushStatus;

    public BoundedStack() {
        this(DEFAULT_CAPACITY);
    }

    public BoundedStack(int capacity) {
        storage = (T[]) new Object[capacity];
        clear();
    }


    @Override
    public void push(T item) {
        if (size + 1 == storage.length) {
            pushStatus = Status.PUSH_ERROR;
        } else {
            storage[size] = item;
            size++;
            pushStatus = Status.PUSH_OK;
        }
    }

    @Override
    public void pop() {
        if (size == 0) {
            popStatus = Status.POP_ERROR;
        } else {
            size--;
            popStatus = Status.POP_OK;
        }
    }

    @Override
    public T peek() {
        T result = null;

       if (size == 0) {
           pushStatus = Status.PUSH_ERROR;
       } else {
           result = storage[size - 1];
       }

       return result;
    }

    @Override
    public void clear() {
        pushStatus = Status.PUSH_NIL;
        popStatus = Status.POP_NIL;
        peekStatus = Status.PEEK_NIL;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Status peekStatus() {
        return peekStatus;
    }

    public Status popStatus() {
        return popStatus;
    }

    public Status pushStatus() {
        return pushStatus;
    }

    // commands and operations statuses

    public enum Status {

        POP_NIL(0),
        POP_OK(1),
        POP_ERROR(2),

        PEEK_NIL(0),
        PEEK_OK(1),
        PEEK_ERROR(2),

        PUSH_NIL(0),
        PUSH_OK(1),
        PUSH_ERROR(2),;

        final int code;

        Status(int code) {
            this.code = code;
        }
    }
}

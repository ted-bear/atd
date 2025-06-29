package fifth;

import java.util.LinkedList;

public class DynQueue<T> implements Queue<T> {

    private Status peekStatus = Status.NIL;
    private Status enqueueStatus = Status.NIL;
    private Status dequeStatus = Status.NIL;


    protected int size;
    protected final LinkedList<T> storage;

    public DynQueue() {
        storage = new LinkedList<>();
        size = 0;
    }

    @Override
    public T peekFront() {
        T res = null;

        if (size == 0) {
            peekStatus = Status.ERROR;
        } else {
            peekStatus = Status.OK;
            res = storage.getLast();
        }

        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addTail(T value) {
        storage.addFirst(value);
        enqueueStatus = Status.OK;
        size++;
    }

    public void removeFront() {
        if (size == 0) {
            dequeStatus = Status.ERROR;
        } else {
            dequeStatus = Status.OK;
            storage.removeLast();
            size--;
        }
    }

    public Status getPeekStatus() {
        return peekStatus;
    }

    public Status getEnqueueStatus() {
        return enqueueStatus;
    }

    public Status getDequeStatus() {
        return dequeStatus;
    }

    public enum Status {
        OK, ERROR, NIL
    }
}

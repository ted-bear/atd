package atd.sixth;

import atd.fifth.DynQueue;

public class DynDeque<T> extends DynQueue<T> implements Deque<T> {

    private Status peekTailStatus = Status.NIL;
    private Status addFrontStatus = Status.NIL;
    private Status removeTailStatus = Status.NIL;

    public DynDeque() {
        super();
    }

    @Override
    public T peekTail() {
        T res = null;

        if (size == 0) {
            peekTailStatus = Status.ERROR;
        } else {
            peekTailStatus = Status.OK;
            res = storage.getFirst();
        }

        return res;
    }

    @Override
    public void addFront(T value) {
        storage.addLast(value);
        addFrontStatus = Status.OK;
        size++;
    }

    @Override
    public void removeTail() {
        if (size == 0) {
            removeTailStatus = Status.ERROR;
        } else {
            removeTailStatus = Status.OK;
            storage.removeLast();
            size--;
        }
    }

    public Status getPeekTailStatus() {
        return peekTailStatus;
    }

    public Status getAddFrontStatus() {
        return addFrontStatus;
    }

    public Status getRemoveTailStatus() {
        return removeTailStatus;
    }
}

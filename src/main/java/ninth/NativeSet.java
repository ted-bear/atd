package ninth;

import common.Status;
import eight.NativeDictionary;

public class NativeSet<T> implements Set<T> {

    private Status putStatus = Status.NIL;
    private Status removeStatus = Status.NIL;

    private final NativeDictionary<T, Object> dictionary;
    private final Object object = new Object();

    public NativeSet(int size, Class<T> clazz) {
        dictionary = new NativeDictionary<>(size, clazz, Object.class);
    }

    @Override
    public void put(T element) {
        dictionary.put(element, object);
        putStatus = dictionary.getPutStatus();
    }

    @Override
    public void remove(T element) {
        dictionary.remove(element);
        removeStatus = dictionary.getRemoveStatus();
    }

    @Override
    public Boolean contains(T element) {
        if (dictionary.size() == 0) {
            return false;
        }

        dictionary.get(element);
        return dictionary.getGetStatus() == Status.OK;
    }

    @Override
    public int size() {
        return dictionary.size();
    }

    @Override
    public Status getPutStatus() {
        return putStatus;
    }

    @Override
    public Status getRemoveStatus() {
        return removeStatus;
    }
}

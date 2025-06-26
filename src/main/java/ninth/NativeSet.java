package ninth;

import java.util.List;

import common.Status;
import eight.NativeDictionary;

public class NativeSet<T> implements Set<T> {

    private Status putStatus = Status.NIL;
    private Status removeStatus = Status.NIL;

    private final NativeDictionary<T, Object> dictionary;
    private final Object object = new Object();
    private Integer capacity;
    private Class<T> type;

    public NativeSet(int sz, Class<T> clazz) {
        capacity = sz;
        type = clazz;
        dictionary = new NativeDictionary<>(sz, clazz, Object.class);
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

    public List<T> toList() {
        return dictionary.getKeys();
    }

    @Override
    public Set<T> intersection(Set<T> set2) {
        NativeSet<T> intersectionSet = new NativeSet<>(capacity, type);

        for (T el : intersectionSet.toList()) {
            if (contains(el)) {
                intersectionSet.put(el);
            }
        }

        return intersectionSet;
    }

    @Override
    public Set<T> union(Set<T> set2) {
        var unionSet = new NativeSet<>(capacity, type);

        for (T el : dictionary.getKeys()) {
            unionSet.put(el);
        }

        for (T el : set2.toList()) {
            unionSet.put(el);
        }

        return unionSet;
    }

    @Override
    public Set<T> difference(Set<T> set2) {
        var diffSet = new NativeSet<>(capacity, type);

        for (T el : dictionary.getKeys()) {
            if (!set2.contains(el)) {
                diffSet.put(el);
            }
        }

        return diffSet;
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

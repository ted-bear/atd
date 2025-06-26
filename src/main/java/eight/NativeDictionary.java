package eight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import common.Status;

public class NativeDictionary<K, V> implements Map<K, V> {

    private Status putStatus = Status.NIL;
    private Status removeStatus = Status.NIL;
    private Status getStatus = Status.NIL;

    private int size;
    private final int capacity;
    private final K[] slots;
    private final V[] values;

    public NativeDictionary(
            int sz,
            Class<?> keyClass,
            Class<?> valueClass
    ) {
        capacity = sz;
        slots = (K[]) Array.newInstance(keyClass, capacity);
        values = (V[]) Array.newInstance(valueClass, capacity);
    }


    @Override
    public void put(K key, V value) {
        if (size + 1 > capacity) {
            putStatus = Status.ERROR;
        } else {
            int index = seekSlot(key);

            if (slots[index] == null) {
                size++;
            }

            slots[index] = key;
            values[index] = value;
            putStatus = Status.OK;
        }
    }

    @Override
    public void remove(K key) {
        int firstIdx = hashFun(key);

        if (slots[firstIdx] == key) {
            removeElement(firstIdx);
            size--;
        } else {

            int idx = getIndex(firstIdx);
            while (idx != firstIdx) {
                if (slots[idx] == key) {
                    removeElement(firstIdx);
                    size--;
                    break;
                }
                idx = getIndex(idx);
            }

            if (idx == firstIdx) {
                removeStatus = Status.ERROR;
            }
        }
    }

    @Override
    public V get(K key) {
        int firstIndex = hashFun(key);

        if (Objects.equals(slots[firstIndex], key)) {
            getStatus = Status.OK;
            return values[firstIndex];
        }

        int index = getIndex(firstIndex);

        while (index != firstIndex) {
            if (Objects.equals(slots[index], key)) {
                getStatus = Status.OK;
                return values[index];
            }
            index = getIndex(index);
        }

        getStatus = Status.ERROR;
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Status getPutStatus() {
        return putStatus;
    }

    @Override
    public Status getRemoveStatus() {
        return removeStatus;
    }

    @Override
    public Status getGetStatus() {
        return getStatus;
    }

    public List<K> getKeys() {
        var list = new ArrayList<K>(slots.length);
        for (K slot : slots) {
            if (slot != null) {
                list.add(slot);
            }
        }
        return list;
    }

    private int hashFun(K key) {
        return key.hashCode() % size;
    }

    private int seekSlot(final K key) {
        int firstIndex = hashFun(key);

        if (slots[firstIndex] == null || key.equals(slots[firstIndex])) {
            return firstIndex;
        }

        int index = getIndex(firstIndex);

        while (index != firstIndex) {
            if (slots[index] == null || key.equals(slots[index])) {
                return index;
            }
            index = getIndex(index);
        }

        return index;
    }

    private int getIndex(int index) {
        return index + 1 < size ?
                index + 1 : 0;
    }

    private void removeElement(int firstIdx) {
        removeStatus = Status.OK;
        slots[firstIdx] = null;
        values[firstIdx] = null;
    }

}

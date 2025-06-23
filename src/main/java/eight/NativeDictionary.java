package eight;

import java.lang.reflect.Array;
import java.util.Objects;

public class NativeDictionary<K, V> implements Map<K, V> {

    private Status putStatus = Status.NIL;
    private Status removeStatus = Status.NIL;
    private Status getStatus = Status.NIL;

    public int size;
    public K[] slots;
    public V[] values;

    public NativeDictionary(
            int sz,
            Class<?> keyClass,
            Class<?> valueClass
    ) {
        size = sz;
        slots = (K[]) Array.newInstance(keyClass, this.size);
        values = (V[]) Array.newInstance(valueClass, this.size);
    }


    @Override
    public void put(K key, V value) {
        if (size + 1 > slots.length) {
            putStatus = Status.ERROR;
        } else {
            int index = seekSlot(key);
            slots[index] = key;
            values[index] = value;
            putStatus = Status.OK;
            size++;
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
            return values[firstIndex];
        }

        int index = getIndex(firstIndex);

        while (index != firstIndex) {
            if (Objects.equals(slots[index], key)) {
                return values[index];
            }
            index = getIndex(index);
        }

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

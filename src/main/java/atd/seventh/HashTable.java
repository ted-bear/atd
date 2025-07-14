package atd.seventh;

import java.util.Objects;

public class HashTable<T> {

    private Status putStatus = Status.NIL;
    private Status findStatus = Status.NIL;

    private T[] slots;
    private int size;
    private int step;

    // Предусловие:
    // Постусловие: Создан пустой массив заданной длины
    public HashTable(int size) {
        this.slots = (T[]) new Object[size];
        this.size = 0;
        this.step = 7;
    }

    // Commands

    // Предусловие: В массиве есть свободные слоты
    // Постусловие: Добавлен новый элемент
    public void put(T value) {
        int idx = value.hashCode() % size;

        if (slots[idx] == null) {
            slots[idx] = value;
            putStatus = Status.OK;
        } else {
            int nextIdx = getIndex(idx);

            while (slots[nextIdx] != null) {
                if (nextIdx <= idx && nextIdx + step >= idx) {
                    putStatus = Status.ERROR;
                    return;
                }

                nextIdx = getIndex(nextIdx);
            }

            slots[idx] = value;
        }
    }

    // Requests

    // Предусловие: Массив не пуст
    // Постусловие:
    public Boolean find(T value) {
        int firstIdx = value.hashCode() % size;

        if (Objects.equals(slots[firstIdx], value)) {
            return true;
        }

        int idx = getIndex(firstIdx);

        while (!Objects.equals(slots[idx], value)) {
            if (idx <= firstIdx && idx + step >= firstIdx) {
                return false;
            }

            idx = getIndex(idx);
        }

        return true;
    }

    public Status getPutStatus() {
        return putStatus;
    }

    public Status getFindStatus() {
        return findStatus;
    }

    private int getIndex(int idx) {
        return idx + step < size ?
                idx + step :
                (idx + step) % size;
    }

    public enum Status {
        OK, ERROR, NIL
    }

}

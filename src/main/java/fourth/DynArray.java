package fourth;

public class DynArray<T> implements Array<T> {

    private static final int DEFAULT_CAPACITY = 16;

    private int size;
    private T[] internalStorage;
    private int capacity;

    // Statuses
    private Status addStatus = Status.NIL;
    private Status removeStatus = Status.NIL;
    private Status insertStatus = Status.NIL;
    private Status getStatus = Status.NIL;

    public DynArray() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public DynArray(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.internalStorage = (T[]) new Object[capacity];
    }


    // Commands

    // Предусловия: Нет
    // Постусловия: Новый элемент в конце списка
    @Override
    public void add(T value) {
        if (size + 1 > capacity) {
            increaseStorage();
        }

        internalStorage[size] = value;
        addStatus = Status.OK;
        size++;
    }

    // Предусловия: Индекс валидный
    // Постусловия: Размер уменьшился, элемент удален
    @Override
    public void remove(int index) {
        if (!isValidIndex(index)) {
            removeStatus = Status.ERROR;
        } else {
            var copySize = size - (index + 1);
            System.arraycopy(internalStorage, index + 1, internalStorage, index, copySize);

            size--;
            removeStatus = Status.OK;
        }
    }

    // Предусловия: Индекс не больше длины массива
    // Постусловия: Добавлен новый элемент, при необходимости массив расширен
    @Override
    public void insert(int index, T value) {
        var isCorrectIndex = index >= 0 && index <= size;

        if (!isCorrectIndex) {
            insertStatus = Status.ERROR;
        } else {
            if (size + 1 > capacity) {
                increaseStorage();
            }

            if (index != size) {
                System.arraycopy(internalStorage, index, internalStorage, index + 1, size - index);
            }

            internalStorage[index] = value;
            insertStatus = Status.OK;
            size++;
        }
    }


    // Requests

    // Пресусловия: Список не пуст, индекс в допустимых границах
    // Постусловия: Нет
    @Override
    public T get(int index) {
        T res = null;

        var isIncorrectState = isEmpty() || !isValidIndex(index);
        if (isIncorrectState) {
            getStatus = Status.ERROR;
        } else {
            res = internalStorage[index];
            getStatus = Status.OK;
        }

        return res;
    }

    @Override
    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size() == 0;
    }

    public Status getAddStatus() {
        return addStatus;
    }

    public Status getGetStatus() {
        return getStatus;
    }

    public Status getInsertStatus() {
        return insertStatus;
    }

    public Status getRemoveStatus() {
        return removeStatus;
    }

    public int getCapacity() {
        return capacity;
    }

    private Boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    @SuppressWarnings("unchecked")
    private void increaseStorage() {
        var newCapacity = (capacity * 3) / 2 + 1;
        var newStorage = (T[]) new Object[newCapacity];

        System.arraycopy(internalStorage, 0, newStorage, 0, capacity);

        internalStorage = newStorage;
        capacity = newCapacity;
    }

    public enum Status {
        OK, ERROR, NIL
    }
}

package eight;

public interface Map<K, V> {

    // Commands

    // Предусловия: --
    // Постусловия: Добавлен элемент
    void put(K key, V value);

    // Предусловия: Элемент существует
    // Постусловия: Элемент удален
    void remove(K key);

    // Requests

    // Предусловия: Элемент существует
    // Постусловия: --
    V get(K key);

    int size();

    Status getPutStatus();

    Status getRemoveStatus();

    Status getGetStatus();

    enum Status {
        OK, ERROR, NIL
    }
}

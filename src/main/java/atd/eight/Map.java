package atd.eight;

import atd.common.Status;

public interface Map<K, V> {

    // Commands

    // Предусловия: --
    // Постусловия: Добавлен элемент или если он существовал значение изменено
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
}

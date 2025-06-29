package eight;

import common.Status;

public interface Map<K, V> {

    // Commands

    // Предусловия: --
    // Постусловия: Добавлен элемент или если он существовал значение изменено
    // постусловие: в массив добавлена новая пара ключ-значение,
    // если данный ключ отсутствовал;
    // в противном случае обновлено значение
    // для соответствующего ключа
    void put(K key, V value);

    // предусловие: ключ key присутствует в массиве
    // постусловие: ключ удаляется вместе со своим значением
    void remove(K key);

    // Requests

    // предусловие: ключ key присутствует в массиве
    V get(K key);

    int size();

    Status getPutStatus();

    Status getRemoveStatus();

    Status getGetStatus();
}

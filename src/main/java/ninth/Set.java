package ninth;

import common.Status;

public interface Set<T> {

    // Commands

    // Предусловия: --
    // Постусловия: Добавлен элемент или если он существовал значение изменено
    void put(T element);

    // Предусловия: Элемент существует
    // Постусловия: Элемент удален
    void remove(T element);

    // Requests

    // Предусловия: Множество не пустое
    // Постусловия: --
    Boolean contains(T element);

    int size();

    Status getPutStatus();

    Status getRemoveStatus();
}

package ninth;

import java.util.List;

import common.Status;

public interface Set<T> {

    // Commands

    // Предусловия: --
    // Постусловия: Добавлен элемент, если его не было
    void put(T element);

    // Предусловия: Элемент существует
    // Постусловия: Элемент удален
    void remove(T element);

    // Requests

    // Предусловия: Множество не пустое
    // Постусловия: --
    Boolean contains(T element);

    int size();

    Set<T> intersection(Set<T> set2);

    Set<T> union(Set<T> set2);

    Set<T> difference(Set<T> set2);

    List<T> toList();

    Status getPutStatus();

    Status getRemoveStatus();
}

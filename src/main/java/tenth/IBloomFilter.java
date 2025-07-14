package tenth;

import common.Status;

public interface IBloomFilter {

    // Commands

    // Предусловия: --
    // Постусловия: Добавляет в битовый массив значения вычисленные
    // для входного аргумента
    void add(String element);

    // Requests

    // Предусловия: Массив не пуст
    // Постусловия: --
    boolean contains(String element);

    Status getAddStatus();

    Status getContainsStatus();
}

package atd.fifth;

public interface Queue<T> {

    // Requests

    // Предусловия: Длина очереди не 0
    // Постусловия:
    T peekFront();

    // Предусловия: --
    // Постусловия: --
    int size();

    // Commands

    // Предусловия:
    // Постусловия: Добавлен элемент в хвост
    void addTail(T value);

    // Предусловия: Длина очереди не 0
    // Постусловия: Удален элемент с головы
    void removeFront();

}

package atd.second;

public class ParentList<T> {

    private Status headStatus = Status.NIL;
    private Status tailStatus = Status.NIL;
    private Status valueStatus = Status.NIL;
    private Status rightStatus = Status.NIL;
    private Status getStatus = Status.NIL;
    private Status putRightStatus = Status.NIL;
    private Status putLeftStatus = Status.NIL;
    private Status removeStatus = Status.NIL;
    private Status addToEmptyStatus = Status.NIL;
    private Status addTailStatus = Status.NIL;
    private Status replaceStatus = Status.NIL;
    private Status findStatus = Status.NIL;
    private Status removeAllStatus = Status.NIL;

    private Node<T> head;
    private Node<T> tail;
    private int size;

    protected Node<T> cursor;

    public ParentList() {}


    /// Команды ///

    // Предусловие: Список не пуст
    // Постусловие: курсор установлен на первый узел в списке
    public void head() {
        if (size() == 0) {
            headStatus = Status.ERR;
        } else {
            while (cursor.getPrev() != null) {
                cursor = cursor.getPrev();
            }
            headStatus = Status.OK;
        }
    }

    // Предусловие: Список не пуст
    // Постусловие: курсор установлен на последний узел в списке
    public void tail() {
        if (size() == 0) {
            tailStatus = Status.ERR;
        } else {
            while (cursor.getNext() != null) {
                cursor = cursor.getNext();
            }
            tailStatus = Status.OK;
        }
    }

    // Предусловие: Текущий элемент есть (т.е список не пуст) и есть элемент справа
    // Постусловие: курсор сдвинут на один узел вправо
    public void right() {
        if (size() == 0 || cursor.getNext() == null) {
            rightStatus = Status.ERR;
        } else {
            cursor = cursor.getNext();
            rightStatus = Status.OK;
        }
    }

    // Предусловие: Текущий элемент есть (т.е список не пуст)
    // Постусловие: следом за текущим узлом добавлен
    // новый узел с заданным значением
    public void putRight(T value) {
        if (size() == 0) {
            putRightStatus = Status.ERR;
        } else {
            var newNode = new Node<T>(value);
            cursor.setNext(newNode);
            newNode.setPrev(cursor);

            if (cursor == tail) {
                tail = newNode;
            }

            size++;
            putRightStatus = Status.OK;
        }
    }

    // Предусловие: Текущий элемент есть (т.е список не пуст)
    // Постусловие: перед текущим узлом добавлен
    // новый узел с заданным значением
    public void putLeft(T value) {
        if (size() == 0) {
            putLeftStatus = Status.ERR;
        } else {
            var newNode = new Node<T>(value);
            cursor.setPrev(newNode);
            newNode.setNext(cursor);

            if (cursor == head) {
                head = newNode;
            }

            size++;
            putLeftStatus = Status.OK;
        }
    }

    // Предусловие: Текущий элемент есть
    // Постусловие: Текущий элемент смещается вправо или в случае конца списка влево, иначе null
    public void remove() {
        if (size() == 0 || cursor == null) {
            removeStatus = Status.ERR;
        } else {
            if (cursor.getNext() != null) {
                cursor.getNext().setPrev(cursor.getPrev());

                if (cursor == head) {
                    head = cursor.getNext();
                }

                cursor = cursor.getNext();
            } else if (cursor.getPrev() != null) {
                cursor.getPrev().setNext(null);

                tail = cursor.getPrev();
                cursor = cursor.getPrev();
            } else {
                cursor = null;
                head = null;
                tail = null;
            }
            size--;
            removeStatus = Status.OK;
        }
    }

    // Предусловие: Список пуст
    // Постусловие: Курсор указывает на добавленный элемент и длина списка равна одному
    public void addToEmpty(T value) {
        if (size() == 0) {
            cursor = new Node<T>(value);
            head = cursor;
            tail = cursor;
            size++;
            addToEmptyStatus = Status.OK;
        } else {
            addToEmptyStatus = Status.ERR;
        }
    }

    // Предусловие: Список не пуст
    // Постусловие: новый узел добавлен в хвост списка
    public void addTail(T value) {
        if (size() == 0) {
            addTailStatus = Status.ERR;
        } else {
            var newNode = new Node<T>(value);
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
            size++;
            addTailStatus = Status.OK;
        }
    }

    // Предусловие: Список не пуст и текущий элемент существует
    // Постусловие: Текущее значение изменилось на заданное
    public void replace(T newValue) {
        if (cursor == null) {
            replaceStatus = Status.ERR;
        } else {
            cursor.setValue(newValue);
            replaceStatus = Status.OK;
        }
    }

    // Предусловие: Список не пуст
    // Постусловие: Курсор не Null
    public void find(T value) {
        cursor = cursor.getNext();

        while (cursor != null && !cursor.getValue().equals(value)) {
            cursor = cursor.getNext();
        }

        if (cursor == null) {
            findStatus = Status.ERR;
        } else {
            findStatus = Status.OK;
        }
    }

    // Предусловие: Список не пуст
    // Постусловие: в списке удалены все узлы с заданным значением
    public void removeAll(T value) {
        cursor = null;
        head = null;
        tail = null;
        size = 0;
        removeAllStatus = Status.OK;
    }

    /// Запросы ///

    // Предусловие: список не пуст
    public T get() {
        T res = null;

        if (cursor == null) {
            getStatus = Status.ERR;
        } else {
            getStatus = Status.OK;
            res = cursor.getValue();
        }
        return res;
    }

    // Предусловие: --
    // Постусловие: --
    public Integer size() {
        return size;
    }

    // Предусловие: --
    // Постусловие: --
    public Boolean isHead() {
        return cursor == head;
    }

    // Предусловие: --
    // Постусловие: --
    public Boolean isTail() {
        return cursor == tail;
    }

    // Предусловие: --
    // Постусловие: --
    public Boolean isValue() {
        return cursor != null;
    }

    // Запросы статуса //

    public Status getRightStatus() {
        return rightStatus;
    }

    public Status getGetStatus() {
        return getStatus;
    }

    public Status getPutRightStatus() {
        return putRightStatus;
    }

    public Status getPutLeftStatus() {
        return putLeftStatus;
    }

    public Status getRemoveStatus() {
        return removeStatus;
    }

    public Status getAddToEmptyStatus() {
        return addToEmptyStatus;
    }

    public Status getHeadStatus() {
        return headStatus;
    }

    public Status getTailStatus() {
        return tailStatus;
    }

    public Status getValueStatusStatus() {
        return valueStatus;
    }

    public Status getFindStatusStatus() {
        return findStatus;
    }

    public Status getAddTailStatus() {
        return addTailStatus;
    }

    public Status getReplaceStatus() {
        return replaceStatus;
    }

    public Status getRemoveAllStatus() {
        return removeAllStatus;
    }


    enum Status {
        OK, // курсор сместился вправо
        ERR, // курсор не сместился вправо (не выполнилось предусловие)
        NIL // команда не вызывалась
    }

    public static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

}

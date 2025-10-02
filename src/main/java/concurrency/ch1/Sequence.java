package concurrency.ch1;

public class Sequence {

    private int value;

    public synchronized int getNext() {
        return value++;
    }

    public int getValue() {
        return value;
    }
}

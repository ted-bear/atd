package concurrency.ch1;

public class UnsafeSequence {

    private int count;

    public void getNext() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

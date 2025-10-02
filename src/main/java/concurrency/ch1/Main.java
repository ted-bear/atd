package concurrency.ch1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var counter = new UnsafeSequence();
        var counter2 = new Sequence();

        var runner1 = new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++)
                    counter.getNext();
            }
        };

        var runner2 = new Runnable() {
             public void run() {
                for (int i = 0; i < 10000; i++)
                    counter.getNext();
            }
        };

        var t1 = new Thread(runner1);
        var t2 = new Thread(runner2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Unsafe sequence result: " + counter.getCount());

        var safeRunner1 = new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++)
                    counter2.getNext();
            }
        };

        var safeRunner2 = new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++)
                    counter2.getNext();
            }
        };

        var tr1 = new Thread(safeRunner1);
        var tr2 = new Thread(safeRunner2);

        tr1.start();
        tr2.start();

        tr1.join();
        tr2.join();

        System.out.println("Unsafe sequence result: " + counter2.getValue());
    }

}

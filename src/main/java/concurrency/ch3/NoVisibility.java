package concurrency.ch3;

import java.util.stream.IntStream;

public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            // NO visibility
            while (!ready) { Thread.yield(); }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, 100_000).forEach(i -> {
            new ReaderThread().start();
            number = 42;
            ready = true;
        });
    }
}

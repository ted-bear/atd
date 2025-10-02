package ooap2.twentyOne;

public class FacilityInheritance {
    public static void main(String[] args) throws Exception {
        try (var a = new A()) {
            a.doSomething();
        }
    }
}

class A implements AutoCloseable {

    public void doSomething() throws InterruptedException {
        System.out.println("I am sleepy");
        Thread.sleep(1000);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing A");
    }
}

package ooap2.twelve;

public class IntegerWrapper extends General implements Summable<IntegerWrapper> {

    private final Integer value;

    public IntegerWrapper(Integer value) {
        this.value = value;
    }

    @Override
    public IntegerWrapper sum(IntegerWrapper integerWrapper) {
        return new IntegerWrapper(value + integerWrapper.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

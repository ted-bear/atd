package ooap2.twelve;

public class General implements Cloneable {

    @Override
    protected final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected final General copy(Object other) throws CloneNotSupportedException {
        other = clone();
        return (General) other;
    }

    @Override
    public final String toString() {
        return super.toString();
    }

    @Override
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final boolean isType(Class<?> type) {
        return this.getClass().equals(type);
    }

    public final Class<?> getType() {
        return this.getClass();
    }

    public final void print() {
        System.out.println(this);
    }
}

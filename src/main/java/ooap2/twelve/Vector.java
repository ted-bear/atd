package ooap2.twelve;

import java.util.ArrayList;
import java.util.List;

public class Vector<T extends Summable<T>>
    extends General implements Summable<Vector<T>> {

    private Integer addStatus;
    private Integer sumStatus;

    private final List<T> elements;

    public Vector() {
        elements = new ArrayList<>();
    }

    public Vector(List<T> elements) {
        this.elements = elements;
    }

    public void addElement(T element) {
        try {
            elements.add(element);
            addStatus = 1;
        } catch (Exception e) {
            addStatus = 0;
        }
    }

    public Integer getAddStatus() {
        return addStatus;
    }

    public Integer getSumStatus() {
        return sumStatus;
    }

    public int getLength() {
        return elements.size();
    }

    @Override
    public Vector<T> sum(Vector<T> tVector) {
        // type check is unnecessary, compiler checks types
        if (tVector == null) {
            sumStatus = 0;
            return null;
        }

        if (tVector.getLength() != getLength()) {
            sumStatus = 0;
            return null;
        }

        var newVector = new Vector<T>();
        for (int i = 0; i < tVector.getLength(); i++) {
            var sum = elements.get(i).sum(tVector.elements.get(i));
            newVector.addElement(sum);
        }

        sumStatus = 1;
        return newVector;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}

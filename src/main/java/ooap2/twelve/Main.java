package ooap2.twelve;

public class Main {

    public static void main(String[] args) {
        var vectorVector = constructVector();
        var vector = constructVectorWith2LenOutside();

        System.out.println(vector.sum(vectorVector));

    }

    private static Vector<Vector<IntegerWrapper>> constructVector() {
        Vector<IntegerWrapper> vector1 = new Vector<>();
        vector1.addElement(new IntegerWrapper(1));
        vector1.addElement(new IntegerWrapper(2));
        vector1.addElement(new IntegerWrapper(3));

        Vector<IntegerWrapper> vector2 = new Vector<>();
        vector2.addElement(new IntegerWrapper(1));
        vector2.addElement(new IntegerWrapper(2));
        vector2.addElement(new IntegerWrapper(3));

        Vector<IntegerWrapper> vector3 = new Vector<>();
        vector3.addElement(new IntegerWrapper(1));
        vector3.addElement(new IntegerWrapper(2));
        vector3.addElement(new IntegerWrapper(3));

        var vectors = new Vector<Vector<IntegerWrapper>>();
        vectors.addElement(vector1);
        vectors.addElement(vector2);
        vectors.addElement(vector3);

        return vectors;
    }

    private static Vector<Vector<IntegerWrapper>> constructVectorWith2LenInside() {
        Vector<IntegerWrapper> vector1 = new Vector<>();
        vector1.addElement(new IntegerWrapper(1));
        vector1.addElement(new IntegerWrapper(2));

        Vector<IntegerWrapper> vector2 = new Vector<>();
        vector2.addElement(new IntegerWrapper(1));
        vector2.addElement(new IntegerWrapper(2));

        Vector<IntegerWrapper> vector3 = new Vector<>();
        vector3.addElement(new IntegerWrapper(1));
        vector3.addElement(new IntegerWrapper(2));

        var vectors = new Vector<Vector<IntegerWrapper>>();
        vectors.addElement(vector1);
        vectors.addElement(vector2);
        vectors.addElement(vector3);

        return vectors;
    }

    private static Vector<Vector<IntegerWrapper>> constructVectorWith2LenOutside() {
        Vector<IntegerWrapper> vector1 = new Vector<>();
        vector1.addElement(new IntegerWrapper(1));
        vector1.addElement(new IntegerWrapper(2));

        Vector<IntegerWrapper> vector2 = new Vector<>();
        vector2.addElement(new IntegerWrapper(1));
        vector2.addElement(new IntegerWrapper(2));

        var vectors = new Vector<Vector<IntegerWrapper>>();
        vectors.addElement(vector1);
        vectors.addElement(vector2);

        return vectors;
    }
}

package ooap2.twelve;

public class Any extends General {

    public static Integer tryAssign(Any target, Object source) {
        try {
            target = (Any) source;
            return 1; // Success
        } catch (Exception e) {
            return 0; // Fail
        }

    }
}

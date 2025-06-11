package second;

public class TwoWayList<T> extends ParentList<T> {

    private Status leftStatus = Status.NIL;

    public TwoWayList() {
        super();
    }

    public void left() {
        if (size() == 0 || cursor.getPrev() == null) {
            leftStatus = Status.ERR;
        } else {
            cursor = cursor.getPrev();
            leftStatus = Status.OK;
        }
    }

    public Status getLeftStatus() {
        return leftStatus;
    }
}

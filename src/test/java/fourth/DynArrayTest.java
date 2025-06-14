package fourth;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fourth.DynArray.Status;

public class DynArrayTest {

    DynArray<Integer> array;
    
    @Test
    public void addAndGetTest_emptyMassive() {
        array = new DynArray<>();

        assertEquals(0, array.size());

        array.add(0);

        assertEquals(1, array.size());
        assertEquals(Status.OK, array.getAddStatus());
        assertEquals((Integer) 0, array.get(0));
    }

    @Test
    public void addAndGetTest_notEmptyMassive() {
        array = new DynArray<>();

        // Assert initial state
        assertEquals(0, array.size());
        assertEquals(Status.NIL, array.getAddStatus());
        assertEquals(Status.NIL, array.getGetStatus());

        // Action
        array.add(1);
        array.add(1);
        array.add(1);

        // Assert current state
        assertEquals(3, array.size());
        assertEquals(Status.OK, array.getAddStatus());

        assertEquals((Integer) 1, array.get(0));
        assertEquals(DynArray.Status.OK, array.getGetStatus());

        assertEquals((Integer) 1, array.get(1));
        assertEquals(DynArray.Status.OK, array.getGetStatus());

        assertEquals((Integer) 1, array.get(2));
        assertEquals(DynArray.Status.OK, array.getGetStatus());
    }

    @Test
    public void addAndGetTest_addToFullMassive() {
        array = new DynArray<>();
        assertEquals(0, array.size());

        for (int i = 0; i < 16; i++) {
            array.add(i);
        }

        assertEquals(16, array.size());
        assertEquals(16, array.getCapacity());

        array.add(16);

        assertEquals(17, array.size());
        assertEquals(25, array.getCapacity());
    }

    @Test
    public void removeTest_removeFromEmpty_Error() {
        array = new DynArray<>();

        assertEquals(0, array.size());
        assertEquals(Status.NIL, array.getRemoveStatus());
        assertEquals(16, array.getCapacity());

        array.remove(0);
        assertEquals(0, array.size());
        assertEquals(Status.ERROR, array.getRemoveStatus());
        assertEquals(16, array.getCapacity());
    }

    @Test
    public void removeTest_addOneRemoveThis_OK() {
        array = new DynArray<>();
        array.add(1);

        assertEquals(1, array.size());
        assertEquals(Status.NIL, array.getRemoveStatus());
        assertEquals(16, array.getCapacity());

        array.remove(0);
        assertEquals(0, array.size());
        assertEquals(Status.OK, array.getRemoveStatus());
        assertEquals(16, array.getCapacity());
    }

    @Test
    public void removeTest_removeElement_OK() {
        array = new DynArray<>();
        array.add(1);
        array.add(2);
        array.add(3);

        assertEquals(3, array.size());
        assertEquals(Status.NIL, array.getRemoveStatus());
        assertEquals(16, array.getCapacity());

        array.remove(1);
        assertEquals(2, array.size());
        assertEquals(Status.OK, array.getRemoveStatus());
        assertEquals(16, array.getCapacity());
        assertEquals((Integer) 1, array.get(0));
        assertEquals((Integer) 3, array.get(1));
    }

    @Test
    public void removeTest_removeLastElement_OK() {
        array = new DynArray<>();
        array.add(1);
        array.add(2);
        array.add(3);

        assertEquals(3, array.size());
        assertEquals(Status.NIL, array.getRemoveStatus());
        assertEquals(16, array.getCapacity());

        array.remove(2);
        assertEquals(2, array.size());
        assertEquals(Status.OK, array.getRemoveStatus());
        assertEquals(16, array.getCapacity());
        assertEquals((Integer) 1, array.get(0));
        assertEquals((Integer) 2, array.get(1));
    }

    @Test
    public void removeTest_removeFromPreFull_OK() {
        array = new DynArray<>();
        for (int i = 0; i < 16; i++) {
            array.add(i);
        }

        assertEquals(16, array.size());
        assertEquals(Status.NIL, array.getRemoveStatus());
        assertEquals(16, array.getCapacity());

        array.remove(2);
        assertEquals(15, array.size());
        assertEquals(Status.OK, array.getRemoveStatus());
        assertEquals(16, array.getCapacity());
        assertEquals((Integer) 3, array.get(2));
    }

    @Test
    public void insertTest_insertIntoEmpty_OK() {
        array = new DynArray<>();
        assertEquals(0, array.size());
        assertEquals(Status.NIL, array.getInsertStatus());
        assertEquals(16, array.getCapacity());

        array.insert(0, 1);

        assertEquals(1, array.size());
        assertEquals(Status.OK, array.getInsertStatus());
        assertEquals(16, array.getCapacity());
    }

    @Test
    public void insertTest_insertIntoEmpty_Error() {
        array = new DynArray<>();
        assertEquals(0, array.size());
        assertEquals(Status.NIL, array.getInsertStatus());
        assertEquals(16, array.getCapacity());

        array.insert(1, 1);

        assertEquals(0, array.size());
        assertEquals(Status.ERROR, array.getInsertStatus());
        assertEquals(16, array.getCapacity());
    }
}

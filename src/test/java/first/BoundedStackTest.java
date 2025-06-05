package first;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundedStackTest {

    @Test
    void init_nilStatuses() {
        // given -- when
        var stack = new BoundedStack<Integer>();

        // then
        assertEquals(BoundedStack.Status.PUSH_NIL, stack.pushStatus());
        assertEquals(BoundedStack.Status.POP_NIL, stack.popStatus());
        assertEquals(BoundedStack.Status.PEEK_NIL, stack.peekStatus());
    }

    @Test
    void push__successPushToEmptyStack() {
        // given
        var stack = new BoundedStack<Integer>();

        // when
        stack.push(1);

        // then
        assertEquals(BoundedStack.Status.PUSH_OK, stack.pushStatus());
        assertEquals(1, stack.size());
    }

    @Test
    void push__successPushToStack() {
        // given
        var stack = new BoundedStack<Integer>();

        // when
        stack.push(1);
        stack.push(2);
        stack.push(1);

        // then
        assertEquals(BoundedStack.Status.PUSH_OK, stack.pushStatus());
        assertEquals(3, stack.size());
    }

    @Test
    void push__successPushToStackAfterPop() {
        // given
        var stack = new BoundedStack<Integer>();

        // when
        stack.push(1);
        stack.push(2);
        stack.push(1);

        stack.pop();
        stack.push(1);

        // then
        assertEquals(BoundedStack.Status.PUSH_OK, stack.pushStatus());
        assertEquals(BoundedStack.Status.POP_OK, stack.popStatus());
        assertEquals(3, stack.size());
    }

    @Test
    void push__errorPushToStack() {
        // given
        var stack = new BoundedStack<Integer>(1);

        // when
        stack.push(1);
        stack.push(2);

        // then
        assertEquals(BoundedStack.Status.PUSH_ERROR, stack.pushStatus());
        assertEquals(0, stack.size());
    }



    @Test
    void pop() {
        // given
        var stack = new BoundedStack<Integer>();

        // when
        stack.pop();

        // then
        assertEquals(BoundedStack.Status.POP_ERROR, stack.popStatus());
    }
}

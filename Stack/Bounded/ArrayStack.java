/**
 * Created by Davorin on 4/1/2017.
 */
public class ArrayStack implements BoundedStackInterface {
    protected final int defCap = 100; // default capacity
    protected Object[] stack;         // holds stack elements
    protected int topIndex = -1;      // index of top element in stack

    public ArrayStack() {
        stack = new Object[defCap];
    }

    public ArrayStack(int maxSize) {
        stack = new Object[maxSize];
    }

    // Returns true if this stack is empty, otherwise returns false.
    public boolean isEmpty() {
        if (topIndex == -1)
            return true;
        else
            return false;
    }

    // Returns true if this stack is full, otherwise returns false.
    public boolean isFull() {
        if (topIndex == (stack.length - 1))
            return true;
        else
            return false;
    }

    public void push(Object element) {
        if (!isFull()) {
            topIndex++;
            stack[topIndex] = element;
        }
        else
            throw new StackOverflowException("Push attempted on a full stack.");
    }

    public void pop() {
        if (!isEmpty()) {
            stack[topIndex] = null;
            topIndex--;
        }
        else
            throw new StackUnderflowException("Pop attempted on an empty stack.");
    }

    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element from this stack.
    public Object top() {
        Object topOfStack = null;
        if (!isEmpty())
            topOfStack = stack[topIndex];
        else
            throw new StackUnderflowException("Top attempted on an empty stack.");
        return topOfStack;
    }

}

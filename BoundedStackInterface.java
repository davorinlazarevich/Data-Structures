/**
 * Created by Davorin on 4/1/2017.
 */
public interface BoundedStackInterface  extends StackInterface {
    public void push(Object element) throws StackOverflowException;
    // Throws StackOverflowException if this stack is full,
    // otherwise places element at the top of this stack.

    public boolean isFull();
    // Returns true if this stack is full, otherwise returns false.
}

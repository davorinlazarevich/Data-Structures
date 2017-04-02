/**
 * Created by Davorin on 4/1/2017.
 */
public interface StackInterface {
    public void pop() throws StackUnderflowException;
    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.

    public Object top() throws StackUnderflowException;
    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element from this stack.

    public boolean isEmpty();
    // Returns true if this stack is empty, otherwise returns false.
}

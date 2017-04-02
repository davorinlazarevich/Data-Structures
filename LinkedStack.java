/**
 * Created by Davorin on 4/1/2017.
 */
public class LinkedStack implements UnboundedStackInterface {
    protected LLObjectNode top; // reference to the top of this stack

    public LinkedStack() {
        top = null;
    }

    // Places element at the top of this stack.
    public void push(Object element) {
        LLObjectNode newNode = new LLObjectNode(element);
        newNode.setLink(top);
        top = newNode;
    }

    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.
    public void pop() {
        if (!isEmpty()) {
            top = top.getLink();
        }
        else
            throw new StackUnderflowException("Pop attempted on an empty stack.");
    }

    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element from this stack.
    public Object top() {
        if (!isEmpty())
            return top.getInfo();
        else
            throw new StackUnderflowException("Top attempted on an empty stack.");
    }

    // Returns true if this stack is empty, otherwise returns false.
    public boolean isEmpty() {
        if (top == null)
            return true;
        else
            return false;
    }

}

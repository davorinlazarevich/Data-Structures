/**
 * Created by Davorin on 4/1/2017.
 */
public class LinkedUnboundedQueue implements UnboundedQueueInterface {
    protected LLObjectNode front;   // reference to the front of this queue
    protected LLObjectNode rear;    // reference to the rear of this queue

    public LinkedUnboundedQueue()
    {
        front = null;
        rear = null;
    }

    // Adds element to the rear of this queue.
    public void enqueue(Object element) {
        LLObjectNode newNode = new LLObjectNode(element);
        if (rear == null)
            front = newNode;
        else
            rear.setLink(newNode);
        rear = newNode;
    }

    // Throws QueueUnderflowException if this queue is empty,
    // otherwise removes front element from this queue and returns it.
    public Object dequeue() {
        if (isEmpty())
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        else {
            Object element;
            element = front.getInfo();
            front = front.getLink();
            if (front == null)
                rear = null;
            return element;
        }
    }

    // Returns true if this queue is empty, otherwise returns false
    public boolean isEmpty() {
        return (front == null);
    }

}

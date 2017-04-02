/**
 * Created by Davorin on 4/1/2017.
 */
public class ArrayBoundedQueue implements BoundedQueueInterface {
    protected final int defCap = 100; // default capacity
    protected Object[] queue;         // array that holds queue elements
    protected int numElements = 0;    // number of elements in the queue
    protected int front = 0;          // index of front of queue
    protected int rear;               // index of rear of queue

    public ArrayBoundedQueue() {
        queue = new Object[defCap];
        rear =  defCap - 1;
    }

    public ArrayBoundedQueue(int maxSize) {
        queue = new Object[maxSize];
        rear =  maxSize - 1;
    }

    // Throws QueueOverflowException if this queue is full,
    // otherwise adds element to the rear of this queue.
    public void enqueue(Object element) {
        if (isFull())
            throw new QueueOverflowException("Enqueue attempted on a full queue.");
        else {
            rear = (rear + 1) % queue.length;
            queue[rear] = element;
            numElements = numElements + 1;
        }
    }

    // Throws QueueUnderflowException if this queue is empty,
    // otherwise removes front element from this queue and returns it.
    public Object dequeue() {
        if (isEmpty())
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        else {
            Object toReturn = queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;
            numElements = numElements - 1;
            return toReturn;
        }
    }

    // Returns true if this queue is empty, otherwise returns false
    public boolean isEmpty() {
        return (numElements == 0);
    }

    // Returns true if this queue is full, otherwise returns false.
    public boolean isFull() {
        return (numElements == queue.length);
    }
}

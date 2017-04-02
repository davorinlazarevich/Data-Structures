/**
 * Created by Davorin on 4/1/2017.
 */
public class ArrayUnboundedQueue implements UnboundedQueueInterface {
    protected final int defCap = 100; // default capacity
    protected Object[] queue;         // array that holds queue elements
    protected int origCap;            // original capacity
    protected int numElements = 0;    // number of elements n the queue
    protected int front = 0;          // index of front of queue
    protected int rear = -1;          // index of rear of queue

    public ArrayUnboundedQueue() {
        queue = new Object[defCap];
        rear =  defCap - 1;
        origCap = defCap;
    }

    public ArrayUnboundedQueue(int origCap) {
        queue = new Object[origCap];
        rear = origCap - 1;
        this.origCap = origCap;
    }

    // Increments the capacity of the queue by an amount
    // equal to the original capacity.
    private void enlarge() {
        // create the larger array
        Object[] larger = new Object[queue.length + origCap];

        // copy the contents from the smaller array into the larger array
        int currSmaller = front;
        for (int currLarger = 0; currLarger < numElements; currLarger++) {
            larger[currLarger] = queue[currSmaller];
            currSmaller = (currSmaller + 1) % queue.length;
        }

        // update instance variables
        queue = larger;
        front = 0;
        rear = numElements - 1;
    }

    // Adds element to the rear of this queue.
    public void enqueue(Object element) {
        if (numElements == queue.length)
            enlarge();
        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        numElements = numElements + 1;
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

}

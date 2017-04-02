/**
 * Created by Davorin on 4/1/2017.
 */
public interface BoundedQueueInterface {
    // Throws QueueOverflowException if this queue is full,
    // otherwise adds element to the rear of this queue.
    public void enqueue(Object element) throws QueueOverflowException;

    // Returns true if this queue is full, otherwise returns false.
    public boolean isFull();
}

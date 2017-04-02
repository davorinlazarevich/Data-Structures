/**
 * Created by Davorin on 4/1/2017.
 */
public interface QueueInterface {
    // Throws QueueUnderflowException if this queue is empty,
    // otherwise removes front element from this queue and returns it.
    public Object dequeue() throws QueueUnderflowException;

    // Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty();
}

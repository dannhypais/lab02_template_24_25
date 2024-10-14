import org.junit.Before;
import org.junit.Test;
import pt.pa.adts.queue.Queue;
import pt.pa.adts.queue.QueueEmptyException;
import pt.pa.adts.queue.QueueFullException;
import pt.pa.adts.queue.QueueLinkedList;

import java.util.Optional;

import static org.junit.Assert.*;

public class QueueLinkedListTest {
    protected QueueLinkedList<Integer> queue;

    @Before
    public void setUp() {
        queue = new QueueLinkedList<>();
        queue.enqueue(1);
    }

    @Test
    public void testEnqueue() throws QueueFullException, NullPointerException {
        queue.enqueue(2);
        assertEquals(2, queue.size());
    }

    @Test
    public void testDequeue() throws QueueEmptyException {
        int num = queue.dequeue();
        assertEquals(1, num);
        assertEquals(0, queue.size());
    }

    @Test
    public void testFront(){
        int num = queue.front();
        assertEquals(1, num);
    }

    @Test
    public void testDequeueEmpty() throws QueueEmptyException{
        queue.dequeue();
        assertThrows(QueueEmptyException.class, () -> queue.dequeue());
    }

    @Test
    public void testFrontEmpty() throws QueueEmptyException{
        queue.dequeue();
        assertThrows(QueueEmptyException.class, () -> queue.front());
    }

    @Test
    public void testSize(){
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.enqueue(3);
        assertEquals(3, queue.size());
        queue.dequeue();
        assertEquals(2, queue.size());
    }

    @Test
    public void testIsEmpty(){
         assertFalse(queue.isEmpty());
         queue.dequeue();
         assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmptyWithClear(){
        assertFalse(queue.isEmpty());
        queue.clear();
        assertTrue(queue.isEmpty());
    }
}



























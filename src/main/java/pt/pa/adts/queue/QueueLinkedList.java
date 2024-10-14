package pt.pa.adts.queue;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T>  {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        header = new ListNode(null, null, null);
        trailer = new ListNode(null, header, null);
        header.next = trailer;
        size = 0;
    }

    public void enqueue(T elem) throws QueueFullException, NullPointerException{
        if (size == Integer.MAX_VALUE) throw new QueueFullException("Queue is full");

        if (elem == null) throw new NullPointerException("Element cannot be null");

        ListNode newNode = new ListNode(elem, trailer.prev, trailer);
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        size++;
    }

    public T dequeue() throws QueueEmptyException{
        if(size == 0) throw new QueueEmptyException("Queue is empty");

        T elem = header.next.element;

        if(header.next.next != null) header.next.next.prev = header;

        header.next = header.next.next;
        size--;

        return elem;
    }

    public T front() throws QueueEmptyException{
        if(size == 0) throw new QueueEmptyException("Queue is empty");

        return header.next.element;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

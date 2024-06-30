import java.util.*;
import java.io.*;

public class Queue extends DSAQueue implements Iterable, Serializable
{
    private static final long serialVersionUID = 1L;

    public Iterator iterator()
    {
        return queueList.iterator();
    }
    public Queue()
    {
        super();
    }

    public void enQueue(Object value)
    {
        queueList.insertLast(value);
    }

    public Object deQueue()
    {
        Object value;
        if(isEmpty())
        {
            throw new IllegalStateException("Exception: Queue is empty.");
        }
        else
        {
            value = queueList.removeFirst();
        }
        return value;
    }

    public Object peek()
    {
        Object top;
        if(isEmpty())
        {
            throw new IllegalStateException("The Queue is Empty");
        }
        else
        {
            top = queueList.peekFirst();
        }
        return top;
    }
}
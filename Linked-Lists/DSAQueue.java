import java.util.*;
import java.io.*;

public abstract class DSAQueue implements Iterable, Serializable
{
    protected DSALinkedList queueList;

    public DSAQueue()
    {
        queueList = new DSALinkedList();
    }

    public boolean isEmpty()
    {
        return (queueList.isEmpty());
    }

    public abstract void enQueue(Object obj);

    public abstract Object deQueue();

    public abstract Object peek();


    public void saveQueue(String file)
    {
        queueList.save(queueList, file);
    }

    public void loadQueue(String file)
    {
        queueList = queueList.load(file);
    }
}
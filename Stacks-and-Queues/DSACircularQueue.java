import java.util.*;

public class DSACircularQueue extends DSAQueue
{
    public int front;
    public int rear;

    public DSACircularQueue()
    {
        super();
        front = -1;
        rear = -1;
    }
    public DSACircularQueue(int maxCapacity)
    {
        super(maxCapacity);
    }

    //Accessor
    public int getCount()
    {
        return count;
    }

    public void enQueue(Object obj)
    {
        if(isFull())
        {
            throw new IndexOutOfBoundsException("Exception: Queue is full.");
        }
        else
        {
            rear = (rear + 1)% queue.length; //move position of rear until no index remain.
            queue[rear] = obj;
            count++;
            if(front == -1)
            {
                front = rear; //Set front to rear equal same index if only 1 value in circular queue.
            }
        }
    }
    public Object deQueue()
    {
        Object obj;
        if(isEmpty())
        {
            throw new IllegalStateException("Exception: Queue is empty.");
        }
        else
        {
            obj = queue[front];
            front = (front+1) % queue.length;
            count--;
        }
        return obj;
    }

    public void testString()
    {
        for(int i=0; i<count; i++)
        {
            System.out.println(queue[i]);
        }
    }

    @Override
    public Object peek()
    {
        Object obj;
        if(isEmpty())
        {
            throw new IllegalStateException("Stack is Empty");
        }
        else
        {
            obj = queue[front];
        }
        return obj;
    } 
    
}
public class DSAShufflingQueue extends DSAQueue
{
    public DSAShufflingQueue()
    {
        super();
    }
    public DSAShufflingQueue(int maxCapacity)
    {
        super(maxCapacity);
    }

    public void enQueue(Object obj)
    {
        if(isFull())
        {
            throw new IndexOutOfBoundsException("Exception: Queue is full");
        }
        else
        {
            queue[count] = obj;
            count++;
        }
    }
    
    public Object deQueue()
    {
        Object obj = queue[0];
        if(isEmpty())
        {
            throw new IllegalStateException("Exception: Queue is empty");
        }
        else
        {
            for(int i=0; i<queue.length-1; i++)
            {   
            queue[i] = queue[i+1];
            }
            count--;
        }
        return obj;
    }
    
    

    
}
public abstract class DSAQueue
{
    public final int DEFAULT_CAPACITY = 100;
    protected Object queue[];
    protected int count;

    public DSAQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
        count = 0;
    }
    public DSAQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
        count = 0;
    }

    //Accessor
    public int getCount()
    {
        return count;
    }
    public boolean isEmpty()
    {
        return (count == 0);
    }
    public boolean isFull()
    {
        return (count == queue.length);
    }

    public abstract void enQueue(Object obj);

    public abstract Object deQueue();

    public Object peek()
    {
        Object value;
        if(isEmpty())
        {
            throw new IllegalStateException("Stack is Empty");
        }
        else
        {
            value = queue[0]; //Checks for first index.
        }
        return value;
    } 

    public void testString()
    {
        for(int i=0; i<count; i++)
        {
            System.out.println(queue[i]);
        }
    }
}
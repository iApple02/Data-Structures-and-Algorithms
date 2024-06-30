import java.util.*;
import java.io.*;


public abstract class DSAStack implements Iterable, Serializable
{
    private static final long serialVersionUID = 1L;
    protected DSALinkedList stackList;

    public Iterator iterator()
    {
        return stackList.iterator();
    }
 
    //Default Constructor
    public DSAStack()
    {
        stackList = new DSALinkedList();
    }

    public boolean isEmpty()
    {
        return stackList.isEmpty();
    }

    public abstract void push(Object value);
    public abstract Object pop();
    public abstract Object peek();

/* ================================================= */
    
    public void saveStack(String file)
    {
        stackList.save(stackList,file);
    }

    public void loadStack(String file)
    {
        stackList = stackList.load(file);
    }
}
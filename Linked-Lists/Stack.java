import java.util.*;
import java.io.*;

public class Stack extends DSAStack implements Iterable, Serializable
{
    private static final long serialVersionUID = 1L; //Serializable version needed.

    public Iterator iterator()
    {
        return stackList.iterator();
    }

    public Stack()
    {
        super();
    }

    public void push(Object value)
    {
        stackList.insertLast(value);
    }
    
    public Object pop()                                                         
    {
        Object top = null;
        if(isEmpty())
        {
            throw new IllegalStateException("The stack is empty.");
        }
        else
        {
            top = stackList.removeLast();
        }
        return top;
    }

    public Object peek()                                                        
    {
        Object top = null;
        if(isEmpty())
        {
            throw new IllegalStateException("The stack is empty.");
        }
        else
        {
            top = stackList.peekLast();
        }
        return top;
    }
}
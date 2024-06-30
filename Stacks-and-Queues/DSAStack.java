import java.util.*;

public class DSAStack
{
    public final int DEFAULT_CAPACITY = 100;
    private Object stack[];
    private int top;
 
    //Default Constructor
    public DSAStack()
    {
        stack = new Object[DEFAULT_CAPACITY];
        top = 0;
    }

    //Alternate Constructor
    public DSAStack(int maxCapacity)
    {
        stack = new Object[maxCapacity];
        top = 0;
    }

    //Accessor
    public int getCount()
    {
        return top;
    }
    public boolean isEmpty()
    {
        return (top == 0);
    }
    public boolean isFull()
    {
        return (top == stack.length);
    }

    //Mutator
    public Object push(Object value)
    {
        if(isFull())
        {
            throw new IndexOutOfBoundsException("Stack is full.");
        }
        else
        {
            stack[top] = value;
            top = top + 1;
        }
        return top;
    }
    public Object pop()
    {
        Object topVal;
        topVal = peek();
        top = top - 1;
        return topVal;
    }

    public Object peek()
    {
        Object topVal;
        if(isEmpty())
        {
            throw new IllegalStateException("Stack is Empty");
        }
        else
        {
            topVal = stack[top -1];
        }
        return topVal;
    }

    public void printStack()
    {
        for(int i=0; i<top; i++)
        {
            System.out.println(stack[i]);
        }
    }
}
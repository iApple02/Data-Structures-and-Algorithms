import java.io.*;
import java.util.*;

public class DSALinkedList implements Iterable, Serializable
{
/* ================================================================================= */
    private static final long serialVersionUID = 1L;

    public Iterator iterator()
    {
        return new DSALinkedListIterator(this);
    }

/* ================================================================================= */

    private class DSALinkedListIterator implements Iterator
    {
        private DSAListNode iterNext;
        public DSALinkedListIterator(DSALinkedList theList) //Able to access private field from DSALinkedList
        {
            iterNext = theList.head;
        }
        
        public boolean hasNext()
        {
            return (iterNext != null);
        }

        public Object next()
        {
            Object value = null;
            if(iterNext == null)
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }

        public void remove()
        {
            throw new UnsupportedOperationException("Not Supported");
        }
    }

/* ================================================================================= */
    
    private class DSAListNode implements Serializable
    {
        private Object value;
        private DSAListNode next;
        private DSAListNode prev;

        public DSAListNode(Object inValue)
        {
            value = inValue;
            next = null;
            prev = null;
        }
        
        public Object getValue()
        {
            return value;
        }
        
        public void setValue(Object inValue)
        {
            value = inValue;
        }

        public DSAListNode getNext()
        {
            return next;
        }

        public DSAListNode getPrev()
        {
            return prev;
        }

        public void setNext(DSAListNode newNext)
        {
            next = newNext;
        }

        public void setPrev(DSAListNode newPrev)
        {
            prev = newPrev;
        }
    }

    /* ================================================================================= */

    //Class fields
    DSAListNode head = null;
    DSAListNode tail = null;
    
    //Default Constructor
    public DSALinkedList()
    {
        head = null;
        tail = null;
    }
    
    public void insertFirst(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);
        if(isEmpty())
        {
            head = newNd;
            tail = head; //Tail becomes first node
        }
        else
        {
            head.setPrev(newNd); //Set previous to head
            newNd.setNext(head);
            head = newNd;
        }
    }

    public void insertLast(Object newValue)
    {
        DSAListNode newNd; //currNd not needed
        newNd = new DSAListNode(newValue); 
        if(isEmpty())
        {
            head = newNd;
            tail = newNd;
        }
        else if(head.getNext() == null)
        {
            tail = newNd;
            tail.setPrev(head);
            head.setNext(tail);
        }
        else
        {
            /*currNd = head;
            while(currNd.getNext() != null)
            {
                currNd = currNd.getNext();
            }
            currNd.setNext(newNd);*/
            tail.setNext(newNd); //assign tail to new node
            newNd.setPrev(tail); 
            tail = newNd; //point node to tail
        }
    }

    public boolean isEmpty()
    {
        boolean empty = false;
        if(head == null)
        {
            empty = true;
        }
        return empty;
    }

    public Object peekFirst()
    {
        Object nodeValue;
        if(isEmpty())
        {
            throw new IllegalStateException("Exception: No value on node.");
        }
        else
        {
            nodeValue = head.getValue();
        }
        return nodeValue;
    }

    public Object peekLast()
    {
        Object nodeValue;
        //DSAListNode currNd;
        if(isEmpty())
        {
            throw new IllegalStateException("Exception: No value on node.");
        }
        else
        {
            /*currNd = head;
            while(currNd.getNext() != null)
            {
                currNd = currNd.getNext();
            }
            nodeValue = currNd.getValue();*/
            nodeValue = tail.getValue();
        }
        return nodeValue;
    }

    public Object removeFirst()
    {
        Object nodeValue;
        if(isEmpty())
        {
            throw new IllegalStateException("Exception: Node is empty");
        }
        else if(head == tail)
        {
            nodeValue = head.getValue();
            head = null;
        }
        else
        {
            nodeValue = head.getValue();
            head = head.getNext();
            head.setPrev(null);
        }
        return nodeValue;
    }

    public Object removeLast()
    {
        Object nodeValue; 
        //DSAListNode prevNd, currNd;
        if(isEmpty())
        {
            throw new IllegalStateException("Exception: The List is empty");
        }
        else if(head == tail)
        {
            nodeValue = tail.getValue();
            tail = null;
        }
        else
        {
            /*prevNd = null;
            currNd = head;
            while(currNd.getNext() != null)
            {
                prevNd = currNd;
                currNd = currNd.getNext();
            }
            prevNd.setNext(null);
            nodeValue = currNd.getValue();*/
            nodeValue = tail.getValue();
            tail = tail.getPrev();
            tail.setNext(null);
        }
        return nodeValue;
    }

    public void save(DSALinkedList saveObj, String filename)
    {
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;

        try
        {
            fileStrm = new FileOutputStream(filename);
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(saveObj);
            objStrm.close();
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("Unable to save object to file");
        }
    }

    public DSALinkedList load(String filename) throws IllegalArgumentException
    {
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        DSALinkedList inObj = null;

        try
        {
            fileStrm = new FileInputStream(filename);
            objStrm = new ObjectInputStream(fileStrm);
            inObj = (DSALinkedList)objStrm.readObject();
            objStrm.close();
            
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Class DSALinkedList not found" + e.getMessage());
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("Unable to load object from file");
        }
        return inObj;
    }
}


        
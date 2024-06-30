import java.util.*;
import java.io.*;

public class IteratorTestHarness
{
    public static void main(String[] args)
    {
        System.out.println("==========================================================");

        DSALinkedList list = new DSALinkedList();
        DSALinkedList newList = null;
        try
        {   
            System.out.println("Adding elements to Linked List");
            list.insertLast("insert 1");
            list.insertLast("test");
            list.insertLast("abc");
            list.insertFirst("Insert to First");
            System.out.println("Successfully added element to Linked List");
            iterateOverList(list);
            System.out.println("First element in list is: " + list.peekFirst());
            System.out.println("Last element in list is: " + list.peekLast());
            System.out.println("Removing First Element: " + list.removeFirst());
            System.out.println("Removing last Element: " + list.removeLast());
            System.out.println("Peeking first Element: " + list.peekFirst());
            System.out.println("Peeking last Element: " + list.peekLast());
            
            try
            {
                list.save(list, "LinkedList.txt");
                System.out.println("File successfully saved");
            }
            catch(Exception e)
            {
                System.out.println("List failed to save");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed to add element to Linked List");
        }
    
        System.out.println("==========================================================");

        try
        {
            System.out.println("Testing load");
            
            try
            {
                newList = list.load("LinkedList.txt");
            }
            catch(Exception e)
            {
                System.out.println("Failed to load.");
            }
            
            System.out.println("Is empty: " + newList.isEmpty());
            System.out.println("Successfully loaded Linked List");
            Iterator iter = newList.iterator();
            System.out.println("Testing Iterator for LinkedList");
            System.out.println("Iterator detecting next item: " + iter.hasNext());
            try
            {
                while(iter.hasNext())
                {
                    System.out.println(iter.next());
                }
            }
            catch(Exception e)
            {
                System.out.println("No objects in Linked List.");
            }
        }
        catch(Exception e)
        {
            System.out.println("LinkedList failed to load.");
        }

        System.out.println("==========================================================");

        DSAStack stackList = new Stack(); //Uses Inheritance
        try
        {     
            Iterator iter = stackList.iterator();
            System.out.println("Adding elements to stack.");
            stackList.push("Push");
            stackList.push(483);
            stackList.push("Hello");
            stackList.push(32);
            stackList.push("Working");
            System.out.println("Successfully added Elements to Stack");
            try
            {
                stackList.saveStack("StackFile.ser");
                System.out.println("File successfully saved");
            }
            catch(Exception e)
            {
                System.out.println("Stack failed to save");
            }
        }
        catch(Exception e)
        {
            System.out.println("Stack push failed.");
        }

        System.out.println("==========================================================");

        DSAQueue queueList = new Queue(); //Uses Inheritance
        try
        {
            System.out.println("Adding elements to queue.");
            queueList.enQueue("First");
            queueList.enQueue("Second");
            queueList.enQueue("Third");
            queueList.enQueue("Fourth");
            queueList.enQueue("Fifth");
            queueList.enQueue("Sixth");
            System.out.println("Successfully added Elements to Queue");
            try
            {
                queueList.saveQueue("QueueFile.ser");
                System.out.println("File successfully saved");
            }
            catch(Exception e)
            {
                System.out.println("QueueFile failed to save");
            }
        }
        catch(Exception e)
        {
            System.out.println("Queue push failed.");
        }
    }

    public static void iterateOverList(DSALinkedList list) 
    {
        Object c;
        for (Object o : list) 
        {
            c = (Object)o; //Cast to Object
            System.out.println(c);
        }
    }
}
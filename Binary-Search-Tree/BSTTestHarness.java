import java.util.*;
import java.io.*;

public class BSTTestHarness
{
    public static void main(String[] args)
    {
        System.out.println("==========================================================");
        BinarySearchTree BST = new BinarySearchTree();
        BinarySearchTree newInOrder = new BinarySearchTree();
        DSAQueue inOrderQueue = new Queue();
        DSAQueue preOrderQueue = new Queue();
        DSAQueue postOrderQueue = new Queue();
        DSAQueue iterateInOrder = new Queue();

        
        System.out.println("Testing Insert function of BST");

        try
        {
            System.out.println("Inserting ABCDEFG");
            BST.insert("E", "5");
            BST.insert("B", "2");
            BST.insert("F", "6");
            BST.insert("D", "4");
            BST.insert("C", "3");
            BST.insert("A", "1");
            BST.insert("G", "7");
            
            System.out.println("Elements successfully added");
        }
        catch(Exception e)
        {
            System.out.println("BST failed to insert");
        }
        
        System.out.println("==========================================================");
        
        System.out.println("Testing Height function of BST");
        
        try
        {
            if(BST.height() == 3)
            {
                System.out.println("Height of Tree is 3");
                System.out.println("Height function test passed");
            }
            else
            {
                throw new IllegalArgumentException("Failed height function of tree");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed to test Height function");
        }

        System.out.println("==========================================================");

        System.out.println("Testing Delete function of BST");

        try
        {
            System.out.println("Deleting E node");
            BST.delete("E");
            System.out.println("Successfully deleted E node");
        }
        catch(Exception e)
        {
            System.out.println("Failed to delete node");
        }

        System.out.println("==========================================================");

        System.out.println("Testing find deleted node");
        
        try
        {
            System.out.println("Finding deleted E node");
            BST.find("E");
            System.out.println("Deleted E node was found");
            System.out.println("Test failed");
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Deleted node " + "E" + " was not found");
            System.out.println("Test passed for deleted node");
        }

        System.out.println("==========================================================");

        System.out.println("Testing find node");

        try
        {
            System.out.println("Finding B node");
            BST.find("B");
            System.out.println("Successfully found B node");
        }
        catch(Exception e)
        {
            System.out.println("Failed to find node");
        }
        
        System.out.println("==========================================================");

        inOrderQueue = BST.inOrder();
        Iterator iter = inOrderQueue.iterator();
        //Print data stored in BST and sort using inOrder transversal.
        System.out.println("Testing inOrder Travsversal");
        for(Object o : inOrderQueue)
        {
            System.out.println(iter.next());
        }
        System.out.println("Min key is: " + BST.min());
        System.out.println("Max key is: " + BST.max());
        System.out.println("Height of tree is " + BST.height());

        //Saving Serialized file.
        try
        {
            System.out.println("Saving inOrder Transversal");
            BST.save("inOrder.txt");
            System.out.println("Successfully saved inOrder.txt");
        }
        catch(Exception e)
        {
            System.out.println("Failed to save inOrder.txt");
        }

        System.out.println("==========================================================");

        preOrderQueue = BST.preOrder();
        Iterator iterPre = preOrderQueue.iterator();
        //Print data stored in BST and sort using preOrder transversal.
        System.out.println("Testing preOrder Travsversal");
        for(Object o : preOrderQueue)
        {
            System.out.println(iterPre.next());
        }

        System.out.println("==========================================================");
        
        postOrderQueue = BST.postOrder();
        Iterator iterPost = postOrderQueue.iterator();
        //Print data stored in BST and sort using preOrder transversal.
        System.out.println("Testing postOrder Travsversal");
        for(Object o : postOrderQueue)
        {
            System.out.println(iterPost.next());
        }

        System.out.println("==========================================================");
    }
}
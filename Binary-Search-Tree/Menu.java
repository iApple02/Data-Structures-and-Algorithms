import java.io.*;
import java.util.*;

public class Menu
{
    static BinarySearchTree BST = new BinarySearchTree();
    public static void main(String[] args)
    {
        
        int choice;
        do
        {   
            printOptions();
            choice = input();
            Options(choice);
        }
        while(choice != 0);
        
    }

    public static int input()
    {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        try
        {
            input = sc.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Invalid selection");
        }
        return input;
    }

    public static void printOptions()
    {
        System.out.println("1) read CSV file");
        System.out.println("2) read a serialized file");
        System.out.println("3) display the tree");
        System.out.println("4) write a CSV file");
        System.out.println("5) write a serialized file");
        System.out.println("0) Exit");
    }

    public static void Options(int opt)
    {
        switch(opt)
        {
            case 1:
                readCSV(inputFile());
                break;
            case 2:
                BST = BST.load(inputFile());
                break;
            case 3:
                display();
                break;
            case 4:
                writeToCsv();
                break;
            case 5:
                BST.save(inputFile());
                break;
            case 0:
                System.out.println("Exiting");
                break;
            default:
                System.out.println("Invalid option chosen");
        }
    }

    public static void readCSV(String file)
    {
        try
        {
            BST.readFile(file, BST);
            System.out.println("Successfully loaded CSV");
        }
        catch(Exception e)
        {
            System.out.println("Failed to load CSV file");
        }
    }

    public static void display()
    {
        DSAQueue dispOrder = new Queue();
        dispOrder = transverses();
        Iterator iter = dispOrder.iterator();
        for(Object x:dispOrder)
        {
            System.out.println(iter.next());
        }
    }

    public static void writeToCsv()
    {
        DSAQueue order = new Queue();
        String file = inputFile();
        order = transverses();
        BST.toCSV(file, order);
        
    }

    public static String inputFile()
    {
        System.out.println("Enter file name: ");
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();
        return file;
    }

    public static DSAQueue transverses()
    {
        System.out.println("1) In-order traversal");
        System.out.println("2) Pre-order traversal");
        System.out.println("3) Post-order traversal");
        DSAQueue trans = new Queue();
        int opts = input();
        switch(opts)
        {
            case 1: 
                trans = BST.inOrder();
                break;
            case 2:
                trans = BST.preOrder();
                break;
            case 3:
                trans = BST.postOrder();
                break;
            default:
                System.out.println("Invalid order");
        }
        return trans;
    }

    
}
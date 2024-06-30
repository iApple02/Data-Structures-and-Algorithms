import java.util.*;

public class StackTestHarness 
{
    public static void main(String[] args)
    {
        boolean exit = false;
        boolean empty, full;
        int choice, size;
        
        DSAStack stack = new DSAStack(5);

        System.out.println("Adding elements to stack:");
        stack.push(8);
        stack.push(23);
        stack.push(4);
        stack.push(37);
        stack.push(63);

        System.out.println("Elements currently in stack is:");
        stack.printStack();

        System.out.println("Is stack full?");
        full = stack.isFull();
        System.out.println(full);

        System.out.println("Now removing element from stack");
        System.out.println("Removing: " + stack.pop() + " from the stack");

        System.out.println("Elements currently in stack is:");
        stack.printStack();

        System.out.println("Is stack empty?");
        empty = stack.isEmpty();
        System.out.println(empty);

    }
}

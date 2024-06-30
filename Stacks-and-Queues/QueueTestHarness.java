import java.util.*;

public class QueueTestHarness
{
    public static void main(String[] args)
    {
        boolean empty, full;
        int choice;

        Scanner sc = new Scanner(System.in);
        DSAShufflingQueue shufflingQueue = new DSAShufflingQueue(5);
        DSACircularQueue circularQueue = new DSACircularQueue(5);

        System.out.println("1: Shuffling Queue, 2: Circular Queue");
        choice = sc.nextInt();
        switch (choice)
        {
            case 1:
                shufflingQueue.enQueue(25);
                shufflingQueue.enQueue(8);
                shufflingQueue.enQueue(6);
                shufflingQueue.enQueue(12);
                shufflingQueue.enQueue(35);

                System.out.println("Elements in queue: ");
                shufflingQueue.testString(); //prints element currently on queue.

                System.out.println("Queue is full?");
                full = shufflingQueue.isFull();
                System.out.println(full);

                shufflingQueue.deQueue();
                System.out.println("Top element has been removed: " + shufflingQueue.peek());

                System.out.println("Is Queue full?");
                full = shufflingQueue.isFull();
                System.out.println(full);

                shufflingQueue.deQueue();
                System.out.println("Top element has been removed: " + shufflingQueue.peek());
                shufflingQueue.deQueue();
                System.out.println("Top element has been removed: " + shufflingQueue.peek());
                shufflingQueue.deQueue();
                System.out.println("Top element has been removed: " + shufflingQueue.peek());


                System.out.println("Queue is Empty?");
                empty = shufflingQueue.isEmpty();
                System.out.println(empty);
                
                System.out.println("There are currently " + shufflingQueue.getCount() + " elements on the queue");

                shufflingQueue.deQueue();
                System.out.println(shufflingQueue.peek()); //If peeking at last element does not exist, exception will be thrown.
                System.out.println("Removing last element: ");
                
                break;
            
            case 2:
                circularQueue.enQueue(6);
                circularQueue.enQueue(12);
                circularQueue.enQueue(68);
                circularQueue.enQueue(23);
                circularQueue.enQueue(1);

                System.out.println("Elements in queue: ");
                circularQueue.testString(); //prints element currently on queue.
     
                System.out.println("Is Queue full?");
                full = circularQueue.isFull();
                System.out.println(full);

                circularQueue.deQueue();
                System.out.println("Element has been removed: " + circularQueue.peek());
                circularQueue.deQueue();
                System.out.println("Element has been removed: " + circularQueue.peek());
                circularQueue.deQueue();
                System.out.println("Element has been removed: " + circularQueue.peek());

                System.out.println("Queue is Empty?");
                empty = circularQueue.isEmpty();
                System.out.println(empty);
                
                System.out.println("There are currently " + circularQueue.getCount() + " elements on the queue");

                circularQueue.deQueue();
                System.out.println("Removing another element: ");
                System.out.println("Element has been removed: " + circularQueue.peek()); //If peeking at last element does not exist, exception will be thrown.
                break;
        }
    }
}
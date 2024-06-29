import java.util.*;

public class Menu
{
    public static void main(String[] args)
    {
        //Create arrays to read and write from csv file.
        Student[] A; //Used to temporarily store the read array from FileIO class.
        Student[] bubbleSort; //Store sorted array with data from "A" array
        Student[] selectionSort; //Store sorted array with data from "A" array
        Student[] insertionSort; //Store sorted array with data from "A" array

        
        A = FileHandler.readFile("RandomNames7000.csv", 7000); //Set csv file name and set size of array to 7000
        
        char choice;
        
        do
        {
            System.out.println("Choose Options: B = Bubble Sort, S = Selection Sort, I = Insertion Sort and A to exit.");
            Scanner sc = new Scanner(System.in);
            choice = sc.next().charAt(0);
   
            switch(choice)
            {
                case 'b': case 'B': //Allows uppercase or lowercase to be accepted
                    bubbleSort = Sorting.bubbleSort(A);
                    FileHandler.writeToFile("BubbleSorted.csv", bubbleSort); //Creates new csv file and write sorted data from bubbleSort array
                    break;
                case 's': case 'S': //Allows uppercase or lowercase to be accepted
                    selectionSort = Sorting.selectionSort(A);
                    FileHandler.writeToFile("SelectionSorted.csv", selectionSort); //Creates new csv file and write sorted data from selection array
                    break;
                case 'i': case 'I': //Allows uppercase or lowercase to be accepted
                    insertionSort = Sorting.insertionSort(A);
                    FileHandler.writeToFile("InsertionSorted.csv", insertionSort); //Creates new csv file and write sorted data from insertion array
                    break;
            }
        }
        while(choice != 'A');
    }
}
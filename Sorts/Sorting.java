//Lecture 1

/** 
** Software Technology 152
** Class to hold various static sort methods.
*/

class Sorting
{
    // bubble sort
    public static Student[] bubbleSort(Student[] A)
    {
      Student temp;
      int pass;
      boolean sorted;
      pass = 0;
      do
      {
        sorted = true; //Assume that array is sorted
        for (int ii = 0; ii <= (A.length-1- pass)-1;ii++) //0-based array indexing
        {
          if(A[ii].getStudentID() > A[ii+1].getStudentID()) //ii and ii+1 swap elements that are out of order
          {
            temp = A[ii];
            A[ii] = A[ii+1];
            A[ii+1] = temp;
            sorted = false;	//If false, continue sorting        
          }
        }
        pass = pass + 1; //Next pass through the elements
      }while(!sorted); //Stops sorting passes when array is sorted
      return A;
    }//bubbleSort()

    // selection sort
    public static Student[] selectionSort(Student[] A)
    {
      Student temp;
      int minIndex;
	    for(int nn = 0; nn <= (A.length-1); nn++) //0-based indexing
      {
		    minIndex = nn;
			  for(int jj=nn+1; jj <= (A.length-1);jj++) //ignore current minimum index(nn)
			  {
				  if(A[jj].getStudentID() < A[minIndex].getStudentID())
				  {
					  minIndex = jj; //Update new position of minimum value
				  }
		  	}
	      temp = A[minIndex]; //Do swap here
		    A[minIndex] = A[nn];
		    A[nn] = temp;
	    }
      return A;
    }// selectionSort()

    // insertion sort
    public static Student[] insertionSort(Student[] A)
    {
      for(int nn = 1; nn <= (A.length-1);nn++) //start inserting at element 1
	    {
        Student temp;
		    int ii; 
		    ii = nn; //Start from the end and go backwards to the front
		    while( (ii > 0) && (A[ii-1].getStudentID() > A[ii].getStudentID())) //Insert into a sub-array of nn, uses > to keep the sort stable
	      {
			    temp = A[ii];
			    A[ii] = A[ii-1]; //Move inserted value (at ii) up by one via swapping [ii-1] with [ii]
			    A[ii-1] = temp;

			    ii = ii-1;
		    }
	    }
      return A;
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss

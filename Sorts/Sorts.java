//Lecture 1

/** 
** Software Technology 152
** Class to hold various static sort methods.
*/

import java.util.*;

//Changed void to int, as return value is needed.
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
      int temp,pass;
      boolean sorted;
      pass = 0;
      do
      {
        sorted = true; //Assume that array is sorted
        for (int ii = 0; ii <= (A.length-1- pass)-1;ii++) //0-based array indexing
        {
          if(A[ii] > A[ii+1]) //ii and ii+1 swap elements that are out of order
          {
            temp = A[ii];
            A[ii] = A[ii+1];
            A[ii+1] = temp;
            sorted = false;	//If false, continue sorting        
          }
        }
        pass = pass + 1; //Next pass through the elements
      }while(!sorted); //Stops sorting passes when array is sorted
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
      int temp, minIndex;
	    for(int nn = 0; nn <= (A.length-1); nn++) //0-based indexing
      {
		    minIndex = nn;
			  for(int jj=nn+1; jj <= (A.length-1);jj++) //ignore current minimum index(nn)
			  {
				  if(A[jj] < A[minIndex])
				  {
					  minIndex = jj; //Update new position of minimum value
				  }
		  	}
	      temp = A[minIndex]; //Do swap here
		    A[minIndex] = A[nn];
		    A[nn] = temp;
	    }
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
      for( int nn = 1; nn <= (A.length-1);nn++) //start inserting at element 1
	    {
		    int ii, temp; 
		    ii = nn; //Start from the end and go backwards to the front
		    while( (ii > 0) && (A[ii-1] > A[ii])) //Insert into a sub-array of nn, uses > to keep the sort stable
	      {
			    temp = A[ii];
			    A[ii] = A[ii-1]; //Move inserted value (at ii) up by one via swapping [ii-1] with [ii]
			    A[ii-1] = temp;

			    ii = ii-1;
		    }
	    }
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
      mergeSortRecurse(A, 0, A.length - 1);
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
      int midIdx;
      if (leftIdx < rightIdx)
      {
        midIdx = (leftIdx + rightIdx) / 2;
        mergeSortRecurse(A, leftIdx, midIdx);
        mergeSortRecurse(A, midIdx + 1, rightIdx);
        merge(A, leftIdx, midIdx, rightIdx);
      }
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
      int[] tempArr = new int[rightIdx - leftIdx + 1];
      int ii = leftIdx;
      int jj = midIdx + 1;
      int kk = 0;

      while ((ii <= midIdx) && (jj <= rightIdx))
      {
          if (A[ii] <= A[jj])
          {
              tempArr[kk] = A[ii];
              ii++;
          }
          else
          {
              tempArr[kk] = A[jj];
              jj++;
          }

          kk++;
      }

      for (int i = ii; i <= midIdx; i++)
      {
          tempArr[kk] = A[i];
          kk++;
      }

      for (int j = jj; j <= rightIdx; j++)
      {
          tempArr[kk] = A[j];
          kk++;
      }

      for (int k = leftIdx; k <= rightIdx; k++)
      {
          A[k] = tempArr[k - leftIdx];
      }
    }//merge()

    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
      quickSortRecurse(A, 0, A.length - 1);
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
      int pivotIdx, newPivotIdx;
      if (rightIdx > leftIdx)
      {
          pivotIdx = (leftIdx + rightIdx) / 2;
          newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);
          quickSortRecurse(A, leftIdx, newPivotIdx - 1);
          quickSortRecurse(A, newPivotIdx + 1, rightIdx);
      }

    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
      int temp, pivotVal, currIdx, newPivotIdx;
      pivotVal =  A[pivotIdx];
      A[pivotIdx] = A[rightIdx];
      A[rightIdx] = pivotVal;
      currIdx = leftIdx;

      for (int i = leftIdx; i <= rightIdx - 1; i++)
      {
          if (A[i] < pivotVal)
          {
              temp = A[i];
              A[i] = A[currIdx];
              A[currIdx] = temp;
              currIdx++;
          }
      }

      newPivotIdx = currIdx;
      A[rightIdx] = A[newPivotIdx];
      A[newPivotIdx] = pivotVal;

      return newPivotIdx;
    }//doPartitioning

    public static void quickSortMedian3(int[] A)
    {
        quickSortMedian3Recurse(A, 0, A.length - 1);
    }

    private static void quickSortMedian3Recurse(int[] A, int leftIdx, int rightIdx)
    {
        int pivotVal, pivotIdx;
        if (rightIdx > leftIdx)
        {
            pivotVal = getMedian(A, leftIdx, rightIdx);
            pivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotVal);
            quickSortMedian3Recurse(A, leftIdx, pivotIdx - 1);
            quickSortMedian3Recurse(A, pivotIdx + 1, rightIdx);
        }
    }

    private static int getMedian(int[] A, int leftIdx, int rightIdx)
    {
        int centreIdx = (leftIdx + rightIdx) / 2;

        if (A[leftIdx] > A[centreIdx])
        {
            swap(A, leftIdx, centreIdx);
        }

        if (A[leftIdx] > A[rightIdx])
        {
            swap(A, leftIdx, rightIdx);
        }

        if (A[centreIdx] > A[rightIdx])
        {
            swap(A, centreIdx, rightIdx);
        }

        swap(A, centreIdx, rightIdx);

        return rightIdx;
    }

    public static void quickSortRandom(int[] A)
    {
        quickSortRandomRecurse(A, 0, A.length - 1);
    }

    private static void quickSortRandomRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int pivotVal, pivotIdx;

        if (rightIdx > leftIdx)
        {
            pivotVal = getRandom(A, leftIdx, rightIdx);
            pivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotVal);
            quickSortRandomRecurse(A, leftIdx, pivotIdx - 1);
            quickSortRandomRecurse(A, pivotIdx + 1, rightIdx);
        }
    }

    private static int getRandom(int[] A, int leftIdx, int rightIdx)
    {
        Random rand = new Random();
        int pivot = rand.nextInt(rightIdx - leftIdx) + leftIdx;

        return pivot;
    }

    private static void swap(int[] A, int leftIdx, int rightIdx)
    {
        int temp;
        temp = A[leftIdx];
        A[leftIdx] = A[rightIdx];
        A[rightIdx] = temp;
    }
}//end Sorts calss

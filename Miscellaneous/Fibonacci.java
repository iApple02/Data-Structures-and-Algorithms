public class Fibonacci
{
    public static int fibRecursive(int n)
    {
        int fibVal = 0;

        if (n < 0)
        {
            throw new IllegalArgumentException("Fibonacci number cannot be less than 0");
        }
        if (n == 0)
        {
            fibVal = 0; // Best case #1
        } 
        else if (n == 1)
        {
            fibVal = 1; // Best case #2
        }
        else
        {
            fibVal = fibRecursive(n-1) + fibRecursive(n-2); // Two recurisve caclls
        }
        return fibVal;
    }
}

// I found that after the input of 37, the program took longer because of recursion call.
// Around 44 onwards, the speed is reduced drastically
// The program does not output correct Fibonacci number after 46 due to limits of int data type.

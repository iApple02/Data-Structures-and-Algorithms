public class Factorials
{
    public static long calcFactorial(int n)
    {
        long factorial = 0;
        if(n == 0) // Base case 
        {
            factorial = 1; 
        }
        else if(n > 0)
        {
            factorial = n * calcFactorial(n-1);
        }
        else
        {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        return factorial; 
    }
}
//Adapted from https://stackoverflow.com/questions/28928046/java-greatest-common-divisor-recursion

public class GreatestCommonDenominator
{
    public static int GCD(int num1, int num2)
    {
        if(num1 < 0)
        {
            throw new IllegalArgumentException("Negative numbere entered");
        }
        if(num2 < 0)
        {
            throw new IllegalArgumentException("Negative numbere entered");
        }
        if(num2 == 0)
        {
            return num1;
        }
        else
        {
            return(GCD(num2, num1 % num2));
        } 
    }
}

// No performance issues found
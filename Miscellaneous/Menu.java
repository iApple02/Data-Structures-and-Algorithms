import java.util.*;

public class Menu
{
    public static void main(String[] args)
    {
        int choice = 0;
        int fibonacci, n, num1, num2, disk, src, dest;
        long factorial;
        System.out.println("1: Calculate Factorials \n2: Calculate Fibonacci's Sequence");
        System.out.println("3. Calcuate Greatest Common Denominator \n4: Towers of Hanoi");
        
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        switch(choice)
        { 
            case 1:
                System.out.println("Choose a number for factorial calculation");
                n = sc.nextInt();
                factorial = Factorials.calcFactorial(n);
                System.out.println("The factorial for " + n + "! is " + factorial);
                break;       
            case 2:
                System.out.println("Choose a number for Fibonacci sequence calculation");
                n = sc.nextInt();
                fibonacci = Fibonacci.fibRecursive(n);
                System.out.println("The Fibonacci number for " + n + " is " + fibonacci);
                break;
            case 3:
                System.out.println("Enter first number");
                num1 = sc.nextInt();
                System.out.println("Enter second number");
                num2 = sc.nextInt();
                System.out.println("The GCD of " + num1 + " and " + num2 + " is " + GreatestCommonDenominator.GCD(num1,num2));
                break;
            case 4:
                System.out.println("Enter amount of disk: ");
                disk = sc.nextInt();
                System.out.println("Enter source location of disk: ");
                src = sc.nextInt();
                System.out.println("Enter destination of disk: ");
                dest = sc.nextInt();
                TowerOfHanoi.tower(disk,src,dest);
                break;
            default:
                System.out.println("Invalid input entered");
        }
    }
}